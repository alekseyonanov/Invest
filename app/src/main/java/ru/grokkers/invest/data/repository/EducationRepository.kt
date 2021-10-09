package ru.grokkers.invest.data.repository

import ru.grokkers.invest.data.model.Education

/**
 * @author Onanov Aleksey (@onanov)
 */
interface EducationRepository {

    fun educations(): List<Education>

    fun purchased(id: Int)

}