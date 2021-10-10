package ru.grokkers.invest.ui.fragment.stockfragment.main.adapter

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import androidx.core.view.isVisible
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.databinding.StockItemBinding
import ru.grokkers.invest.ui.base.BaseViewHolder

/**
 * @author Doroshenko Vyacheslav
 */
class StockViewHolder(
    private val binding: StockItemBinding,
    var onStockClick: ((stock: Stock) -> Unit)? =
        null,
) : BaseViewHolder<Stock>(binding) {

    override fun bind(model: Stock) {

        val formatter: NumberFormat = DecimalFormat("#,###")
        binding.root.setOnClickListener { onStockClick?.invoke(model) }
        binding.name.text = model.name ?: "No name"
        val price = fetchCurrency(model.price.toInt(), formatter)
        binding.price.text = price
        binding.event.isVisible = model.message.isNotEmpty()
        binding.event.text = model.message ?: ""
        if (model.isExtended) {
            binding.reliability.isVisible = true
            binding.reliability.text = "Доверие: ${(model.reliability * 100).toInt()} %"
        }
    }


    private fun fetchCurrency(value: Int, formatter: NumberFormat): String {
        return "${formatter.format(value)}.00 ₽"
    }
}