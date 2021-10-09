package ru.grokkers.invest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.grokkers.invest.data.db.dao.StockDao
import ru.grokkers.invest.data.db.dao.UserDao
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.data.model.User

/**
 * База данных приложения
 *
 * @author Onanov Aleksey (@onanov)
 */
@Database(
    version = 4,
    exportSchema = false,
    entities = [
        User::class,
        Stock::class,
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stockDao(): StockDao
    abstract fun userDao(): UserDao
}