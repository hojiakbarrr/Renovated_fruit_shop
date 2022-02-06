package com.example.renovated_fruit_shop.Fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.renovated_fruit_shop.databinding.FragmentDetailBinding

class Detail_Fragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    val oldNotes by navArgs<Detail_FragmentArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {




        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)

        binding.cardPhoto.setImageResource(oldNotes.data.image)

        binding.favDescr.setText(oldNotes.data.description)

        binding.favTitle.setText(oldNotes.data.title)

        binding.favNutDesc.setText(oldNotes.data.nutrition_1)

        binding.favPrice.setText(oldNotes.data.per_kg)


        // Inflate the layout for this fragment
        return binding.root}

}