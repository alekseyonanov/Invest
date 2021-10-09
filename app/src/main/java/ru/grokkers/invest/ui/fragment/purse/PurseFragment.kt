package ru.grokkers.invest.ui.fragment.purse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.grokkers.invest.databinding.FragmentEducationDetailBinding
import ru.grokkers.invest.databinding.FragmentPurseBinding
import ru.grokkers.invest.ui.base.BaseFragment
import ru.grokkers.invest.ui.fragment.education.detail.EducationDetailViewModel

/**
 * @author Onanov Aleksey (@onanov)
 */
class PurseFragment : BaseFragment() {

    private var _binding: FragmentPurseBinding? = null
    private val binding: FragmentPurseBinding get() = _binding!!

    private val viewModel by viewModels<PurseViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurseBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}