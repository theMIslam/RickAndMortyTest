package com.example.rickandmortytests.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortytests.databinding.ItemCardBinding
import com.example.rickandmortytests.domain.model.RickAndMortyModel

class RickAndMortyAdapter : RecyclerView.Adapter<RickAndMortyAdapter.myViewHolder>() {
    inner class myViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<RickAndMortyModel>() {
        override fun areItemsTheSame(
            oldItem: RickAndMortyModel,
            newItem: RickAndMortyModel
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: RickAndMortyModel,
            newItem: RickAndMortyModel
        ): Boolean = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, differCallBack)

    fun submitList(list: List<RickAndMortyModel>) = differ.submitList(list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder = myViewHolder(
        ItemCardBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
    )

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            imageview.load(item.image)
            textView.text = item.name
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}