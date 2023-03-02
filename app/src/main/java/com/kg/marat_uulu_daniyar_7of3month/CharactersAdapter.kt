package com.kg.marat_uulu_daniyar_7of3month

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.kg.marat_uulu_daniyar_7of3month.databinding.ItemCharactersListBinding

class CharactersAdapter(
    val charactersList: ArrayList<Characters>,
    val onItemClick: (position: Int) -> Unit
): Adapter<CharactersAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharactersListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = charactersList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


    inner class ViewHolder(private val binding: ItemCharactersListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            val characters = charactersList[adapterPosition]
            binding.apply {
                Glide.with(imgOfCharacter).load(characters.picture).into(imgOfCharacter)
                tvStatus.text = characters.status
                tvName.text = characters.name
            }
            itemView.setOnClickListener {onItemClick(adapterPosition)}

        }
    }
}