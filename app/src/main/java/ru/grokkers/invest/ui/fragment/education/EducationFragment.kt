package ru.grokkers.invest.ui.fragment.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.grokkers.invest.databinding.FragmentEducationBinding
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationFragment : BaseFragment() {

    private var _binding: FragmentEducationBinding? = null
    private val binding: FragmentEducationBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)



        return binding.root
    }

}