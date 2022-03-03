package com.ausom.local

import com.ausom.data.LocalDataSource
import com.ausom.data.model.PhotoEntity
import com.ausom.local.dao.PhotoDao
import com.ausom.local.mapper.PhotoDbEntityToDataMapper
import com.ausom.local.mapper.PhotoEntityToLocalDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val photoDao: PhotoDao,
    private val photoDbEntityToDataMapper: PhotoDbEntityToDataMapper,
    private val photoEntityToLocalDataMapper: PhotoEntityToLocalDataMapper
) : LocalDataSource {

    override fun getPhotos(keyword: String): Flow<List<PhotoEntity>> {
        return photoDao.getPhotos(keyword).map(photoDbEntityToDataMapper::mapList)
    }

    override fun persistPhotos(photos: List<PhotoEntity>) {
        photoDao.insert(photos.map(photoEntityToLocalDataMapper::map))
    }
}