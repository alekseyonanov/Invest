package ru.grokkers.invest.ui.fragment.storefragment.adapter

import androidx.core.view.isVisible
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.databinding.StockItemBinding
import ru.grokkers.invest.ui.base.BaseViewHolder
import java.text.DecimalFormat

/**
 * @author Doroshenko Vyacheslav
 */
class StockViewHolder(
    private val binding: StockItemBinding,
    var onStockClick: ((stock: Stock) -> Unit)? =
        null,
) : BaseViewHolder<Stock>(binding) {

    override fun bind(model: Stock) {
        val decormat = DecimalFormat("0.00")
        binding.root.setOnClickListener { onStockClick?.invoke(model) }
        binding.name.text = model.name ?: "No name"
        val price = "${decormat.format(model.price)} ${model.currencySymbol}"
        binding.price.text = price
        binding.event.isVisible = model.message.isNotEmpty()
        binding.event.text = model.message ?: ""
    }
}