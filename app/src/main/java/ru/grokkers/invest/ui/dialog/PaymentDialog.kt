package ru.grokkers.invest.ui.dialog

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.grokkers.invest.databinding.DialogPaymentBinding

/**
 * @author Onanov Aleksey (@onanov)
 */
class PaymentDialog : BottomSheetDialogFragment() {

    private var _binding: DialogPaymentBinding? = null
    private val binding: DialogPaymentBinding get() = _binding!!

    private var onSuccess: (() -> Unit)? = null

    private val price by lazy {
        requireArguments()[PRICE] as Int
    }

    private val product by lazy {
        requireArguments()[PRODUCT] as String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogPaymentBinding.inflate(inflater, container, false)

        binding.product.text = "Товар: $product"

        val formatter: NumberFormat = DecimalFormat("#,###")
        binding.price.text = "Цена: ${formatter.format(price)}.00 ₽"

        binding.apply.setOnClickListener {
            onSuccess?.invoke()
            dialog?.dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val PRICE = "PRICE"
        private const val PRODUCT = "PRODUCT"

        fun show(
            product: String,
            price: Int,
            fragmentManager: FragmentManager,
            listener: () -> Unit
        ) {
            PaymentDialog().apply {
                arguments = Bundle().apply {
                    putInt(PRICE, price)
                    putString(PRODUCT, product)
                }
                onSuccess = listener
                show(fragmentManager, null)
            }
        }
    }

}