package com.mita.test

import androidx.recyclerview.widget.RecyclerView
import com.mita.test.databinding.ItemLayoutBinding

class MyViewHolder(private var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(
    binding.root
) {
    fun onBind(
        item: MyDataClass,
    ) {
        binding.textView.text = item.name

    }
}