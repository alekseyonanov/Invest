package ru.grokkers.invest.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.grokkers.invest.core.model.Events
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.model.UserType
import ru.grokkers.invest.data.repository.UserRepository
import kotlin.random.Random

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class UserEvent constructor(
    private val userRepository: UserRepository,
    private val eventListener: (event: Events) -> Unit
) : Event {

    private var lastClickes = 0L

    override fun init() {
        GlobalScope.launch {
            userRepository.user().collect { user ->
                user?.let {
                    when (user.userType) {
                        UserType.STUDENT -> processStudent(it)
                        UserType.WORKER -> processWorkUser(it)
                        UserType.PENSIONER -> processPensioner(it)
                    }
                    if (user.userType != UserType.PENSIONER) {
                        processTicket(it)
                    }
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

    private suspend fun processStudent(user: User) {
        val isEvent = Random.nextInt(0, 40) == 1
        if (isEvent) {
            if (user.clickes < 100) {
                eventListener.invoke(Events.HOMEWORK)
                user.money -= Events.HOMEWORK.model.value
            } else if (user.clickes < 200) {
                eventListener.invoke(Events.TRANSPORT)
                user.productivity = 1
            } else if (user.clickes < 500) {
                eventListener.invoke(Events.EXAM)
                user.productivity = 1
            } else {
                eventListener.invoke(Events.TECHNIQUE)
                user.money -= Events.TRANSPORT.model.value
                user.clickes -= 100
            }


            if (user.money < 0) user.money = 0
            userRepository.update(user)
            lastClickes = user.clickes
        }
    }

    private suspend fun processPensioner(user: User) {
        val isEvent = Random.nextInt(0, 40) == 1
        if (isEvent) {
            if (user.clickes < 100) {
                eventListener.invoke(Events.HELP)
                user.money -= Events.HELP.model.value
            } else if (user.clickes < 200) {
                eventListener.invoke(Events.MEDICAL)
                user.money -= Events.MEDICAL.model.value
            } else {
                eventListener.invoke(Events.GOVERNMENT)
                user.money -= Events.GOVERNMENT.model.value
            }


            if (user.money < 0) user.money = 0
            userRepository.update(user)
            lastClickes = user.clickes
        }
    }

}
