package com.ausom.findr.feature.photolist

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ausom.core.extension.*
import com.ausom.core.ui.GridSpacingItemDecoration
import com.ausom.findr.R
import com.ausom.findr.databinding.FragmentPhotoListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PhotoListFragment : Fragment(R.layout.fragment_photo_list)  {

    private val _binding by viewBinding(FragmentPhotoListBinding::bind)
    private val _viewModel by viewModels<PhotoListViewModel>()

    /**
     * locks the [PhotoListViewModel.loadMore] until [PhotoListAdapter.submitList] is called on UI level
     * */
    private var _shouldLoad = true

    @Inject
    lateinit var adapter: PhotoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(_binding) {
            rvPhotoList.adapter = adapter
            with(rvPhotoList) {
                val spanCount = 3
                val spacing = 20.dpToPx
                addItemDecoration(GridSpacingItemDecoration(
                    spanCount = spanCount,
                    spacing = spacing,
                    includeEdge = true
                ))
                layoutManager = GridLayoutManager(requireContext(), 3).also { layoutManager ->
                    addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        var pastVisibleItems = 0 //previously visible items on screen
                        var visibleItemCount: Int = 0 //visible items on screen
                        var totalItemCount: Int = 0 //total items in the list
                        var offset = 10 //margin before preloading of items happen
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            if (dy > 0) { //check for scroll down
                                visibleItemCount = layoutManager.childCount
                                totalItemCount = layoutManager.itemCount
                                pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                                if (_shouldLoad) {
                                    if (visibleItemCount + pastVisibleItems + offset >= totalItemCount) {
                                        _shouldLoad = false
                                        _viewModel.loadMore()
                                    }
                                }
                            }
                        }
                    })
                }

            }

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(input: String?): Boolean {
                    if (!input.isNullOrEmpty()) {
                        _viewModel.search(input, 1)
                    }
                    return false
                }

                override fun onQueryTextChange(input: String?): Boolean {
                    return false
                }
            })

            searchView.setOnQueryTextFocusChangeListener { _, hasFocus ->
                imgLogo showIf !hasFocus
            }
        }
        with(_viewModel) {
            _viewModel.search(DEFAULT_KEYWORD, 1)
            photos.observe(this@PhotoListFragment) {
                adapter.submitList(it) {
                    _shouldLoad = true
                }
            }
            pageState.observe(this@PhotoListFragment) { state ->
                _binding.viewLoading showIf (state == PageState.Loading)
            }
        }
    }

    companion object {
        //using this default search keyword as homepage
        const val DEFAULT_KEYWORD = "flower"
    }
}