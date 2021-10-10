package ru.grokkers.invest.data.repository

import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.model.Investment

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
interface InvestmentRepository {
    fun getItems(): Flow<List<Investment>>
    suspend fun update(item: Investment)
    suspend fun insert(list: List<Investment>)
}