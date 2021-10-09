package ru.grokkers.invest.ui.fragment.greetingfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.grokkers.invest.App
import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.RegistrationSteps
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.model.UserType
import ru.grokkers.invest.navigation.Navigator
import ru.grokkers.invest.ui.base.BaseViewModel
import ru.grokkers.invest.ui.fragment.greetingfragment.interactor.GreetingInteractor
import ru.grokkers.invest.ui.state.EducationState
import java.util.*
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class GreetingViewModel @Inject constructor(
    application: Application,
    private val interactor: GreetingInteractor,
    private val navigator: Navigator
) : BaseViewModel(application) {

    private val _messagesState = MutableStateFlow<List<Pair<String, Boolean>>>(listOf())
    val messagesState = _messagesState.asStateFlow()

    private val _newMessageState = MutableSharedFlow<Pair<String, Boolean>>()
    val newMessageState = _newMessageState.asSharedFlow()

    private val _lifestyleState = MutableSharedFlow<Boolean>()
    val lifestyleState = _lifestyleState.asSharedFlow()

    private val _ageState = MutableSharedFlow<Boolean>()
    val ageState = _ageState.asSharedFlow()

    private var greetingMessages = listOf<String>()
        set(value) {
            field = value
            iterator = value.iterator()
        }

    private lateinit var iterator: Iterator<String>

    private var currentStep: RegistrationSteps = RegistrationSteps.NAME

    private var user = User()

    override fun onStart() {
        viewModelScope.launch {
            loadUser()
        }
    }

    private suspend fun loadUser() {
        interactor.getUser().collect {
            if (it == null) {
                greetingMessages =
                    getApplication<App>().resources.getStringArray(R.array.greeting_messages)
                        .toList()
                iterator = greetingMessages.iterator()

                emit(
                    _messagesState,
                    listOf(iterator.next() to false, iterator.next() to false)
                )
            } else {
                navigator.navigateToStore()
            }
        }
    }

    fun onSendClicked(string: String) {
        emit(_newMessageState, Pair(string, true))
        when (currentStep) {
            RegistrationSteps.NAME -> {
                user.name = string
                currentStep = RegistrationSteps.AGE
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        emit(_newMessageState, Pair(iterator.next(), false))
                        emit(_ageState, true)
                    }
                }, 1000)
            }
            RegistrationSteps.AGE -> {
                user.age = string.toIntOrNull()
                emit(_ageState, false)
                currentStep = RegistrationSteps.LIFE
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        emit(_newMessageState, Pair(iterator.next(), false))
                        emit(_lifestyleState, true)
                    }
                }, 1000)
            }
            RegistrationSteps.LIFE -> {
                user.userType = UserType.values().find { it.value == string } ?: UserType.STUDENT

                currentStep = RegistrationSteps.EDUCATION
                emit(_lifestyleState, false)
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        emit(_newMessageState, Pair(iterator.next(), false))
                    }
                }, 1000)
            }
            RegistrationSteps.EDUCATION -> {
                user.education = string
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        emit(_newMessageState, Pair(iterator.next(), false))
                    }
                }, 1000)

                viewModelScope.launch {
                    delay(2000)
                    interactor.saveUser(user)
                    navigator.navigateToStore()
                }
            }
        }
    }
}