package com.ausom.data

import com.ausom.data.model.PageInfoEntity
import com.ausom.data.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction for local data source
 * */
interface LocalDataSource {

    fun getPhotos(): Flow<List<PhotoEntity>>

    fun clearAll()

    fun persistPhotos(photos: List<PhotoEntity>)

    fun persistPageInfo(pageInfoEntity: PageInfoEntity)

    fun getPageInfo(pageName: String): PageInfoEntity

}