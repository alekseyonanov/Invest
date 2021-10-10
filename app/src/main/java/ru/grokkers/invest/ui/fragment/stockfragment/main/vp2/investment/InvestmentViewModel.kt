package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.Sample
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
@HiltViewModel
class InvestmentViewModel @Inject constructor(
    application: Application,
    private val interactor: InvestmentInteractor
) : BaseViewModel(application) {

    lateinit var investmentsState: Flow<List<Investment>>

    private var user: User? = null

    override fun onStart() {
        viewModelScope.launch {
            interactor.getUser().collect {
                user = it
            }
        }

        investmentsState = interactor.getItems().map {
            it.map {
                it.isExtended = user?.hasBoughtDeposit == true
                it
            }
        }
    }

    fun generateList() {
        viewModelScope.launch {
            interactor.insert(Sample.investments)
        }
    }

    fun onInvestmentSelected(model: Investment, sum: Int) {
        viewModelScope.launch {
            user?.let {
                if (it.money > sum) {
                    model.sum += sum
                    interactor.update(model)
                    it.money -= sum
                    interactor.updateUser(it)
                }
            }
        }
    }
}