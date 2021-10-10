package ru.grokkers.invest.core

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.grokkers.invest.core.model.Events
import ru.grokkers.invest.data.repository.InvestmentRepository
import ru.grokkers.invest.data.repository.UserRepository
import javax.inject.Inject

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class EventCore @Inject constructor(
    userRepository: UserRepository,
    investmentRepository: InvestmentRepository
) {

    private val userEvent = UserEvent(userRepository, ::onEvent)
    private val investEvent = InvestEvent(investmentRepository, userRepository)
    private lateinit var context: Context

    fun init(activityContext: Context) {
        userEvent.init()
        investEvent.init()
        context = activityContext
    }

    private fun onEvent(event: Events) {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                AlertDialog.Builder(context)
                    .setTitle(event.model.title)
                    .setMessage(event.model.description)
                    .setCancelable(false)
                    .setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                    }.show()
            }
        }
    }

    fun resume() {
        userEvent.resume()
    }

    fun pause() {
        userEvent.pause()
    }
}