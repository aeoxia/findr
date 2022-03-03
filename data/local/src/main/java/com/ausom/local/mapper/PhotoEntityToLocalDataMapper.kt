package com.ausom.local.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.data.model.PhotoEntity
import com.ausom.local.model.PhotoDbEntity
import javax.inject.Inject

class PhotoEntityToLocalDataMapper @Inject constructor() : OneWayMapper<PhotoEntity, PhotoDbEntity> {
    override fun map(before: PhotoEntity): PhotoDbEntity {
        return with(before) {
            PhotoDbEntity(
                id = id,
                title = title,
                image = image,
                keyword = keyword
            )
        }
    }
}