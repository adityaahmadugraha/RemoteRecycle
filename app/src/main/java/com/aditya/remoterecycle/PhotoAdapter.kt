package com.aditya.remoterecycle

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aditya.remoterecycle.databinding.ItemPhotoBinding
import com.bumptech.glide.Glide

class PhotoAdapter(
    private val onClick: (Photo) -> Unit
) : ListAdapter<Photo, PhotoAdapter.ViewHOlder>(DIF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHOlder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHOlder(binding)
    }

    override fun onBindViewHolder(holder: ViewHOlder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(getItem(position))

    }

    inner class ViewHOlder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Photo) {
            binding.txtPhotos.text = data.title
            Glide.with(itemView.context)
                .load(data.thumbnailUrl)
                .error(android.R.color.darker_gray)
                .into(binding.imgPhotos)
            binding.cardView.setOnClickListener {
                onClick(data)
            }

        }

    }

    companion object {
        val DIF_CALLBACK: DiffUtil.ItemCallback<Photo> =
            object : DiffUtil.ItemCallback<Photo>() {
                override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                    return oldItem == newItem
                }

            }
        }
    }
