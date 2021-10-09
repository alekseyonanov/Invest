package ru.grokkers.invest.ui.fragment.work.interactor

import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.UserRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class WorkInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun getUser() = userRepository.user()

    suspend fun updateUser(user: User) {
        userRepository.update(user)
    }
}