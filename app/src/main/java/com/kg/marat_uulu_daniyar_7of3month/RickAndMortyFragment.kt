package com.kg.marat_uulu_daniyar_7of3month

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.kg.marat_uulu_daniyar_7of3month.databinding.FragmentRickAndMortyBinding

class RickAndMortyFragment : Fragment() {
    private lateinit var binding: FragmentRickAndMortyBinding
    private var charactersList = arrayListOf(
        Characters("https://cdn.rikmorti.ru/uploads/2020/02/rik-sanchez-rikmorti-ru.jpg", "Alive", "Rick Sanchez","Rick Sanchez is one of the two main characters in the American animated television series Rick and Morty, created by Justin Roiland and Dan Harmon. Rick is a brilliant scientist, alcoholic, realist, atheist and misanthrope; for the character of negona, cynicism and disregard for generally accepted norms of behavior, and he is also afraid of pirates."),
        Characters("https://static.wikia.nocookie.net/rickandmorty/images/b/ba/%D0%9C%D0%BE%D1%80%D1%82%D0%B8_C%D0%BC%D0%B8%D1%82_003.jpg/revision/latest/smart/width/300/height/300?cb=20210729131220&path-prefix=ru", "Alive", "Morty Smith", "Mortimer \"Morty\" Smith is one of the main characters of the American animated comedy series Rick and Morty, the grandson of Rick Sanchez, an insecure and paranoid 14-year-old high school student, whose image is based on the image of Marty McFly from the science fiction trilogy \" Back to the Future\"."),
        Characters("https://static.wikia.nocookie.net/rickandmorty/images/b/bc/Albert_Einstein.png/revision/latest/smart/width/250/height/250?cb=20150730213810", "Dead", "Albert Einstein", "Albert Einstein is a short scientist with white, spiky hair and a uni-brow and a mustache and glasses. He wears a lab coat and a yellow shirt and green pants and black shoes."),
        Characters("https://static.wikia.nocookie.net/rickandmorty/images/f/f1/Jerry_Smith.png/revision/latest?cb=20160923151111", "Alive", "Jerry Smith", "Gerald \"Jerry\" Smith is one of the main characters in the American animated television series Rick and Morty and the franchise that stems from it. Created by Justin Roiland and Dan Harmon and voiced by Chris Parnell, Jerry is depicted as a stay-at-home father who finds fulfillment in his simple life.")
    )

    companion object{
        const val KEY_FOR_INFO = "key"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharactersAdapter(charactersList, this::onItemClick)
        binding.rvCharactersList.adapter = adapter
    }

    private fun onItemClick (position: Int){
        val characters = charactersList[position]
        findNavController().navigate(R.id.infoOfCharactersFragment, bundleOf(KEY_FOR_INFO to characters))
    }
}