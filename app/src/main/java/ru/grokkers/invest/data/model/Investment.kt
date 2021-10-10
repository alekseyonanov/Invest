package ru.grokkers.invest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@Entity(tableName = "investment")
data class Investment(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var title: String = "",
    var owner: String = "",
    var sum: Int = 0,
    var percent: Int = 0,
    var reliability: Double = 1.0
)
