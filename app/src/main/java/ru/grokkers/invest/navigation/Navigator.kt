package ru.grokkers.invest.navigation

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import ru.grokkers.invest.data.model.Education
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

    fun navigateToWork() {
        root(Screens.Work)
    }

    fun navigateToStore() {
        root(Screens.Store)
    }

    fun navigateToEducationList() {
        root(Screens.EducationList)
    }

    fun navigateToEducationDetails(education: Education) {
        forward(Screens.educationDetails(education))
    }

    fun navigateToProfile() {
        root(Screens.Profile)
    }

    fun navigateToPurse() {
        forward(Screens.Purse)
    }

    fun navigateBack() {
        router.exit()
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