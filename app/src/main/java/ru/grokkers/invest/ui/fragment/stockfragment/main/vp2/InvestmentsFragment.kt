package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.grokkers.invest.databinding.DialogPaymentBinding
import ru.grokkers.invest.databinding.FragmentCreditBinding
import ru.grokkers.invest.databinding.FragmentInvestmentsBinding
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.stockfragment.detail.StockDetailFragment
import ru.grokkers.invest.ui.fragment.stockfragment.main.StockViewModel
import ru.grokkers.invest.ui.fragment.stockfragment.main.adapter.StockListAdapter

/**
 * @author Doroshenko Vyacheslav
 */
class InvestmentsFragment : BaseFragment() {

    private var _binding: FragmentInvestmentsBinding? = null
    private val binding: FragmentInvestmentsBinding by lazy { _binding!! }

    private val viewModel by viewModels<StockViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInvestmentsBinding.inflate(inflater, container, false);
        StockListAdapter().also { stockAdapter ->
            stockAdapter.onStockClick = {
                StockDetailFragment().show(parentFragmentManager,"esa")
            }
            binding.recycler.apply {
                adapter = stockAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            handleFlow(viewModel.stockFlow, stockAdapter::submitList)
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}