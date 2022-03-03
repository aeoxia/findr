package com.ausom.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ausom.local.model.PageInfoDbEntity

@Dao
interface PageInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pageInfoDbEntity: PageInfoDbEntity)

    @Query("SELECT * FROM PageInfoDbEntity WHERE pageName = :pageName")
    fun getNextPageInfo(pageName: String): PageInfoDbEntity
}