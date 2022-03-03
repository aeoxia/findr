package com.ausom.remote.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.data.model.PhotoEntity
import com.ausom.remote.model.FlickrResponse
import javax.inject.Inject

class FlickrResponseToDataMapper @Inject constructor() : OneWayMapper<FlickrResponse, List<PhotoEntity>> {

    override fun map(before: FlickrResponse): List<PhotoEntity> {
        val photos = before.photoListResponse?.photoResponse?: emptyList()
        return photos.map { photo ->
            with(photo) {
                PhotoEntity(
                    id = id?: "",
                    title = title?: "",
                    image = buildImageUrl(
                        farm = farm?: 0,
                        server = server?: "",
                        id = id?: "",
                        secret = secret?: ""
                    ),
                    keyword = ""
                )
            }
        }
    }

    private fun buildImageUrl(farm: Int, server: String, id: String, secret: String) : String {
        return "http://farm$farm.static.flickr.com/$server/${id}_$secret.jpg"
    }
}