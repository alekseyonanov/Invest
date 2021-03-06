package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment.adapter

import androidx.core.view.isVisible
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.databinding.ItemInvestmentBinding
import ru.grokkers.invest.ui.base.BaseViewHolder

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class InvestmentViewHolder(
    private val binding: ItemInvestmentBinding,
    var onStockClick: ((stock: Investment) -> Unit)? =
        null,
) : BaseViewHolder<Investment>(binding) {

    override fun bind(model: Investment) {
        binding.root.setOnClickListener { onStockClick?.invoke(model) }
        binding.title.text = model.title
        binding.sum.text = model.sum.toString()
        binding.owner.text = model.owner
        binding.sum.text = "${model.percent} %"
        if (model.isExtended) {
            binding.reliability.isVisible = true
            binding.reliability.text = "Доверие: ${(model.reliability * 100).toInt()} %"
        }
    }
}