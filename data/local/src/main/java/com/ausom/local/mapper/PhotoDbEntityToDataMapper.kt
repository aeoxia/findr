package com.ausom.local.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.data.model.PhotoEntity
import com.ausom.local.model.PhotoDbEntity
import javax.inject.Inject

class PhotoDbEntityToDataMapper @Inject constructor() : OneWayMapper<PhotoDbEntity, PhotoEntity> {
    override fun map(before: PhotoDbEntity): PhotoEntity {
        return with(before) {
            PhotoEntity(
                id = id,
                title = title,
                image = image,
                keyword = keyword
            )
        }
    }
}