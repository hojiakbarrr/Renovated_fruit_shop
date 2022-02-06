package com.example.renovated_fruit_shop.Fragments.ui.Slash_Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.databinding.FragmentFirstStartBinding
import java.util.*


class first_start_Fragment : Fragment() {

    lateinit var binding: FragmentFirstStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstStartBinding.inflate(layoutInflater,container,false)




        Handler().postDelayed(Runnable {

            val yoursFragment: Fragment = splash_1_Fragment()
            val trans = requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(R.id.first_start_Fragment.toString())
            trans.commit()


        }, 10000)
        return inflater.inflate(R.layout.fragment_first_start_, container, false)



        return binding.root

    }


}