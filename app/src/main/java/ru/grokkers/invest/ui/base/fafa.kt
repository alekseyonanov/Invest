package ru.grokkers.invest.ui.base

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

/**
 * @author Doroshenko Vyacheslav
 */
class SimpleMutableStateFlow<T : Any> : StateFlowWithoutInitialValue<T> {

    private val mutable = MutableStateFlow<T?>(null)

    override val value: T?
        get() = mutable.value

    override fun propose(value: T) {
        mutable.value = value
    }

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<T>) = mutable.filterNotNull()
        .collect(collector)
}


interface StateFlowWithoutInitialValue<Type : Any> : Flow<Type> {

    val value: Type?

    fun propose(value: Type)
}
