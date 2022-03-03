package com.ausom.findr.feature.photolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ausom.core.utility.DefaultDiffUtil
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
                    imgPhoto.load(photo.url)
                }
            }
        }
    }
}