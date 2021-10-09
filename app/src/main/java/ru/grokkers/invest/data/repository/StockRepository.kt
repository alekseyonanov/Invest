package ru.grokkers.invest.data.repository

import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.Stock

/**
 * @author Onanov Aleksey (@onanov)
 */
interface StockRepository {

    fun getAllStock(): Flow<List<Stock>>

    fun getMoney(): Flow<Int>

    suspend fun add(model: Stock)

    suspend fun add(list: List<Stock>)

    suspend fun update(model: Stock)

    suspend fun clear()

}