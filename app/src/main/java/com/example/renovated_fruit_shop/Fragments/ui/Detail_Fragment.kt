package com.example.renovated_fruit_shop.Fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.databinding.FragmentDetailBinding

class Detail_Fragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    companion object {
        var Detailsfruits: ArrayList<FruitsData> = ArrayList()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {




        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)

        for (u in Detailsfruits){

            binding.cardPhoto.setImageResource(u.image)

            binding.favDescr.setText(u.description)

            binding.favTitle.setText(u.title)

            binding.favNutDesc.setText(u.nutrition_1)

            binding.favPrice.setText(u.per_kg)


        }

        binding.buyDetail.setOnClickListener {

        }


        // Inflate the layout for this fragment
        return binding.root}

}