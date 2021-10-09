package ru.grokkers.invest.ui.fragment.education.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.data.model.EducationDiffCallback
import ru.grokkers.invest.databinding.ItemEducationBinding

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationListAdapter : ListAdapter<Education, EducationViewHolder>(EducationDiffCallback) {

    var onItemClicked: ((Education) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(
            ItemEducationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClicked
        )
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        getItem(position).also(holder::bind)
    }

}