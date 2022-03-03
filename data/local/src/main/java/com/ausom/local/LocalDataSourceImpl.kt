package com.ausom.local

import com.ausom.data.LocalDataSource
import com.ausom.data.model.PhotoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor() : LocalDataSource {

    override fun getPhotos(keyword: String): Flow<List<PhotoEntity>> {
        TODO("Not yet implemented")
    }

    override fun persistPhotos(photos: List<PhotoEntity>) {
        TODO("Not yet implemented")
    }
}