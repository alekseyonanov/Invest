package ru.grokkers.invest.navigation

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Onanov Aleksey (@onanov)
 */
@Singleton
class Navigator @Inject constructor(private val router: Router) {

    fun navigateToGreeting() {
        root(Screens.Greeting)
    }

    fun navigateToEducation() {
        root(Screens.Education)
    }

    private fun forward(screen: Screen) {
        router.navigateTo(screen)
    }

    private fun root(screen: Screen) {
        router.newRootScreen(screen)
    }

    private fun backToRoot() {
        router.backTo(null)
    }

    private fun forwardWithoutBackStack(screen: Screen) {
        router.replaceScreen(screen)
    }

}