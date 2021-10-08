package ru.grokkers.invest.ui.state

/**
 * @author Onanov Aleksey (@onanov)
 */
sealed class EducationState {
    data class Loading(val isLoading: Boolean) : EducationState()
    data class Success(val items: List<String>) : EducationState()
    object Error : EducationState()
}