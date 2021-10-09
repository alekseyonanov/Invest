package ru.grokkers.invest.ui.fragment.education.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.data.model.EASY
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.data.model.HARD
import ru.grokkers.invest.data.model.MEDIUM
import ru.grokkers.invest.databinding.FragmentEducationListBinding
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.education.list.adapter.EducationListAdapter
import ru.grokkers.invest.ui.state.EducationState

/**
 * @author Onanov Aleksey (@onanov)
 */
@AndroidEntryPoint
class EducationListFragment : BaseFragment() {

    private var _binding: FragmentEducationListBinding? = null
    private val binding: FragmentEducationListBinding get() = _binding!!

    private val easyAdapter by lazy {
        EducationListAdapter().apply {
            onItemClicked = viewModel::onItemClicked
        }
    }
    private val mediumAdapter by lazy {
        EducationListAdapter().apply {
            onItemClicked = viewModel::onItemClicked
        }
    }
    private val hardAdapter by lazy {
        EducationListAdapter().apply {
            onItemClicked = viewModel::onItemClicked
        }
    }

    private val viewModel by viewModels<EducationListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationListBinding.inflate(inflater, container, false)

        binding.easyRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = easyAdapter
        }

        binding.mediumRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = mediumAdapter
        }

        binding.hardRecyclerView.apply {
            isNestedScrollingEnabled = false
            adapter = hardAdapter
        }

        viewModel.apply {
            handleFlow(uiState, ::handleState)
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

    private fun handleItems(items: List<Education>) {
        easyAdapter.submitList(items.filter { it.level == EASY })
        mediumAdapter.submitList(items.filter { it.level == MEDIUM })
        hardAdapter.submitList(items.filter { it.level == HARD })
    }

}