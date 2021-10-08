package ru.grokkers.invest.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * @author Onanov Aleksey (@onanov)
 */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private var isStarted: Boolean = false

    protected abstract fun onStart()

    fun start() {
        if (!isStarted) {
            isStarted = true
            onStart()
        }
    }

    protected fun <T> emit(flow: MutableStateFlow<T>, value: T) {
        viewModelScope.launch {
            flow.emit(value)
        }
    }

    protected fun <T> emit(flow: MutableSharedFlow<T>, value: T) {
        viewModelScope.launch {
            flow.emit(value)
        }
    }

}