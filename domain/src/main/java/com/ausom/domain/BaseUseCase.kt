package com.ausom.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 *
 * This is the base class for any use case that needs to asynchronous
 *
 * @property coroutineDispatcher allows flexibility
 */
abstract class BaseUseCase<in Param, out Result>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    /**
     *
     * This is the execution block where the main logic of the use case happen
     *
     * @param param is a generic type which is a dependent data needed for the use case
     * */
    abstract fun execute(param: Param? = null): Flow<Result>

    /**
     *
     * This overrides invoke operator run on the given dispatcher synchronously
     *
     * @param param is a generic type which is a dependent data needed for the use case
     * @return the expected result of the use case
     * */
    operator fun invoke(param: Param? = null): Flow<Result> = execute(param).flowOn(coroutineDispatcher)
}