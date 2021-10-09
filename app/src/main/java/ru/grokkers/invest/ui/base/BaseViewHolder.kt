package ru.grokkers.invest.ui.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author Doroshenko Vyacheslav
 */
abstract class BaseViewHolder<Model>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root),
    BindView<Model> {

}


interface BindView<Model> {
    fun bind(model: Model)
}