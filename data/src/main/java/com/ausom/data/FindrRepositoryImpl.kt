package com.ausom.data

import com.ausom.data.mapper.PhotoEntityToDomainMapper
import com.ausom.domain.abstraction.FindrRepository
import com.ausom.domain.model.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FindrRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val photoEntityToDomainMapper: PhotoEntityToDomainMapper
): FindrRepository {
    override fun getPhotos(keyword: String): Flow<List<Photo>> {
        return localDataSource.getPhotos(keyword).map(photoEntityToDomainMapper::mapList)
    }

    override fun searchPhotos(keyword: String): Flow<Unit> = flow {
        val photos = remoteDataSource.searchPhotos(keyword)
        localDataSource.persistPhotos(photos)
        emit(Unit)
    }
}