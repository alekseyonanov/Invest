package ru.grokkers.invest.data

import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.Education

/**
 * @author Onanov Aleksey (@onanov)
 */
object Sample {

    val education = listOf<Education>(
        Education(
            id = 0,
            title = "Первые шаги",
            level = 0,
            description = "Первые шаги на бирже для начинающих",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Вклад",
            favourite = false
        ),

    )

}