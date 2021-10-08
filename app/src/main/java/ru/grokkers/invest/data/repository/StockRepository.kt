package ru.grokkers.invest.data.repository

import ru.grokkers.invest.data.model.Stock

/**
 * @author Onanov Aleksey (@onanov)
 */
interface StockRepository {

    fun add(model: Stock)

    fun add(list: List<Stock>)

    fun update(model: Stock)

    fun clear()

}