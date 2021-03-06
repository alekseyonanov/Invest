package ru.grokkers.invest.ui.fragment.education.list

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.EducationRepository
import ru.grokkers.invest.data.repository.UserRepository
import ru.grokkers.invest.navigation.Navigator
import ru.grokkers.invest.ui.base.BaseViewModel
import ru.grokkers.invest.ui.state.EducationState
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
@HiltViewModel
class EducationListViewModel @Inject constructor(
    application: Application,
    private val navigator: Navigator,
    private val userRepository: UserRepository,
    private val educationRepository: EducationRepository,
) :
    BaseViewModel(application) {

    private val _uiState = MutableStateFlow<EducationState>(EducationState.Loading(true))
    val uiState = _uiState.asStateFlow()

    private val _payment = MutableSharedFlow<Education>()
    val payment = _payment.asSharedFlow()


    private lateinit var user: User

    override fun onStart() {
        viewModelScope.launch {
            userRepository.user().collect {
                user = it!!
            }
        }
        loadContent()
    }

    fun onItemClicked(education: Education) {
        navigator.navigateToEducationDetails(education)
    }

    fun onLockedClicked(education: Education): Boolean {
        if (user.money >= education.price) {
            emit(_payment, education)
        }
        return user.money >= education.price
    }

    fun onPaymentSuccess(education: Education) {
        educationRepository.purchased(education.id)
        user.money -= education.price

        processPayment(education)

        viewModelScope.launch {
            userRepository.update(user)
        }
        emit(_uiState, EducationState.Error)
        loadContent()
    }

    private fun processPayment(education: Education) {
        when (education.category) {
            "??????????" -> user.hasBoughtDeposit = true
            "??????????" -> user.hasBoughtInvestment = true
            "????????????????????????" -> user.hasBoughtCredit = true
        }
    }

    private fun loadContent() {
        emit(_uiState, EducationState.Success(educationRepository.educations()))
    }

}