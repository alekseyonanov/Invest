package ru.grokkers.invest.ui.fragment.greetingfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import ru.grokkers.invest.ui.base.BaseViewModel
import ru.grokkers.invest.ui.state.EducationState
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class GreetingViewModel @Inject constructor(application: Application) :
    BaseViewModel(application) {

    private val _messagesState = MutableStateFlow<List<Pair<String, Boolean>>>(listOf())
    val messagesState = _messagesState.asStateFlow()

    override fun onStart() {
        emit(
            _messagesState,
            listOf(
                Pair("Привет", true),
                Pair("Привет", true),
                Pair("Привет", true),
                Pair("Привет", true)
            )
        )
    }
}