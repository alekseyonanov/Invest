package ru.grokkers.invest.ui.fragment.stockfragment.main.vp2.investment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.grokkers.invest.data.model.Investment
import ru.grokkers.invest.databinding.ItemInvestmentBinding
import ru.grokkers.invest.databinding.StockItemBinding
import ru.grokkers.invest.ui.base.BaseViewHolder
import ru.grokkers.invest.ui.fragment.stockfragment.main.adapter.StockListAdapter
import ru.grokkers.invest.ui.fragment.stockfragment.main.adapter.StockViewHolder

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class InvestmentAdapter :
    ListAdapter<Investment, BaseViewHolder<Investment>>(INVESTEMENT_MATCHER) {
    var onInvestmentClicked: ((stock: Investment) -> Unit)? =
        null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Investment> {
        val vb = ItemInvestmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InvestmentViewHolder(vb, onInvestmentClicked)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Investment>, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val INVESTEMENT_MATCHER = object : DiffUtil.ItemCallback<Investment>() {
            override fun areItemsTheSame(
                oldItem: Investment,
                newItem: Investment,
            ): Boolean =
                oldItem.id == newItem.id

            override fun getChangePayload(oldItem: Investment, newItem: Investment): Any =
                Any()

            override fun areContentsTheSame(
                oldItem: Investment,
                newItem: Investment,
            ): Boolean =
                oldItem.title == newItem.title &&
                        oldItem.sum == newItem.sum &&
                        newItem.owner == newItem.owner

        }
    }
}