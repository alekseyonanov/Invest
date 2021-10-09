package ru.grokkers.invest.core.model

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
data class EventModel(
    var title: String = "",
    var description: String = "",
    val value: Int = 0
)

enum class Events(val model: EventModel) {
    // Work
    OVERWORK(
        EventModel(
            title = "Усталость",
            description = "Вы слишком много работали и заболели. Вы идете ко врачу, он выписывает вам лекарства и советует меньше работать. Заплатите 1000Р.\nСовет: обрати внимание на пассивный доход",
            value = 1000
        )
    ),
    TO_MUCH_WORK(
        EventModel(
            title = "Усталость",
            description = "Вы слишком много работали и заболели. Вы идете ко врачу, он выписывает вам лекарства и снова советует меньше работать. Заплатите 2000Р.\nСовет: обрати внимание на пассивный доход",
            value = 2000
        )
    ),
    PLS_STOP_WORK(
        EventModel(
            title = "Усталость",
            description = "Вы слишком много работали и не слушали советы. Вы получаете серьезные осложенения и вам назначают операцию. Заплатите 5000.\nСовет: обрати внимание на пассивный доход",
            value = 2000
        )
    ),
    TICKET(
        EventModel(
            title = "Штраф",
            description = "Вы ошиблись на работе и получили штраф Заплатите 1000.\nСовет: обрати внимание на пассивный доход",
            value = 1000
        )
    ),

    /*// Student
    HOMEWORK, TRANSPORT, TECHNIQUE, EXAM,

    // Worker
    HOME, INTERNET, TELEPHONE, CLOTHES, TAXES, ILL, FRIENDS,

    // Pensioner
    HELP, MEDICAL, GOVERNMENT, FAMILY, COMPENSATION*/
}
