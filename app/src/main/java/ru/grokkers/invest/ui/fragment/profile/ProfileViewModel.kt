package ru.grokkers.invest.ui.fragment.profile

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.ui.base.BaseViewModel
import ru.grokkers.invest.ui.fragment.profile.interactor.ProfileInteractor
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    application: Application,
    private val interactor: ProfileInteractor
) : BaseViewModel(application) {

    private val _userState = MutableSharedFlow<User?>()
    val userState = _userState.asSharedFlow()

    private var user: User? = null

    override fun onStart() {
        viewModelScope.launch {
            loadUser()
        }
    }

    private suspend fun loadUser() {
        interactor.loadUser().collect {
            user = it
            emit(_userState, it)
        }
    }
}