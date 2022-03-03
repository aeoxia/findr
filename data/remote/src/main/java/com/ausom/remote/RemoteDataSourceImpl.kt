package com.ausom.remote

import com.ausom.data.RemoteDataSource
import com.ausom.data.model.PhotoEntity
import com.ausom.remote.mapper.FlickrResponseToDataMapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: FlickrService,
    private val flickrResponseToDataMapper: FlickrResponseToDataMapper
) : RemoteDataSource {

    override suspend fun searchPhotos(keyword: String, page: Int): List<PhotoEntity> {
        val response = service.getImages(keyword, page)
        return flickrResponseToDataMapper.map(response)
    }
}