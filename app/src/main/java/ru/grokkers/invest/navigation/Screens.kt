package ru.grokkers.invest.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.grokkers.invest.ui.fragment.education.list.EducationListFragment
import ru.grokkers.invest.ui.fragment.greetingfragment.GreetingFragment
import ru.grokkers.invest.ui.fragment.storefragment.StoreFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
object Screens {
    val Greeting: FragmentScreen
        get() = FragmentScreen { GreetingFragment() }

    val Education: FragmentScreen
        get() = FragmentScreen { EducationListFragment() }

    val Store: FragmentScreen
        get() = FragmentScreen{ StoreFragment()}
}