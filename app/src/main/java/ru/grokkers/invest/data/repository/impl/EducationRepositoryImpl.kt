package ru.grokkers.invest.data.repository.impl

import dagger.hilt.android.qualifiers.ApplicationContext
import ru.grokkers.invest.data.Sample
import ru.grokkers.invest.data.db.Loader
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.data.repository.EducationRepository
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationRepositoryImpl @Inject constructor(private val loader: Loader) :
    EducationRepository {

    override fun educations(): List<Education> {
        val purchasedEducationIds = loader.purchasedEducations
        return Sample.education.map { education ->
            education.isLocked = education.id !in purchasedEducationIds
            education
        }
    }

    override fun purchased(id: Int) {
        val list = loader.purchasedEducations.toMutableList()
        list.add(id)

        loader.purchasedEducations = list
    }
}