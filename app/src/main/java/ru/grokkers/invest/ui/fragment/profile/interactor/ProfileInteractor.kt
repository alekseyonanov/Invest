package ru.grokkers.invest.ui.fragment.profile.interactor

import ru.grokkers.invest.data.repository.UserRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class ProfileInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun loadUser() = userRepository.user()
}