package com.ausom.domain.abstraction

import com.ausom.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface FindrRepository {

    fun getPhotos() : Flow<List<Photo>>

    fun searchPhotos(keyword: String) : Flow<Unit>

}