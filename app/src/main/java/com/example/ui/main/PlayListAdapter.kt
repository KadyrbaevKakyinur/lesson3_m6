package com.example.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.data.model.PlayListModel
import com.example.lesson3_m6.databinding.ItemPlaylistBinding

class PlayListAdapter : Adapter<PlayListAdapter.PlaylistViewHolder>() {
    private var list = mutableListOf<PlayListModel.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(model: PlayListModel) {
        list = model.items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }


    override fun getItemCount() = list.size
    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(playlistsModelItem: PlayListModel.Item) {
            with(binding) {
                Glide.with(imageView).load(playlistsModelItem.snippet.thumbnails.default.url)
                    .into(imageView)
                textViewTitle.text = playlistsModelItem.snippet.title
                textViewCount.text = "${playlistsModelItem.contentDetails.itemCount} video series"
            }
        }
    }
}