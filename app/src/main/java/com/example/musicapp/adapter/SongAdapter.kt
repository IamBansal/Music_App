package com.example.musicapp.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.example.musicapp.R
import com.google.android.material.textview.MaterialTextView
import javax.inject.Inject

class SongAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseSongAdapter(R.layout.list_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {

            rootView.findViewById<MaterialTextView>(R.id.tvPrimary).text = song.title
            rootView.findViewById<MaterialTextView>(R.id.tvSecondary).text = song.subtitle
            glide.load(song.imageUrl).into( rootView.findViewById(R.id.ivItemImage))

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }
}









//class SongAdapter @Inject constructor(
//    private val glide: RequestManager
//) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
//
//    class SongViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(song: Song, glide: RequestManager){
//            binding.tvPrimary.text = song.title
//            binding.tvSecondary.text = song.subtitle
//            glide.load(song.imageUrl).into(binding.ivItemImage)
//        }
//    }
//
//    private val diffCallback = object : DiffUtil.ItemCallback<Song>() {
//        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
//            return oldItem.mediaId == newItem.mediaId
//        }
//
//        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
//            return oldItem.hashCode() == newItem.hashCode()
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//
//    var songs: List<Song>
//        get() = differ.currentList
//    set(value) = differ.submitList(value)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
//        return SongViewHolder(
//            ListItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
//        val song = songs[position]
//        holder.bind(song, glide)
//        holder.itemView.apply {
//            setOnClickListener {
//                onItemClickListener?.let { click ->
//                    click(song)
//                }
//            }
//        }
//    }
//
//    private var onItemClickListener: ((Song) -> Unit)? = null
//
//    fun setOnItemClickListener(listener: (Song) -> Unit) {
//        onItemClickListener = listener
//    }
//
//    override fun getItemCount(): Int {
//        return songs.size
//    }
//}