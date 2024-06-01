package com.mita.test

import androidx.recyclerview.widget.DiffUtil

class MyDiffCallback: DiffUtil.ItemCallback<MyDataClass>() {

   /* override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size*/

    override fun areItemsTheSame(oldItem: MyDataClass, newItem: MyDataClass): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyDataClass, newItem: MyDataClass): Boolean {
        return oldItem == newItem
    }
}