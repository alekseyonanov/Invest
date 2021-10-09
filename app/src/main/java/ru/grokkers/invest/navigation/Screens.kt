package ru.grokkers.invest.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.grokkers.invest.ui.fragment.education.detail.EducationDetailFragment
import ru.grokkers.invest.ui.fragment.education.list.EducationListFragment
import ru.grokkers.invest.ui.fragment.greetingfragment.GreetingFragment
import ru.grokkers.invest.ui.fragment.storefragment.StoreFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
object Screens {
    val Greeting: FragmentScreen
        get() = FragmentScreen { GreetingFragment() }

    val EducationList: FragmentScreen
        get() = FragmentScreen { EducationListFragment() }

    val EducationDetails: FragmentScreen
        get() = FragmentScreen { EducationDetailFragment() }

    val Store: FragmentScreen
        get() = FragmentScreen { StoreFragment() }
}