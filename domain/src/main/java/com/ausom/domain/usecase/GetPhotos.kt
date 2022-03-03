package com.ausom.domain.usecase

import com.ausom.domain.BaseUseCase
import com.ausom.domain.abstraction.FindrRepository
import com.ausom.domain.abstraction.PostExecutionThread
import com.ausom.domain.model.Photo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotos @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val repository: FindrRepository
): BaseUseCase<String, List<Photo>>(postExecutionThread.io) {

    /**
     * Gets all photos locally using the given [param]
     */
    override fun execute(param: String?): Flow<List<Photo>> {
        val keyword = param!!
        return repository.getPhotos(keyword)
    }
}