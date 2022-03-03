package com.ausom.findr.feature.photolist

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ausom.core.extension.observe
import com.ausom.core.extension.viewBinding
import com.ausom.findr.R
import com.ausom.findr.databinding.FragmentPhotoListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PhotoListFragment : Fragment(R.layout.fragment_photo_list)  {

    private val _binding by viewBinding(FragmentPhotoListBinding::bind)
    private val _viewModel by viewModels<PhotoListViewModel>()

    @Inject
    lateinit var adapter: PhotoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(_binding) {
            rvPhotoList.adapter = adapter
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(input: String?): Boolean {
                    if(!input.isNullOrEmpty()) {
                        _viewModel.search(input)
                        return true
                    }
                    return false
                }

                override fun onQueryTextChange(input: String?): Boolean {
                    return false
                }
            })
        }
        with(_viewModel) {
            photos.observe(this@PhotoListFragment) {
                adapter.submitList(it)
            }
        }
    }
}