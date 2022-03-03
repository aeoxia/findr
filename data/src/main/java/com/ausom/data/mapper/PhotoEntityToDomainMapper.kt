package com.ausom.data.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.data.model.PhotoEntity
import com.ausom.domain.model.Photo
import javax.inject.Inject

class PhotoEntityToDomainMapper @Inject constructor() : OneWayMapper<PhotoEntity, Photo> {

    override fun map(before: PhotoEntity): Photo {
        return with(before) {
            Photo(
                id = id,
                title = title,
                image = image
            )
        }
    }
}