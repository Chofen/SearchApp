package com.example.searchapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.searchapp.databinding.ActivityMainBinding
import com.example.searchapp.model.Photo


class PhotoSearchAdapter : RecyclerView.Adapter<PhotoSearchAdapter.ViewHolder>() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var context: Context


    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        fun bind(photo: Photo) {
            binding.apply {
      //      val urlAPISearch = BASE_URL + photo.page

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding= ActivityMainBinding.inflate(inflater,parent,false)
        context=parent.context
        return ViewHolder()
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
    private val differCallback = object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }


    }
    val differ = AsyncListDiffer(this, differCallback)
}