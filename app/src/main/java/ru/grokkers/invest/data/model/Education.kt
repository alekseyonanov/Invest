package ru.grokkers.invest.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

/**
 * @author Onanov Aleksey (@onanov)
 */
@Parcelize
data class Education(
    val id: Int,
    val title: String,
    val level: Int,
    val description: String,
    val content: String,
    @DrawableRes val thumb: Int,
    val category: String,
    val favourite: Boolean,
    var isLocked: Boolean = true,
    val price: Int = 1000,
) : Parcelable

const val EASY = 0
const val MEDIUM = 1
const val HARD = 2


object EducationDiffCallback : DiffUtil.ItemCallback<Education>() {
    override fun areItemsTheSame(oldItem: Education, newItem: Education) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Education, newItem: Education) = oldItem == newItem
}

