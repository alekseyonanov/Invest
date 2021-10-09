package ru.grokkers.invest.ui.fragment.work

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.ui.base.BaseViewModel
import ru.grokkers.invest.ui.fragment.work.interactor.WorkInteractor
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class WorkViewModel @Inject constructor(
    application: Application,
    private val interactor: WorkInteractor
) : BaseViewModel(application) {

    private val _userState = MutableSharedFlow<User?>()
    val userState = _userState.asSharedFlow()

    private val _timeState = MutableStateFlow(0)
    val timeState = _timeState.asStateFlow()

    private var currentUser: User? = null

    private var currentTime = 0

    override fun onStart() {
        viewModelScope.launch {
            loadUser()
        }
    }

    private suspend fun loadUser() {
        interactor.getUser().collect {
            currentUser = it
            emit(_userState, it)
        }
    }

    fun onButtonClicked() {
        currentTime = (currentTime + 2) % 24

        emit(_timeState, currentTime)

        if (currentTime == 0 && currentUser != null) {
            currentUser!!.money += currentUser!!.userType.salary / 30
            viewModelScope.launch {
                interactor.updateUser(currentUser!!)
                _userState.emit(currentUser)
            }
        }
    }
}