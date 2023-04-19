package com.example.musicapp.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import com.example.musicapp.R
import com.google.android.material.textview.MaterialTextView

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {

            val text = "${song.title} - ${song.subtitle}"

            rootView.findViewById<MaterialTextView>(R.id.tvPrimary).text = text

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }
}