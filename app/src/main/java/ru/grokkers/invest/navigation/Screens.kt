package ru.grokkers.invest.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.grokkers.invest.ui.fragment.education.EducationFragment
import ru.grokkers.invest.ui.fragment.greetingfragment.GreetingFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
object Screens {
    val Greeting: FragmentScreen
        get() = FragmentScreen { GreetingFragment() }

    val Education: FragmentScreen
        get() = FragmentScreen { EducationFragment() }
}