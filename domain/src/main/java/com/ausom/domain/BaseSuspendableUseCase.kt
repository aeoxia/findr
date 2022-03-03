package com.ausom.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 *
 * This is the base class for any use case that needs to be synchronous
 *
 * @property coroutineDispatcher allows flexibility
 */
abstract class BaseSuspendableUseCase<in Param, out Result>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    /**
     *
     * This is the execution block where the main logic of the use case happen
     *
     * @param param is a generic type which is a dependent data needed for the use case
     * @return the expected result of the use case
     * */
    abstract suspend fun execute(param: Param? = null): Result

    /**
     *
     * This is the execution block where the main logic of the use case happen
     *
     * @param param is a generic type which is a dependent data needed for the use case
     * @return the expected result of the use case
     * */
    suspend operator fun invoke(param: Param? = null): Result = withContext(coroutineDispatcher) { execute(param) }
}