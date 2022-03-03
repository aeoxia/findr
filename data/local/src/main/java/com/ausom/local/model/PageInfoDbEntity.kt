package com.ausom.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PageInfoDbEntity(
    @PrimaryKey
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val pageName: String,
    val nextPageNumber: Int,
    val searchKeyword: String
)
