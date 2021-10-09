package ru.grokkers.invest.ui.fragment.education.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.databinding.FragmentEducationListBinding
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
@AndroidEntryPoint
class EducationListFragment : BaseFragment() {

    private var _binding: FragmentEducationListBinding? = null
    private val binding: FragmentEducationListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationListBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}