package ru.grokkers.invest.data.repository

import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.Stock

/**
 * @author Onanov Aleksey (@onanov)
 */
interface StockRepository {

    fun getAllStock(): Flow<List<Stock>>

    fun add(model: Stock)

    fun add(list: List<Stock>)

    fun update(model: Stock)

    fun clear()

}