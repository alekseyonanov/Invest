package ru.grokkers.invest.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.grokkers.invest.core.model.Events
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.UserRepository
import kotlin.random.Random

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class UserEvent constructor(
    private val userRepository: UserRepository,
    private val eventListener: (event: Events) -> Unit
): Event {

    private var lastClickes = 0L

    override fun init() {
        GlobalScope.launch {
            userRepository.user().collect { user ->
                user?.let {
                    processWorkUser(it)
                    processTicket(it)
                }
            }
        }
    }

    private suspend fun processTicket(user: User) {
        val isEvent = Random.nextInt(0, 70) == 1
        if (user.clickes > lastClickes && isEvent) {
            eventListener.invoke(Events.TICKET)
            user.money -= 1000
            userRepository.update(user)
        }
    }

    private suspend fun processWorkUser(user: User) {
        val isEvent = Random.nextInt(0, 40) == 1

        if (isEvent) {
            if (user.clickes < 1000) {
                eventListener.invoke(Events.OVERWORK)
                user.money -= 1000
            } else if (user.clickes < 5000) {
                eventListener.invoke(Events.TO_MUCH_WORK)
                user.money -= 2000
            } else {
                eventListener.invoke(Events.PLS_STOP_WORK)
                user.money -= 5000
                user.clickes -= 1000
            }


            if (user.money < 0) user.money = 0
            userRepository.update(user)
            lastClickes = user.clickes
        }
    }
}