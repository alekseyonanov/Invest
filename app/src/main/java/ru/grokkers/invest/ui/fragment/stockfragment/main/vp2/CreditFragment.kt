package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.grokkers.invest.databinding.FragmentInvestmentsBinding
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment.CreditViewModel
import ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment.adapter.CreditAdapter

/**
 * @author Doroshenko Vyacheslav
 */
class CreditFragment : BaseFragment() {

    private var _binding: FragmentInvestmentsBinding? = null
    private val binding: FragmentInvestmentsBinding by lazy { _binding!! }

    private val viewModel by viewModels<CreditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInvestmentsBinding.inflate(inflater, container, false);
        CreditAdapter().also { stockAdapter ->
            stockAdapter.onInvestmentClicked = {

            }
            binding.recycler.apply {
                adapter = stockAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            binding.vtb.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.vtb.ru/personal/kredit")
                )
                startActivity(intent)
            }
            viewModel.start()
            handleFlow(viewModel.investmentsState, stockAdapter::submitList)
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}