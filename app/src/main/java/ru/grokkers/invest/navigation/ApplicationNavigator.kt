package ru.grokkers.invest.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.androidx.AppNavigator

/**
 * @author Onanov Aleksey (@onanov)
 */
class ApplicationNavigator(
    activity: FragmentActivity,
    containerId: Int,
    fragmentManager: FragmentManager = activity.supportFragmentManager
): AppNavigator(
    activity, containerId, fragmentManager
){

}