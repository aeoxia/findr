package com.ausom.findr.model

import com.ausom.core.abstraction.RecyclerViewItem

data class PhotoDisplay(
    override val id: String,
    val url: String,
    val title: String
) : RecyclerViewItem()