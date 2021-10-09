package ru.grokkers.invest.ui.fragment.work

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.databinding.FragmentWorkBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class WorkFragment : BaseFragment() {

    private var _binding: FragmentWorkBinding? = null
    private val binding: FragmentWorkBinding
        get() = _binding!!

    private val viewModel by viewModels<WorkViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkBinding.inflate(inflater, container, false)

        (activity as MainActivity).setNavigationVisibility(true)
        (activity as MainActivity).setFabVisibility(true)

        binding.apply {
            work.setOnClickListener {
                viewModel.onButtonClicked()
            }
        }

        viewModel.apply {
            start()
            handleFlow(timeState, ::setTime)
            handleFlow(userState, ::setData)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData(user: User?) {
        user?.let {
            binding.currentMoney.text = "${user.money}.00 ₽"
            binding.daily.text = "${(user.userType.salary / 30)}.00 ₽"
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).resumeCore()
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).pauseCore()
    }

    @SuppressLint("SetTextI18n")
    private fun setTime(time: Int) {
        binding.time.text = "${HOUR_FORMATTER.format(time)}:00"

        when (time) {
            in 8..15 -> {
                binding.apply {
                    layout.background = ContextCompat.getDrawable(requireContext(), R.color.blue20)
                }
            }
            in 16..23 -> {
                binding.apply {
                    layout.background = ContextCompat.getDrawable(requireContext(), R.color.blue70)
                }
            }
            in 0..7 -> {
                binding.apply {
                    layout.background = ContextCompat.getDrawable(requireContext(), R.color.blue40)
                }
            }
        }
    }

    companion object {
        private const val HOUR_FORMATTER = "%02d"
    }
}