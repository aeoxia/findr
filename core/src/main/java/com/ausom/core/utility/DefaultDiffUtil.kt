package com.ausom.core.utility

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.ausom.core.abstraction.RecyclerViewItem

/**
 *
 * Generic DiffUtil that compares all items in the list based on
 * @property RecyclerViewItem.id
 *
 */
class DefaultDiffUtil<T: RecyclerViewItem>: DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}