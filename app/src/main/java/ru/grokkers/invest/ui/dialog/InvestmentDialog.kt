package ru.grokkers.invest.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ru.grokkers.invest.databinding.DialogInvestmentBinding

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class InvestmentDialog(private val onAcceptListener: (Int) -> Unit) : DialogFragment() {

    private var _binding: DialogInvestmentBinding? = null
    private val binding: DialogInvestmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogInvestmentBinding.inflate(layoutInflater, container, false)

        binding.apply {
            apply.setOnClickListener {
                if (input.text.toString().isNotBlank()) {
                    onAcceptListener.invoke(input.text.toString().toInt())
                    dismiss()
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}