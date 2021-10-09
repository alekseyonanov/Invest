package ru.grokkers.invest.ui.fragment.stockfragment.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.ContributionsFragment
import ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.CreditFragment
import ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.InvestmentsFragment

/**
 * @author Doroshenko Vyacheslav
 */
class ViewPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ContributionsFragment()
            1 -> CreditFragment()
            else -> InvestmentsFragment()
        }
    }
}