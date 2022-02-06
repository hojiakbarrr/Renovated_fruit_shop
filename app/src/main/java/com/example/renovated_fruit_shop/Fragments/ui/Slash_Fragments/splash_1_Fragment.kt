package com.example.renovated_fruit_shop.Fragments.ui.Slash_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.renovated_fruit_shop.Fragments.ui.home.HomeFragmentDirections
import com.example.renovated_fruit_shop.Fragments.ui.sig_in_Fragments.Sign_in_Fragment
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.databinding.FragmentFirstStartBinding
import com.example.renovated_fruit_shop.databinding.FragmentSplash1Binding

class splash_1_Fragment : Fragment() {
    lateinit var binding: FragmentSplash1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSplash1Binding.inflate(layoutInflater,container,false)

        binding.next.setOnClickListener {

//            val action =  splash_1_FragmentDirections.actionSplash1FragmentToSplash2Fragment()
//            Navigation.findNavController(it).navigate(action)

            val yoursFragment: Fragment = splash_2_Fragment()
            val trans = requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(R.id.splash_1_Fragment.toString())
            trans.commit()
        }

        binding.skip1.setOnClickListener {
            val yoursFragment: Fragment = Sign_in_Fragment()
            val trans = requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(null)
            trans.commit()
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}