package ru.grokkers.invest.ui.fragment.education.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.data.model.EducationDiffCallback
import ru.grokkers.invest.databinding.ItemEducationBinding

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationListAdapter :
    ListAdapter<Education, EducationListAdapter.EducationViewHolder>(EducationDiffCallback) {

    var onItemClicked: ((Education) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(
            ItemEducationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        getItem(position).also(holder::bind)
    }

    inner class EducationViewHolder(private val binding: ItemEducationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Education) {
            with(item) {
                binding.category.text = category
                binding.subjectTextView.text = title
                binding.bodyPreviewTextView.text = description
                binding.senderProfileImageView.setImageResource(thumb)
                binding.cardView.setOnClickListener {
                    onItemClicked?.invoke(this)
                }
            }
        }

    }

}