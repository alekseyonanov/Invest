package ru.grokkers.invest.ui.fragment.work

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.User
import ru.grokkers.invest.databinding.FragmentWorkBinding
import ru.grokkers.invest.ui.activity.MainActivity
import ru.grokkers.invest.ui.base.BaseFragment
import android.graphics.drawable.TransitionDrawable

import android.graphics.drawable.ColorDrawable




/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class WorkFragment : BaseFragment() {

    private var _binding: FragmentWorkBinding? = null
    private val binding: FragmentWorkBinding
        get() = _binding!!

    private val viewModel by viewModels<WorkViewModel>()

    private var currentColor: Int = 0

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
        val formatter: NumberFormat = DecimalFormat("#,###")
        user?.let {
            binding.currentMoney.text = fetchCurrency(user.money, formatter)
            binding.daily.text = fetchCurrency(user.userType.salary / 30, formatter)
        }
    }

    private fun fetchCurrency(value: Int, formatter: NumberFormat): String {
        return "${formatter.format(value)}.00 ₽"
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

        var to = 0

        when (time) {
            in 8..15 -> {
                binding.apply {
                    to = ContextCompat.getColor(requireContext(), R.color.blue20)
                }
            }
            in 16..23 -> {
                binding.apply {
                    to = ContextCompat.getColor(requireContext(), R.color.blue70)
                }
            }
            in 0..7 -> {
                binding.apply {
                    to = ContextCompat.getColor(requireContext(), R.color.blue40)
                }
            }
        }
        if(currentColor == 0){
            currentColor = to
            animateColorChange(currentColor, to)
        }

        if(to != currentColor) {
            animateColorChange(currentColor, to)
        }
    }

    private fun animateColorChange(from: Int, to: Int){
        val colorDrawables = arrayOf(
            ColorDrawable(from),
            ColorDrawable(to)
        )
        val transitionDrawable = TransitionDrawable(colorDrawables)
        binding.layout.setBackground(transitionDrawable)
        transitionDrawable.startTransition(300)
        currentColor = to

    }

    companion object {
        private const val HOUR_FORMATTER = "%02d"
    }
}