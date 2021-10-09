package ru.grokkers.invest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author Onanov Aleksey (@onanov)
 */
@Entity(tableName = "stock")
data class Stock(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Double = 0.0,
    val currencySymbol: String,
    val message: String,
)