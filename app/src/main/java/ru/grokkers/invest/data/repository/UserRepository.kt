package ru.grokkers.invest.data.repository

import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.User

/**
 * @author Onanov Aleksey (@onanov)
 */
interface UserRepository {

    fun user(): Flow<User?>

    suspend fun add(user: User)

    suspend fun update(user: User)

    suspend fun clear()

}