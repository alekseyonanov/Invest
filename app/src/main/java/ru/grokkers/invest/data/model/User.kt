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
    var education: String = ""
)

enum class UserType(val value: String) {
    STUDENT("Студент"), WORKER("Работаю"), PENSIONER("На пенсии")
}