package ru.grokkers.invest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Onanov Aleksey (@onanov)
 */
@Entity(tableName = "education")
data class Education(
    @PrimaryKey
    val id: Int,
    val title: String,
    val level: Int,
    val description: String,
    val content: String,
)
