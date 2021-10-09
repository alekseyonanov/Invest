package ru.grokkers.invest.ui.fragment.greetingfragment.interactor

import dagger.hilt.EntryPoint
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.UserRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class GreetingInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun saveUser(user: User) {
        userRepository.add(user)
    }

    suspend fun getUser() = userRepository.user()
}