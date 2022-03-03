package com.ausom.local.dao

import androidx.room.*
import com.ausom.local.model.PhotoDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("SELECT * FROM PhotoDbEntity")
    fun getPhotos(): Flow<List<PhotoDbEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(photoDbEntity: List<PhotoDbEntity>)

    @Query("DELETE FROM PhotoDbEntity")
    fun deleteAll()

}