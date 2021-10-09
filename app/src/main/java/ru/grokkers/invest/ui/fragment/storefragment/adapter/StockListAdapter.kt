package ru.grokkers.invest.ui.fragment.storefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.grokkers.invest.data.model.Stock
import ru.grokkers.invest.databinding.StockItemBinding
import ru.grokkers.invest.ui.base.BaseViewHolder

/**
 * @author Doroshenko Vyacheslav
 */
class StockListAdapter : ListAdapter<Stock, BaseViewHolder<Stock>>(STOCK_MATCHER) {

    var onStockClick: ((stock: Stock) -> Unit)? =
        null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Stock> {
        val vb = StockItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockViewHolder(vb, onStockClick)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Stock>, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val STOCK_MATCHER = object : DiffUtil.ItemCallback<Stock>() {
            override fun areItemsTheSame(
                oldItem: Stock,
                newItem: Stock,
            ): Boolean =
                oldItem.id == newItem.id

            override fun getChangePayload(oldItem: Stock, newItem: Stock): Any =
                Any()

            override fun areContentsTheSame(
                oldItem: Stock,
                newItem: Stock,
            ): Boolean =
                oldItem.name == newItem.name &&
                        oldItem.price == newItem.price &&
                        newItem.message == newItem.message

        }
    }
}

