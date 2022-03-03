package com.ausom.findr.feature.photolist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ausom.core.extension.viewBinding
import com.ausom.findr.R
import com.ausom.findr.databinding.FragmentPhotoListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PhotoListFragment : Fragment(R.layout.fragment_photo_list)  {

    private val _binding by viewBinding(FragmentPhotoListBinding::bind)

    @Inject
    lateinit var adapter: PhotoListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(_binding) {
            rvPhotoList.adapter = adapter
        }
    }
}