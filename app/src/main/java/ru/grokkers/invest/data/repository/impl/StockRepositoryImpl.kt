package ru.grokkers.invest.data.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.grokkers.invest.data.db.dao.StockDao
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.data.repository.StockRepository
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
class StockRepositoryImpl @Inject constructor(private val dao: StockDao) : StockRepository {
    
    override fun getAllStock(): Flow<List<Stock>> = flow {
        // TODO: 09.10.2021 implement 
    }

    override fun add(model: Stock) {
    }

    override fun add(list: List<Stock>) {
    }

    override fun update(model: Stock) {
    }

    override fun clear() {
    }
}