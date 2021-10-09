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
        Education(
            id = 1,
            title = "Что такое Вклад?",
            level = 0,
            description = "Почему стоит хранить деньги в банке и использовать вклады.",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_1,
            category = "Вклад",
            favourite = false
        ),
        Education(
            id = 2,
            title = "Фьючерс - это ... репер?",
            level = 0,
            description = "Расскажем, что такое фьючерсы и научим ими пользоватся.",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_2,
            category = "Биржа",
            favourite = false
        ),
        Education(
            id = 10,
            title = "Шорты",
            level = 1,
            description = "Что такое «шорты» или как заработать на падении акций",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Вклад",
            favourite = false
        ),
        Education(
            id = 22,
            title = "Причины инфляции",
            level = 2,
            description = "Почему же все дорожает?",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_4,
            category = "Биржа",
            favourite = false
        ),
    )

}