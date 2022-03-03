package com.ausom.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val image: String,
)