package ru.grokkers.invest.ui.fragment.purse

import android.app.Application
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.grokkers.invest.data.db.Loader
import ru.grokkers.invest.data.repository.UserRepository
import ru.grokkers.invest.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Onanov Aleksey (@onanov)
 */
@HiltViewModel
class PurseViewModel @Inject constructor(
    application: Application,
    private val userRepository: UserRepository,
    private val loader: Loader
) : BaseViewModel(application) {

    override fun onStart() {

    }

}