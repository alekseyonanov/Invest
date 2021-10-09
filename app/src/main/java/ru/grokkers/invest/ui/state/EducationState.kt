package ru.grokkers.invest.ui.state

import ru.grokkers.invest.data.model.Education

/**
 * @author Onanov Aleksey (@onanov)
 */
sealed class EducationState {
    data class Loading(val isLoading: Boolean) : EducationState()
    data class Success(val items: List<Education>) : EducationState()
    object Error : EducationState()
}