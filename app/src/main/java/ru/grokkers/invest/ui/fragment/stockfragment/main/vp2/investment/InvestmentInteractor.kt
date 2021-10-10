package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment

import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.InvestmentRepository
import ru.grokkers.invest.data.repository.UserRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class InvestmentInteractor @Inject constructor(private val repository: InvestmentRepository, private val userRepository: UserRepository) {

    fun getItems() = repository.getItems()

    suspend fun update(item: Investment) {
        repository.update(item)
    }


    suspend fun insert(list: List<Investment>) {
        repository.insert(list)
    }

    suspend fun getUser() = userRepository.user()

    suspend fun updateUser(user: User) {
        userRepository.update(user)
    }
}