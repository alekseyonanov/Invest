package ru.grokkers.invest.ui.fragment.education

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.grokkers.invest.ui.base.BaseViewModel
import ru.grokkers.invest.ui.state.EducationState
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
@HiltViewModel
class EducationViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    private val _uiState = MutableStateFlow<EducationState>(EducationState.Loading(true))
    val uiState = _uiState.asStateFlow()

    private val _apiError = MutableSharedFlow<EducationState>()
    val apiError = _apiError.asSharedFlow()

    override fun onStart() {

    }

/*    private fun saveUser(name: String, lastName: String, password: String) {
        interactor.saveUser(name, lastName, password, phone)
            .onStart { _uiState.emit(AuthState.Loading(true)) }
            .onEach { activityRouter.navigateTo("Map") }
            .onCompletion { _uiState.emit(AuthState.Loading(false)) }
            .catch { cause ->
                when (cause) {
                    is ApiException -> _uiState.emit(AuthState.Error)
                    else -> _apiError.emit(ApiError(cause.message ?: ""))
                }
            }
            .launchIn(viewModelScope)
    }*/

}