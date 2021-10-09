package ru.grokkers.invest.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.R
import ru.grokkers.invest.databinding.ActivityMainBinding
import ru.grokkers.invest.navigation.ApplicationNavigator
import ru.grokkers.invest.navigation.Navigator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val appNavigator = ApplicationNavigator(this, R.id.fragment_container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Invest)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*binding.root.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION*/

        navigator.navigateToStore()

        binding.navigation.setOnItemSelectedListener(::handleNavigationItemClick)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun handleNavigationItemClick(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.job -> navigator.navigateToWork()
            R.id.store -> navigator.navigateToStore()
            R.id.education -> navigator.navigateToEducationList()
            R.id.profile -> navigator.navigateToEducationList()
        }
        return true

    }

    fun setNavigationVisibility(isVisible: Boolean) {
        binding.navigation.isVisible = isVisible
    }

}