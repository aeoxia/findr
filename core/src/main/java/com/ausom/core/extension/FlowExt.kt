package com.ausom.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


/**
 *  Simplified call for [launch] on a [LifecycleOwner] where [Flow.collect] is handled with its result
 */
fun<T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, block: suspend (T) -> Unit) {
    lifecycleOwner.lifecycleScope.launchWhenStarted {
        collectLatest {
            block.invoke(it)
        }
    }
}

/**
 *  Simplified call for [launch] on [ViewModel] where [Flow.collect] is handled with its result
 */
fun<T> Flow<T>.observe(viewModel: ViewModel, context: CoroutineContext, block: suspend (T) -> Unit) {
    viewModel.viewModelScope.launch(context) {
        collectLatest {
            block.invoke(it)
        }
    }
}

/**
 *  Simplified call for [launch] on [ViewModel] where [Flow.collect] is handled ignoring its result
 */
fun<T> Flow<T>.load(viewModel: ViewModel, context: CoroutineContext) {
    viewModel.viewModelScope.launch(context) {
        this@load.collect()
    }
}

