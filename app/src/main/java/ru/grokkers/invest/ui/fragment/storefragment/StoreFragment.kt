package ru.grokkers.invest.ui.fragment.storefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint
import ru.grokkers.invest.R
import ru.grokkers.invest.databinding.StoreFragmentBinding
import ru.grokkers.invest.ui.base.BaseFragment

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class StoreFragment : BaseFragment() {

    private var _binding: StoreFragmentBinding? = null
    private val binding: StoreFragmentBinding by lazy { _binding!! }

    private val viewModel by viewModels<StoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StoreFragmentBinding.inflate(inflater, container, false);
        binding.appbar.addOnOffsetChangedListener(offsetChangedListener)

        val desiredBarHeight = binding.motionLayout.minHeight
        ViewCompat.setOnApplyWindowInsetsListener(binding.motionLayout) { _, insets ->
            val insetTopHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top
            binding.motionLayout.minimumHeight = desiredBarHeight + insetTopHeight
            val endSet = binding.motionLayout.getConstraintSet(R.id.collapsed)
            /* endSet.setGuidelineEnd(,desiredBarHeight)*/
            insets
        }

        test()
        return binding.root
    }

    private fun test() {
        binding.profit.text = "15 465 $"
    }

    private val offsetChangedListener =
        AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            (-verticalOffset / appBarLayout.totalScrollRange.toFloat()).let { position ->
                binding.motionLayout.progress = position
            }

        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}