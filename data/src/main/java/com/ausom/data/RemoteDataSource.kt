package com.ausom.data

import com.ausom.data.model.PhotoEntity

/**
 * Abstraction for remote data source
 * */
interface RemoteDataSource {

    suspend fun searchPhotos(keyword: String, page: Int): List<PhotoEntity>

}