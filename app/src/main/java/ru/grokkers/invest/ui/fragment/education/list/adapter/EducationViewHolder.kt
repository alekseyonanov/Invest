package ru.grokkers.invest.ui.fragment.education.list.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.databinding.ItemEducationBinding

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationViewHolder(
    private val binding: ItemEducationBinding,
    var listener: ((Education) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Education) {
        with(item) {
            binding.category.text = category
            binding.subjectTextView.text = title
            binding.bodyPreviewTextView.text = description
            binding.senderProfileImageView.setImageResource(thumb)
            binding.cardView.setOnClickListener {
                listener?.invoke(this)
            }
        }
    }

}