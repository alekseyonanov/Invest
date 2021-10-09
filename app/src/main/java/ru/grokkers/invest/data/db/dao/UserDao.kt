package ru.grokkers.invest.data.db.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.User

/**
 * Dao пользователя
 *
 * @author Onanov Aleksey (@onanov)
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user LIMIT 1")
    fun user(): Flow<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("DELETE FROM user")
    suspend fun clear()

}