package com.ausom.findr.feature.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ausom.core.extension.load
import com.ausom.domain.model.SearchPhotoParam
import com.ausom.domain.usecase.GetPhotos
import com.ausom.domain.usecase.LoadMorePhotos
import com.ausom.domain.usecase.SearchPhotos
import com.ausom.findr.mapper.PhotoToDisplayMapper
import com.ausom.findr.model.PhotoDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getPhotos: GetPhotos,
    private val searchPhotos: SearchPhotos,
    private val loadMorePhotos: LoadMorePhotos,
    private val photoToDisplayMapper: PhotoToDisplayMapper
) : ViewModel() {

    private val _pageState = MutableStateFlow<PageState>(PageState.Loading)
    val pageState: StateFlow<PageState>
        get() = _pageState

    private val _exceptionHandler = CoroutineExceptionHandler { _, _ -> }
    val photos: StateFlow<List<PhotoDisplay>>
        get() = getPhotos().map(photoToDisplayMapper::mapList)
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun search(keyword: String, page: Int) {
        viewModelScope.launch(_exceptionHandler) {
            _pageState.value = PageState.Loading
            searchPhotos(SearchPhotoParam(keyword, page)).collect()
            _pageState.value = PageState.Loaded
        }
    }

    fun loadMore() {
        loadMorePhotos().load(this, _exceptionHandler)
    }
}