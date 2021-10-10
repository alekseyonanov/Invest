package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.Sample
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.UserRepository
import ru.grokkers.invest.ui.base.BaseViewModel
import javax.inject.Inject

/**
 *
 *
 * @author Onanov Aleksey (@onanov)
 */
@HiltViewModel
class CreditViewModel @Inject constructor(
    application: Application,
    private val userRepository: UserRepository
) : BaseViewModel(application) {

    lateinit var investmentsState: Flow<List<Investment>>

    private var user: User? = null

    override fun onStart() {
        viewModelScope.launch {
            userRepository.user().collect {
                user = it
            }
        }

        investmentsState = flow {
            emit(Sample.credit)
        }.map {
            it.map {
                it.isExtended = user?.hasBoughtCredit == true
                it
            }
        }
    }
}