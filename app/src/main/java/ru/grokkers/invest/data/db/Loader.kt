package ru.grokkers.invest.data.db

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.grokkers.invest.BuildConfig
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
class Loader @Inject constructor(@ApplicationContext private val context: Context) {
    /*
    * Показать спотлайт карт
    */
    var purchasedEducations: List<Int>
        set(value) = context.getSharedPreferences(APP, Context.MODE_PRIVATE).edit()
            .putString(PURCHASED_EDUCATIONS, value.joinToString(",")).apply()
        get() = context.getSharedPreferences(APP, Context.MODE_PRIVATE)
            .getString(PURCHASED_EDUCATIONS, "")?.split(",")
            ?.map { if (it.isNotBlank()) it.toInt() else -1 } ?: emptyList()

    companion object {
        /*
        * Категории данных
        */
        private const val APP = BuildConfig.APPLICATION_ID

        /*
        * Наименование полей
        */
        private const val PURCHASED_EDUCATIONS = "purchased_educations"

    }
}