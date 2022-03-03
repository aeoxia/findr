package com.ausom.core.abstraction

import com.ausom.core.utility.DefaultDiffUtil
/**
 *
 * This is used for RecyclerView Items
 * Allows the use of a generic DiffUtil
 * @see DefaultDiffUtil
 *
 */
abstract class RecyclerViewItem {
    abstract val id: Any
}