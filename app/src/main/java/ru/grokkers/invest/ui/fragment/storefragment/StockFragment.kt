package ru.grokkers.invest.ui.fragment.storefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.R
import ru.grokkers.invest.databinding.StockFragmentBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.storefragment.adapter.StockListAdapter

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class StockFragment : BaseFragment() {

    private var _binding: StockFragmentBinding? = null
    private val binding: StockFragmentBinding by lazy { _binding!! }

    private val viewModel by viewModels<StockViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = StockFragmentBinding.inflate(inflater, container, false);

        (activity as MainActivity).setNavigationVisibility(true)
        (activity as MainActivity).setFabIcon(R.drawable.ic_money)

        binding.appbar.addOnOffsetChangedListener(offsetChangedListener)
        StockListAdapter().also { stockAdapter ->
            stockAdapter.onStockClick = viewModel::stockClick
            binding.recycler.apply {
                adapter = stockAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            handleFlow(viewModel.stockFlow, stockAdapter::submitList)
        }

        val desiredBarHeight = binding.motionLayout.minHeight
        ViewCompat.setOnApplyWindowInsetsListener(binding.motionLayout) { _, insets ->
            val insetTopHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top
            binding.motionLayout.minimumHeight = desiredBarHeight + insetTopHeight
            val endSet = binding.motionLayout.getConstraintSet(R.id.collapsed)
            /* endSet.setGuidelineEnd(,desiredBarHeight)*/
            insets
        }

        test()
        return binding.root
    }

    private fun test() {
        binding.profit.text = "15 465 $"
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