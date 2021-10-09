package ru.grokkers.invest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Onanov Aleksey (@onanov)
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String = "",
    var age: Int? = null,
    var userType: UserType = UserType.STUDENT,
    var education: String = "",
    var money: Int = 0,
    var creditSum: Int = 0,
    var city: String = "",
    var workType: String = "",
    val productivity: Int = 2,
    var clickes: Long = 0
)

enum class UserType(val value: String, val salary: Int) {
    STUDENT("Студент", 20000),
    WORKER("Работаю", 40000),
    PENSIONER("На пенсии", 15000)
}