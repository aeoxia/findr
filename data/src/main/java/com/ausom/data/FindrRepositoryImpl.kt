package com.ausom.data

import com.ausom.data.mapper.PhotoEntityToDomainMapper
import com.ausom.data.model.PageInfoEntity
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
    override fun getPhotos(): Flow<List<Photo>> {
        return localDataSource.getPhotos().map(photoEntityToDomainMapper::mapList)
    }

    override fun searchPhotos(keyword: String, page: Int): Flow<Unit> = flow {
        val photos = remoteDataSource.searchPhotos(keyword, page)
        localDataSource.clearAll()
        localDataSource.persistPhotos(photos)

        val nextPageInfo = PageInfoEntity(
            pageName = PHOTO_LIST_PAGE,
            nextPageNumber = page + 1,
            searchKeyword = keyword
        )
        localDataSource.persistPageInfo(nextPageInfo)
        emit(Unit)
    }

    override fun loadMorePhotos(): Flow<Unit> = flow {
        val currentPageInfo = localDataSource.getPageInfo(PHOTO_LIST_PAGE)
        val pageNumber = currentPageInfo.nextPageNumber
        val keyword = currentPageInfo.searchKeyword
        val photos = remoteDataSource.searchPhotos(keyword, pageNumber)
        localDataSource.persistPhotos(photos)

        val nextPageInfo = PageInfoEntity(
            pageName = PHOTO_LIST_PAGE,
            nextPageNumber = pageNumber + 1,
            searchKeyword = keyword
        )
        localDataSource.persistPageInfo(nextPageInfo)
        emit(Unit)
    }

    companion object {
        const val PHOTO_LIST_PAGE = "photoListPage"
    }
}