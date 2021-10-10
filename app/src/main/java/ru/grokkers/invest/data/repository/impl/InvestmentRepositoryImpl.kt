package ru.grokkers.invest.data.repository.impl

import kotlinx.coroutines.flow.Flow
import ru.grokkers.invest.data.db.AppDatabase
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.data.repository.InvestmentRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class InvestmentRepositoryImpl @Inject constructor(appDatabase: AppDatabase) :
    InvestmentRepository {

    private val dao = appDatabase.investmentDao()

    override fun getItems(): Flow<List<Investment>> = dao.items()

    override suspend fun update(item: Investment) {
        dao.update(item)
    }

    override suspend fun insert(list: List<Investment>) {
        dao.insert(list)
    }
}