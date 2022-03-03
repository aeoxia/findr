package com.ausom.domain.usecase

import com.ausom.domain.BaseUseCase
import com.ausom.domain.abstraction.FindrRepository
import com.ausom.domain.abstraction.PostExecutionThread
import com.ausom.domain.model.SearchPhotoParam
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPhotos @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val repository: FindrRepository
) : BaseUseCase<SearchPhotoParam, Unit>(postExecutionThread.io) {

    /**
     * Loads all photos under the given [param] from Flickr API
     */
    override fun execute(param: SearchPhotoParam?): Flow<Unit> {
        val searchPhotoParam = param!!
        return repository.searchPhotos(searchPhotoParam.keyword, searchPhotoParam.page)
    }
}