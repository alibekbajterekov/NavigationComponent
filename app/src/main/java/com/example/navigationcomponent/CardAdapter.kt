package com.example.navigationcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.databinding.ItemPlateBinding

class CardAdapter(
    var cardList: ArrayList<Card>,
    var onClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    inner class CardViewHolder(private val binding: ItemPlateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            itemView.setOnClickListener { onClick(adapterPosition)}
            var item = cardList[adapterPosition]
            binding.apply {
                tvLife.text = item.tvLife
                tvName.text = item.tvName
                imageView.setImageResource(item.image!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ItemPlateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = cardList.size
}
