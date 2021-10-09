package ru.grokkers.invest.data.repository.impl

import ru.grokkers.invest.data.db.dao.UserDao
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.UserRepository
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
class UserRepositoryImpl @Inject constructor(private val dao: UserDao) : UserRepository {

    override suspend fun user() = dao.user()

    override suspend fun add(user: User) {
        dao.add(user)
    }

    override suspend fun update(user: User) {
        dao.update(user)
    }

    override suspend fun clear() {
        dao.clear()
    }
}