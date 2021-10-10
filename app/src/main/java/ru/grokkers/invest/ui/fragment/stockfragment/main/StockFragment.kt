package ru.grokkers.invest.ui.fragment.stockfragment.main

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.databinding.FragmentStockBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.stockfragment.main.adapter.ViewPager2Adapter

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class StockFragment : BaseFragment() {

    private var _binding: FragmentStockBinding? = null
    private val binding: FragmentStockBinding by lazy { _binding!! }

    private val viewModel by viewModels<StockViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentStockBinding.inflate(inflater, container, false);

        (activity as MainActivity).setNavigationVisibility(true)
        (activity as MainActivity).setFabIcon(R.drawable.ic_money)

        binding.appbar.addOnOffsetChangedListener(offsetChangedListener)

        binding.stockViewPager.adapter = ViewPager2Adapter(this)
        handleFlow(viewModel.money, ::setMoney)
        configTabs()
        return binding.root
    }

    private fun configTabs() {
        TabLayoutMediator(binding.tabs, binding.stockViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "АКЦИИ"
                1 -> tab.text = "КРЕДИТЫ"
                else -> tab.text = "ВКЛАДЫ"
            }
        }.attach()
    }

    private fun setMoney(money: Int) {
        val formatter: NumberFormat = DecimalFormat("#,###")
        binding.profit.text = fetchCurrency(money, formatter)
    }

    private fun fetchCurrency(value: Int, formatter: NumberFormat): String {
        return "${formatter.format(value)}.00 ₽"
    }

    private fun openDialog(stock: Stock) {
        DialogFragment().show(parentFragmentManager, "ssa")
    }

    private val offsetChangedListener =
        AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            (-verticalOffset / appBarLayout.totalScrollRange.toFloat()).let { position ->
                binding.motionLayout.progress = position
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}