package com.ausom.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoDbEntity(
    @PrimaryKey val id: String,
    val title: String,
    val image: String,
    val keyword: String
)