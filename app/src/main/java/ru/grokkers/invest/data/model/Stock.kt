package ru.grokkers.invest.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * @author Onanov Aleksey (@onanov)
 */
@Entity(tableName = "stock")
data class Stock(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name",index = true)
    val name: String = "",
    @ColumnInfo(name = "price")
    val price: Double = 0.0,
    @ColumnInfo(name = "currencySymbol")
    val currencySymbol: String = "",
    @ColumnInfo(name = "message")
    val message: String = "",
    @ColumnInfo(name = "isExtended")
    var isExtended: Boolean = false,
    @ColumnInfo(name = "reliability")
    val reliability: Double = 0.5,
)