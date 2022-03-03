package com.ausom.local

import com.ausom.data.LocalDataSource
import com.ausom.data.model.PageInfoEntity
import com.ausom.data.model.PhotoEntity
import com.ausom.local.dao.PageInfoDao
import com.ausom.local.dao.PhotoDao
import com.ausom.local.mapper.PageInfoDbEntityToDataMapper
import com.ausom.local.mapper.PageInfoEntityToLocalDataMapper
import com.ausom.local.mapper.PhotoDbEntityToDataMapper
import com.ausom.local.mapper.PhotoEntityToLocalDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val photoDao: PhotoDao,
    private val photoDbEntityToDataMapper: PhotoDbEntityToDataMapper,
    private val photoEntityToLocalDataMapper: PhotoEntityToLocalDataMapper,
    private val pageInfoDao: PageInfoDao,
    private val pageInfoDbEntityToDataMapper: PageInfoDbEntityToDataMapper,
    private val pageInfoEntityToLocalDataMapper: PageInfoEntityToLocalDataMapper
) : LocalDataSource {

    override fun getPhotos(): Flow<List<PhotoEntity>> {
        return photoDao.getPhotos().map(photoDbEntityToDataMapper::mapList)
    }

    override fun persistPhotos(photos: List<PhotoEntity>) {
        photoDao.insert(photos.map(photoEntityToLocalDataMapper::map))
    }

    override fun persistPageInfo(pageInfoEntity: PageInfoEntity) {
        pageInfoDao.insert(pageInfoEntityToLocalDataMapper.map(pageInfoEntity))
    }

    override fun getPageInfo(pageName: String): PageInfoEntity {
        return pageInfoDbEntityToDataMapper.map(pageInfoDao.getNextPageInfo(pageName))
    }

    override fun clearAll() {
        photoDao.deleteAll()
    }
}