package com.ausom.findr.feature.photolist

sealed class PageState {
    object Loading: PageState()
    object Loaded: PageState()
}
