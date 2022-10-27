package com.example.hv3_6_kt.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hv3_6_kt.databinding.ItemMuzicBinding
import com.example.hv3_6_kt.ui.models.MusicData

class MusicAdapter(
    private val list: List<MusicData>,
    private val onItemClick: (title: String) -> Unit
) :
    RecyclerView.Adapter<MusicAdapter.MusicVieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicVieHolder {
        return MusicVieHolder(
            ItemMuzicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MusicVieHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    // class -> если он вложен в какой-то класс
    // class Foo {
    // private var id = 0
    // private val list = listOf()
    //   class Bar {
    // val uId = id
    //
    //}
    // }
    //

    inner class MusicVieHolder(private val binding: ItemMuzicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(musicData: MusicData) {
            binding.tvRank.text = musicData.rank
            binding.tvSongName.text = musicData.songName
            binding.tvAuthor.text = musicData.author
            binding.tvDuration.text = musicData.duration
        }

        init {
            // itemView.setOnClickListener == binding.root.setOnClickListener
            binding.root.setOnClickListener {
                onItemClick(list[adapterPosition].songName)
            }
        }
    }
}