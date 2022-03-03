package com.ausom.findr.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.domain.model.Photo
import com.ausom.findr.model.PhotoDisplay
import javax.inject.Inject

class PhotoToDisplayMapper @Inject constructor() : OneWayMapper<Photo, PhotoDisplay> {

    override fun map(before: Photo): PhotoDisplay {
        return with(before) {
            PhotoDisplay(
                id = id,
                image = image,
                title = title
            )
        }
    }
}