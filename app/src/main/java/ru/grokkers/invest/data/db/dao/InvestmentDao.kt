package ru.grokkers.invest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.Investment

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@Dao
interface InvestmentDao {
    @Query("SELECT * FROM investment")
    fun items(): Flow<List<Investment>>

    @Update
    suspend fun update(item: Investment)

    @Insert
    suspend fun insert(list: List<Investment>)
}