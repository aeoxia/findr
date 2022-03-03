package com.ausom.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ausom.local.dao.PhotoDao
import com.ausom.local.model.PhotoDbEntity

/**
 * Definition of the Room Database
 * - room was used since the is a large collection of structured data
 */
@Database(
    entities = [PhotoDbEntity::class],
    version = 1
)
abstract class FindrDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}