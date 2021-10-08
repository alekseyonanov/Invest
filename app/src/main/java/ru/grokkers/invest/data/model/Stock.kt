package ru.grokkers.invest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Onanov Aleksey (@onanov)
 */
@Entity(tableName = "stock")
data class Stock(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Double,
)