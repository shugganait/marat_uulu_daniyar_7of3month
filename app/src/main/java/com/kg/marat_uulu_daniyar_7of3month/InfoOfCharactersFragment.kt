package com.kg.marat_uulu_daniyar_7of3month

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kg.marat_uulu_daniyar_7of3month.databinding.FragmentInfoOfCharactersBinding

class InfoOfCharactersFragment : Fragment() {
    private lateinit var binding: FragmentInfoOfCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoOfCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = arguments?.getParcelable<Characters>(RickAndMortyFragment.KEY_FOR_INFO)
        binding.apply {
            Glide.with(imgOfCharacter).load(character?.picture).into(imgOfCharacter)
            tvStatus.text = character?.status
            tvName.text = character?.name
            tvTinyInfo.text = character?.tinyInfo
        }
    }


}