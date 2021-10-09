package ru.grokkers.invest.ui.fragment.stockfragment.detail

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import ru.grokkers.invest.R
import ru.grokkers.invest.databinding.FragmentStockDetailBinding
import ru.grokkers.invest.ui.fragment.stockfragment.main.StockViewModel

/**
 * @author Doroshenko Vyacheslav
 */
class StockDetailFragment : DialogFragment() {

    private var _binding: FragmentStockDetailBinding? = null
    private val binding: FragmentStockDetailBinding by lazy { _binding!! }

    private val viewModel by viewModels<StockViewModel>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullscreenDialogTheme);
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentStockDetailBinding.inflate(inflater, container, false);

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}