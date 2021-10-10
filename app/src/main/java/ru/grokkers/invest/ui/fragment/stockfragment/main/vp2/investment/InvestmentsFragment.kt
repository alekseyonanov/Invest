package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.databinding.FragmentInvestmentsBinding
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.dialog.InvestmentDialog
import ru.grokkers.invest.ui.fragment.stockfragment.detail.StockDetailFragment
import ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment.adapter.InvestmentAdapter

/**
 * @author Doroshenko Vyacheslav
 */
class InvestmentsFragment : BaseFragment() {

    private var _binding: FragmentInvestmentsBinding? = null
    private val binding: FragmentInvestmentsBinding by lazy { _binding!! }

    private val viewModel by viewModels<InvestmentViewModel>()

    private val stockAdapter =  InvestmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInvestmentsBinding.inflate(inflater, container, false);
        stockAdapter.also { stockAdapter ->
            stockAdapter.onInvestmentClicked = { model ->
                InvestmentDialog {
                    viewModel.onInvestmentSelected(model, it)
                }.show(childFragmentManager, "tag")
            }
            binding.recycler.apply {
                adapter = stockAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            binding.vtb.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.vtb.ru/personal/vklady-i-scheta/")
                )
                startActivity(intent)
            }
            viewModel.start()
            handleFlow(viewModel.investmentsState, ::submitList)
        }

        viewModel.apply {
            start()
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun submitList(list: List<Investment>) {
        if (list.isEmpty()) viewModel.generateList()
        stockAdapter.submitList(list)
    }
}