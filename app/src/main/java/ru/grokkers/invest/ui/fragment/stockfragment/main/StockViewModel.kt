package ru.grokkers.invest.ui.fragment.stockfragment.main

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.StockRepository
import ru.grokkers.invest.data.repository.UserRepository
import ru.grokkers.invest.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class StockViewModel @Inject constructor(
    application: Application,
    private val repository: StockRepository,
    val stateHandle: SavedStateHandle,
    private val userRepository: UserRepository,
) : BaseViewModel(application) {

    lateinit var stockFlow: Flow<List<Stock>>

    val money = repository.getMoney().stateIn(viewModelScope, SharingStarted.Lazily, 0)

    private var user: User? = null

    override fun onStart() {
        /* no-op */

        viewModelScope.launch {
            userRepository.user().collect {
                user = it
            }
        }

        stockFlow =
            repository.getAllStock().map {
                it.map {
                    it.isExtended = user?.hasBoughtInvestment == true
                    it
                }
            }

    }


}