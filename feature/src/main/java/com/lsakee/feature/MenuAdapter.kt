package com.lsakee.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lsakee.core_ui.view.ItemDiffCallback
import com.lsakee.feature.databinding.ItemMenuBinding

class MenuAdapter(
) : ListAdapter<String, MenuViewHolder>(
    MyTagDiffCalback,
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding =
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val MyTagDiffCalback =
            ItemDiffCallback<String>(
                onItemsTheSame = { old, new -> old == new },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}