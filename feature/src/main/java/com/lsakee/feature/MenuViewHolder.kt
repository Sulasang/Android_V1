package com.lsakee.feature

import androidx.recyclerview.widget.RecyclerView
import com.lsakee.feature.databinding.ItemMenuBinding

class MenuViewHolder(
    private val binding: ItemMenuBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: String) {
        binding.menu = data
        binding.executePendingBindings()
    }
}