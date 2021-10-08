package ru.grokkers.invest.ui.fragment.greetingfragment.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import ru.grokkers.invest.R
import ru.grokkers.invest.databinding.FragmentGreetingBinding
import ru.grokkers.invest.databinding.MessageItemBinding

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */
class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {

    var items: List<Pair<String, Boolean>> = listOf()

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
                message.text = data.first

                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = if (data.second) Gravity.END else Gravity.START
                    setMargins(itemView.resources.getDimensionPixelSize(R.dimen.default_margin))
                }

                container.layoutParams = layoutParams
            }
        }
    }
}