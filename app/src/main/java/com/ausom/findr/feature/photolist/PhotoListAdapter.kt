package com.ausom.findr.feature.photolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import com.ausom.core.utility.DefaultDiffUtil
import com.ausom.findr.R
import com.ausom.findr.databinding.ItemPhotoBinding
import com.ausom.findr.model.PhotoDisplay
import javax.inject.Inject


class PhotoListAdapter @Inject constructor(): ListAdapter<PhotoDisplay, PhotoListAdapter.PhotoViewHolder>(DefaultDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class PhotoViewHolder(private val _binding: ItemPhotoBinding): RecyclerView.ViewHolder(_binding.root) {
        fun bind(position: Int) {
            getItem(position).let { photo ->
                with(_binding) {
                    txtTitle.text = photo.title

                    val imageContext = imgPhoto.context
                    imgPhoto.load(photo.image) {
                        size(256)
                        placeholder(R.drawable.ic_baseline_image_24)
                        error(R.drawable.ic_baseline_broken_image_24)
                    }
                }
            }
        }
    }
}