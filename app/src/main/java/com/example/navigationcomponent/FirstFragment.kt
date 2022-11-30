package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var list = arrayListOf<Card>()

    companion object {
        const val KEY_DETAIL_CARD = "card"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = CardAdapter(list, this::onClick)
        binding.rvCard.adapter = adapter

    }

    private fun onClick(position: Int) {
        findNavController().navigate(
            R.id.detailCardFragment,
            bundleOf(KEY_DETAIL_CARD to list[position])
        )
    }

    private fun loadData() {
        list.add(Card("Alive", "Rick Sanchez", R.drawable.rick))
        list.add(Card("Alive", "Morty Smith", R.drawable.morty))
        list.add(Card("Dead", "Albert Einstein", R.drawable.albert))
        list.add(Card("Alive", "Jerry Smith", R.drawable.jerry))
    }


}