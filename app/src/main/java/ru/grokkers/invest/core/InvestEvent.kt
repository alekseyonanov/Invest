package ru.grokkers.invest.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.data.repository.InvestmentRepository
import ru.grokkers.invest.data.repository.UserRepository
import kotlin.math.roundToInt
import kotlin.random.Random

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class InvestEvent(
    private val investmentRepository: InvestmentRepository,
    private val userRepository: UserRepository
) : Event {

    private var invests = listOf<Investment>()
    private var credits = listOf<Investment>()
    private var deposits = listOf<Investment>()
    private var user: User? = null

    override fun init() {
        GlobalScope.launch {
            investmentRepository.getItems().collect {
                invests = it
            }
        }
        GlobalScope.launch {
            userRepository.user().collect {
                user = it
            }
        }
        GlobalScope.launch {
            launchInvestCycle()
            launchDepositCycle()
            launchCreditCycle()
        }
    }

    private suspend fun launchInvestCycle() {
        while (true) {
            delay(15000)
            invests.forEach { invest ->
                val end = (invest.reliability * 100).roundToInt()
                val success = if (end == 100) true else Random.nextInt(0, end) == 1
                user?.let {
                    it.money += if (success) (invest.sum.toDouble() * invest.percent.toDouble() / 100.0).roundToInt() else -1 * (invest.sum.toDouble() * invest.percent.toDouble() / 100.0).roundToInt() * 2
                    if (it.money < 0) it.money = 0
                    userRepository.update(it)
                }
            }
        }
    }

    private suspend fun launchCreditCycle(){
        while (true) {
            delay(15000)
            invests.forEach { invest ->
                val end = (invest.reliability * 100).roundToInt()
                val success = if (end == 100) true else Random.nextInt(0, end) == 1
                user?.let {
                    it.money += if (success) (invest.sum.toDouble() * invest.percent.toDouble() / 100.0).roundToInt() else -1 * (invest.sum.toDouble() * invest.percent.toDouble() / 100.0).roundToInt() * 2
                    if (it.money < 0) it.money = 0
                    userRepository.update(it)
                }
            }
        }
    }

    private suspend fun launchDepositCycle(){
        while (true) {
            delay(15000)
            invests.forEach { invest ->
                val end = (invest.reliability * 100).roundToInt()
                val success = if (end == 100) true else Random.nextInt(0, end) == 1
                user?.let {
                    it.money += if (success) (invest.sum.toDouble() * invest.percent.toDouble() / 100.0).roundToInt() else -1 * (invest.sum.toDouble() * invest.percent.toDouble() / 100.0).roundToInt() * 2
                    if (it.money < 0) it.money = 0
                    userRepository.update(it)
                }
            }
        }
    }


}