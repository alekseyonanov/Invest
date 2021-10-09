package ru.grokkers.invest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.Stock

/**
 * Dao авторизации
 *
 * @author Onanov Aleksey (@onanov)
 */
@Dao
interface StockDao {
    @Query("SELECT count(1) WHERE NOT EXISTS (SELECT * FROM stock)")
    fun isNotEmpty():Boolean

    @Query("SELECT * FROM stock")
    fun items(): Flow<List<Stock>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(list: List<Stock>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(model: Stock)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: Stock)

    @Query("DELETE FROM stock")
    suspend fun clear()

}