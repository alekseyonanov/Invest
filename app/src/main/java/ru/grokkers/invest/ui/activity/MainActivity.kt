package ru.grokkers.invest.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
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
        binding.fab.setOnClickListener {
            navigator.navigateToGreeting()
        }
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
            else -> return false
        }
        return true

    }

    fun setNavigationVisibility(isVisible: Boolean) {
        if (isVisible) {
            binding.bottomAppBar.performShow()
        } else {
            binding.bottomAppBar.performHide()
        }
        //binding.navigation.isVisible = isVisible
    }

    fun setFabIcon(@DrawableRes iconRes: Int) {
        binding.fab.setImageResource(iconRes)
    }

}