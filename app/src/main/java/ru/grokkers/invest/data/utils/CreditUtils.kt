package ru.grokkers.invest.data.utils

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
fun calculateMonthCreditSum(credit: Int, month: Int = 12, percent: Int = 15): Int {
    val p = percent.toDouble() / 100 / 12
    return credit*(p+ p/((1 + p).pow(month) - 1)).roundToInt()
}