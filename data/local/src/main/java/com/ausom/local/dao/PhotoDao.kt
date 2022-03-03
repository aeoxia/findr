package com.ausom.local.dao

import androidx.room.*
import com.ausom.local.model.PhotoDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("SELECT * FROM PhotoDbEntity WHERE keyword = :keyword")
    fun getPhotos(keyword: String): Flow<List<PhotoDbEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg PhotoDbEntity: PhotoDbEntity)
}