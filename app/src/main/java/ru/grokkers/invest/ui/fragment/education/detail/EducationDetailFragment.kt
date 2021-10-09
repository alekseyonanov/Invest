package ru.grokkers.invest.ui.fragment.education.detail

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.databinding.FragmentEducationDetailBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
@AndroidEntryPoint
class EducationDetailFragment : BaseFragment() {

    private var _binding: FragmentEducationDetailBinding? = null
    private val binding: FragmentEducationDetailBinding get() = _binding!!

    private val viewModel by viewModels<EducationDetailViewModel>()

    private val education by lazy {
        requireArguments()[EDUCATION] as Education
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationDetailBinding.inflate(inflater, container, false)

        (activity as MainActivity).setNavigationVisibility(false)
        (activity as MainActivity).setFabIcon(R.drawable.ic_store_white)
        (activity as MainActivity).setFabAction {
            viewModel.onFabClicked()
            (activity as MainActivity).setFabAction(null)
        }


        boundContent()



        binding.navigationIcon.setOnClickListener {
            viewModel.onBackClicked()
        }

        viewModel.apply {
            start()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        (activity as MainActivity).setFabAction(null)
    }

    private fun boundContent() {
        with(education) {
            binding.subjectTextView.text = title
            binding.category.text = category
            binding.senderProfileImageView.setImageResource(thumb)
            binding.bodyTextView.text = content
        }
    }

    companion object {
        private const val EDUCATION = "EDUCATION"

        fun newInstance(item: Education) = EducationDetailFragment().apply {
            arguments = Bundle().apply { putParcelable(EDUCATION, item) }
        }
    }
}