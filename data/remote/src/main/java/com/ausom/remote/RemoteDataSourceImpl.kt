package com.ausom.remote

import com.ausom.data.RemoteDataSource
import com.ausom.data.model.PhotoEntity
import com.ausom.remote.mapper.FlickrResponseToDataMapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: FlickrService,
    private val flickrResponseToDataMapper: FlickrResponseToDataMapper
) : RemoteDataSource {

    override suspend fun searchPhotos(keyword: String): List<PhotoEntity> {
        //TODO replace this when pagination is applied
        val response = service.getImages(keyword, 1)
        return flickrResponseToDataMapper.map(response)
    }
}