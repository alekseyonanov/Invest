package ru.grokkers.invest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.grokkers.invest.data.db.dao.InvestmentDao
import ru.grokkers.invest.data.db.dao.StockDao
import ru.grokkers.invest.data.db.dao.UserDao
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.data.model.User

/**
 * База данных приложения
 *
 * @author Onanov Aleksey (@onanov)
 */
@Database(
    version = 6,
    exportSchema = false,
    entities = [
        User::class,
        Stock::class,
        Investment::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stockDao(): StockDao
    abstract fun userDao(): UserDao
    abstract fun investmentDao(): InvestmentDao
}