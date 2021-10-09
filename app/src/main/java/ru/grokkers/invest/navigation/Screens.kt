package ru.grokkers.invest.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.ui.fragment.education.detail.EducationDetailFragment
import ru.grokkers.invest.ui.fragment.education.list.EducationListFragment
import ru.grokkers.invest.ui.fragment.greetingfragment.GreetingFragment
import ru.grokkers.invest.ui.fragment.storefragment.StoreFragment
import ru.grokkers.invest.ui.fragment.work.WorkFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
object Screens {
    val Greeting: FragmentScreen
        get() = FragmentScreen { GreetingFragment() }

    val EducationList: FragmentScreen
        get() = FragmentScreen { EducationListFragment() }

    fun educationDetails(education: Education) = FragmentScreen { EducationDetailFragment.newInstance(education) }

    val Store: FragmentScreen
        get() = FragmentScreen { StoreFragment() }

    val Work: FragmentScreen
        get() = FragmentScreen { WorkFragment() }
}