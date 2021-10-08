package ru.grokkers.invest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Onanov Aleksey (@onanov)
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
)