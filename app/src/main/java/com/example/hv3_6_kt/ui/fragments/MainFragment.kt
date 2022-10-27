package com.example.hv3_6_kt.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.hv3_6_kt.R
import com.example.hv3_6_kt.databinding.FragmentMainBinding
import com.example.hv3_6_kt.ui.adapters.MusicAdapter
import com.example.hv3_6_kt.ui.models.MusicData

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val musicAdapter = MusicAdapter(
            listOf(
                MusicData("1", "sobg", "dfn", "3:22"),
                MusicData("2", "ssdfj", "dsfds", "3:22"),
                MusicData("3", "fsbfg", "dffbdfdn", "3:22"),
                MusicData("4", "ssdfbsfj", "dsfbfbffds", "3:2"),
                MusicData("5", "sfbbzzdobg", "dfn", "3:22"),
                MusicData("6", "ssdfj", "dsfds", "3:22"),
                MusicData("7", "sobg", "dfn", "3:22"),
                MusicData("8", "ssdfj", "dsfds", "3:22"),
                MusicData("9", "sobg", "dfn", "3:22"),
                MusicData("10", "ssdfj", "dsfds", "3:22"),
            ), this::onItemClick
        )
        binding.rvSongs.adapter = musicAdapter
    }

    private fun onItemClick(songName: String) {
        val fragment = SuporFragment()
        val bundle = Bundle()
        bundle.putString("key", songName)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_music)
            ?.requireView()?.isGone = true
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.second_fragment, fragment).commit()
    }


    // RecyclerView - список из айтемов -> ViewHolder(Item'ка) - то, как будет выглядеть предмет в RecyclerView -> Adapter -
    // связывает айтемку и recyclerview
}