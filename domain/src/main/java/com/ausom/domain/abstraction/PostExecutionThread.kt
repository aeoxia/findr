package com.ausom.domain.abstraction

import kotlinx.coroutines.CoroutineDispatcher

/**
 *  Abstraction for Dispatchers, this allows flexibility of switching Dispatcher implementation especially during testing
 */
interface PostExecutionThread {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}