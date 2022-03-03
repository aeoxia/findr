package com.ausom.domain.usecase

import com.ausom.domain.BaseUseCase
import com.ausom.domain.abstraction.FindrRepository
import com.ausom.domain.abstraction.PostExecutionThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadMorePhotos @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val repository: FindrRepository
) : BaseUseCase<Unit, Unit>(postExecutionThread.io) {
    override fun execute(param: Unit?): Flow<Unit> {
        return repository.loadMorePhotos()
    }
}