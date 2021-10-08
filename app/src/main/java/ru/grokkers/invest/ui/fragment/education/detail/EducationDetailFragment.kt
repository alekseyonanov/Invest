package ru.grokkers.invest.ui.fragment.education.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.grokkers.invest.databinding.FragmentEducationDetailBinding
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationDetailFragment : BaseFragment() {

    private var _binding: FragmentEducationDetailBinding? = null
    private val binding: FragmentEducationDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}