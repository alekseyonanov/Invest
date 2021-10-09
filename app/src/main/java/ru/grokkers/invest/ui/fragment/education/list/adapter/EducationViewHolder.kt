package ru.grokkers.invest.ui.fragment.education.list.adapter

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Vibrator
import android.view.View
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.Education
import ru.grokkers.invest.databinding.ItemEducationBinding

/**
 * @author Onanov Aleksey (@onanov)
 */
class EducationViewHolder(
    private val binding: ItemEducationBinding,
    var openListener: ((Education) -> Unit)? = null,
    var lockedListener: ((Education) -> Boolean)? = null,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Education) {
        with(item) {
            binding.level.text = fetchLevel(level)
            binding.subjectTextView.text = title
            binding.bodyPreviewTextView.text = description
            binding.state.setImageResource(if (isLocked) R.drawable.ic_locked else R.drawable.ic_unlocked)
            val formatter: NumberFormat = DecimalFormat("#,###")

            binding.price.text = "Цена: ${formatter.format(price)}.00 ₽"
            //binding.state.setImageResource(thumb)
            binding.cardView.setOnClickListener {
                if (isLocked) {
                    if (lockedListener?.invoke(this) == false) {
                        shakeAndVibrate(binding.cardView)
                    }
                } else {
                    openListener?.invoke(this)
                }
            }

            binding.price.isVisible = isLocked


            binding.cardContainer.forEach {
                if (isLocked && it.id != R.id.state && it.id != R.id.price) {
                    it.alpha = 0.5f
                } else {
                    it.alpha = 1f
                }
            }
        }
    }

    private fun fetchLevel(level: Int): String {
        return when (level) {
            0 -> "Необходимый минимум"
            1 -> "Деловая хватка"
            else -> "Высшая лига"
        }
    }

    private fun shakeAndVibrate(view: View) {
        val vibe = ContextCompat.getSystemService(view.context, Vibrator::class.java)
        val shake = TranslateAnimation(0F, 10F, 0F, 0F)
        shake.duration = 350
        shake.interpolator = CycleInterpolator(3F)
        view.startAnimation(shake)
        vibe?.vibrate(50)
    }


}