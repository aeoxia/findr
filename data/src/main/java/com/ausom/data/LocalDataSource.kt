package com.ausom.data

import com.ausom.data.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction for local data source
 * */
interface LocalDataSource {

    fun getPhotos(keyword: String): Flow<List<PhotoEntity>>

}