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
            title = "Первые шаги во вклады",
            level = 0,
            description = "Первые шаги во вкладах для начинающих",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Вклад",
            favourite = false,
            price = 1000
        ),
        Education(
            id = 1,
            title = "Первые шаги в инвестирование",
            level = 0,
            description = "Первые шаги на бирже для начинающих",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Вклад",
            favourite = false,
            price = 1000
        ),
        Education(
            id = 2,
            title = "Первые шаги в кредитовании",
            level = 0,
            description = "Первые шаги в кредитовании для начинающих",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Вклад",
            favourite = false,
            price = 1000
        ),
        Education(
            id = 4,
            title = "Фьючерс - это ... репер?",
            level = 0,
            description = "Расскажем, что такое фьючерсы и научим ими пользоватся.",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_2,
            category = "Биржа",
            favourite = false,
            price = 5000
        ),
        Education(
            id = 5,
            title = "Страхование вкладов",
            level = 0,
            description = "Расскажем, что такое страхование вкладов и почему стоит выбирать именно такие вклады.",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_2,
            category = "Вклад",
            favourite = false,
            price = 5000
        ),
        Education(
            id = 6,
            title = "Потреб или целевой кредит",
            level = 0,
            description = "Какой кредит выбрать и что проще получить?",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_2,
            category = "Кредитование",
            favourite = false,
            price = 5000
        ),
        Education(
            id = 10,
            title = "Шорты",
            level = 1,
            description = "Что такое «шорты» или как заработать на падении акций",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Биржа",
            favourite = false,
            price = 10000
        ),
        Education(
            id = 11,
            title = "Рефинансирование",
            level = 1,
            description = "Выплатить до конца или взять еще денег, как поступить?",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_0,
            category = "Кредитование",
            favourite = false,
            price = 10000
        ),
        Education(
            id = 22,
            title = "Причины инфляции",
            level = 2,
            description = "Почему же все дорожает?",
            content = "Какой крутой контент",
            thumb = R.drawable.avatar_4,
            category = "Вклад",
            favourite = false,
            price = 100000
        ),
    )

}