package ru.grokkers.invest.ui.fragment.education.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.handleCoroutineException
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.data.model.HARD
import ru.grokkers.invest.data.model.MEDIUM
import ru.grokkers.invest.databinding.FragmentEducationListBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.dialog.PaymentDialog
import ru.grokkers.invest.ui.fragment.education.list.adapter.EducationListAdapter
import ru.grokkers.invest.ui.state.EducationState

/**
 * @author Onanov Aleksey (@onanov)
 */
@AndroidEntryPoint
class EducationListFragment : BaseFragment() {

    private var _binding: FragmentEducationListBinding? = null
    private val binding: FragmentEducationListBinding get() = _binding!!

    private val depositionAdapter by lazy {
        EducationListAdapter().apply {
            onItemClicked = viewModel::onItemClicked
            onLockedClicked = viewModel::onLockedClicked
        }
    }
    private val stockAdapter by lazy {
        EducationListAdapter().apply {
            onItemClicked = viewModel::onItemClicked
            onLockedClicked = viewModel::onLockedClicked
        }
    }
    private val creditAdapter by lazy {
        EducationListAdapter().apply {
            onItemClicked = viewModel::onItemClicked
            onLockedClicked = viewModel::onLockedClicked
        }
    }

    private val viewModel by viewModels<EducationListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationListBinding.inflate(inflater, container, false)

        (activity as MainActivity).setNavigationVisibility(true)

        binding.easyRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = depositionAdapter
        }

        binding.mediumRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = stockAdapter
        }

        binding.hardRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = creditAdapter
        }

        viewModel.apply {
            handleFlow(uiState, ::handleState)
            handleFlow(payment, ::handlePayment)
            start()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleState(state: EducationState) {
        when (state) {
            is EducationState.Success -> handleItems(state.items)
        }
    }

    private fun handlePayment(education: Education) {
        PaymentDialog.show(education.title, education.price, childFragmentManager) {
            viewModel.onPaymentSuccess(education)
        }
    }

    private fun handleItems(items: List<Education>) {
        depositionAdapter.submitList(items.filter { it.category == "Вклад" })
        stockAdapter.submitList(items.filter { it.category == "Биржа" })
        creditAdapter.submitList(items.filter { it.category == "Кредитование" })
        depositionAdapter.notifyDataSetChanged()
        stockAdapter.notifyDataSetChanged()
        creditAdapter.notifyDataSetChanged()
    }

}