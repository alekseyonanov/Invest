package ru.grokkers.invest.ui.fragment.storefragment

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.data.repository.StockRepository
import ru.grokkers.invest.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class StockViewModel @Inject constructor(
    application: Application,
    private val repository: StockRepository,
    val stateHandle: SavedStateHandle
) : BaseViewModel(application) {

    val stockFlow = repository.getAllStock().stateIn(viewModelScope, SharingStarted.Lazily, listOf())

    override fun onStart() {
        /* no-op */
    }


    fun stockClick(stock : Stock){

    }



}