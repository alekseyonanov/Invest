package ru.grokkers.invest.ui.fragment.education.detail

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.navigation.Navigator
import ru.grokkers.invest.ui.base.BaseViewModel
import javax.inject.Inject

/**
 *
 *
 * @author Onanov Aleksey (@onanov)
 */
@HiltViewModel
class EducationDetailViewModel @Inject constructor(
    application: Application,
    savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
) : BaseViewModel(application) {

    private val education = savedStateHandle.get<Education>("EDUCATION") as Education

    override fun onStart() {

    }

    fun onBackClicked() {
        navigator.navigateBack()
    }

    fun onFabClicked() {
        navigator.navigateToStore()
    }

}