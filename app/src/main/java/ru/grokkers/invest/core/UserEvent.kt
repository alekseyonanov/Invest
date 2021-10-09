package ru.grokkers.invest.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
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

    private var userModel: User? = null

    override fun init() {
        GlobalScope.launch {
            userRepository.user().collect { user ->
                user?.let {
                    userModel = it
                    processWorkUser(it)
                    processTicket(it)
                    if (user.userType != UserType.PENSIONER) {
                        processTicket(it)
                    }
                }
            }
        }
        launchUserEvents()
    }

    private suspend fun processTicket(user: User) {
        val isEvent = Random.nextInt(0, 250) == 60
        if (user.clickes > lastClickes && isEvent) {
            eventListener.invoke(Events.TICKET)
            user.money -= 1000
            userRepository.update(user)
        }
    }

    private suspend fun processWorkUser(user: User) {
        val isEvent = Random.nextInt(0, 200) == 100

        if (isEvent) {
            when {
                user.clickes < 1000 -> {
                    eventListener.invoke(Events.OVERWORK)
                    user.money -= 1000
                }
                user.clickes < 5000 -> {
                    eventListener.invoke(Events.TO_MUCH_WORK)
                    user.money -= 2000
                }
                else -> {
                    eventListener.invoke(Events.PLS_STOP_WORK)
                    user.money -= 5000
                    user.clickes -= 1000
                }
            }


            if (user.money < 0) user.money = 0
            userRepository.update(user)
            lastClickes = user.clickes
        }
    }


    private fun launchUserEvents() {
        GlobalScope.launch {
            while (true) {
                delay(1000)
                when (userModel?.userType) {
                    UserType.STUDENT -> studentEvents()
                    UserType.WORKER -> workersEvents()
                    UserType.PENSIONER -> pensionerEvents()
                    null -> continue
                }
            }
        }
    }

    private suspend fun workersEvents() {
        userModel?.let {
            val event = when {
                Random.nextInt(1, 100) == 25 -> {
                    if (Random.nextBoolean()) Events.HOME else Events.INTERNET
                }
                Random.nextInt(1, 250) == 100 -> {
                    Events.TELEPHONE
                }
                Random.nextInt(1, 150) == 50 -> {
                    if (Random.nextBoolean()) Events.CLOTHES else Events.FRIENDS
                }
                else -> null
            }

            if (event != null) {
                eventListener.invoke(event)
                it.money -= event.model.value
                if (it.money < 0) it.money = 0
                userRepository.update(it)
            }
        }
    }

    private suspend fun studentEvents() {
        userModel?.let {
            when {
                Random.nextInt(1, 150) == 25 -> {
                    eventListener.invoke(Events.HOMEWORK)
                    it.money -= Events.HOMEWORK.model.value
                }
                Random.nextInt(1, 200) == 50 -> {
                    eventListener.invoke(Events.TRANSPORT)
                    it.money -= Events.TRANSPORT.model.value
                }
                Random.nextInt(1, 300) == 100 -> {
                    eventListener.invoke(Events.EXAM)
                    it.money -= Events.EXAM.model.value
                }
                Random.nextInt(1, 400) == 50 -> {
                    eventListener.invoke(Events.TECHNIQUE)
                    it.money -= Events.TECHNIQUE.model.value
                    it.clickes -= 100
                }
            }


            if (it.money < 0) it.money = 0
            userRepository.update(it)
            lastClickes = it.clickes
        }
    }

    private suspend fun pensionerEvents() {
        userModel?.let {
            when {
                Random.nextInt(1, 80) == 25 -> {
                    eventListener.invoke(Events.HELP)
                    it.money -= Events.HELP.model.value
                }
                Random.nextInt(1, 200) == 100 -> {
                    eventListener.invoke(Events.MEDICAL)
                    it.money -= Events.MEDICAL.model.value
                }
                Random.nextInt(1, 150) == 50 -> {
                    eventListener.invoke(Events.GOVERNMENT)
                    it.money -= Events.GOVERNMENT.model.value
                }
            }


            if (it.money < 0) it.money = 0
            userRepository.update(it)
            lastClickes = it.clickes
        }

    }

}
