package com.example.m018_permission.premission

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m018_permission.R
import com.example.m018_permission.data.Photo
import com.example.m018_permission.databinding.PhotoCardBinding

class PhotoAdapter(context: Context, private val onItemClickListener: (Photo) -> Unit) : RecyclerView.Adapter<PhotoHolder>() {

    private var photoList: List<Photo> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val binding = PhotoCardBinding.inflate(LayoutInflater.from(parent.context))
        return PhotoHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val currentPhoto = photoList.get(position)

        with(holder.binding) {
            Glide
                .with(holder.itemView.context)
                .load(Uri.parse(currentPhoto.photoUri))
                .into(photoView)
            textView.text = currentPhoto.date
        }
        holder.binding.root.setOnClickListener {
            currentPhoto?.let {
                onItemClickListener(currentPhoto)
            }
        }

    }

    fun setData(photos: List<Photo>) {
        photoList = photos
        notifyDataSetChanged()
    }
}

class PhotoHolder(val binding: PhotoCardBinding) : RecyclerView.ViewHolder(binding.root)