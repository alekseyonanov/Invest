package ru.grokkers.invest.ui.fragment.greetingfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.grokkers.invest.databinding.MessageItemBinding

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {

    var items: MutableList<Pair<String, Boolean>> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addMessage(message: Pair<String, Boolean>) {
        items.add(message)
        notifyItemChanged(items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MessagesViewHolder(MessageItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class MessagesViewHolder(private val binding: MessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(data: Pair<String, Boolean>) {
            binding.apply {
                if (data.second) {
                    messageIncomeCard.isVisible = false
                    messageOutcomeCard.isVisible = true
                    messageOutcome.text = data.first
                } else {
                    messageIncomeCard.isVisible = true
                    messageOutcomeCard.isVisible = false
                    messageIncome.text = data.first
                }
            }
        }
    }
}