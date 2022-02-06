package com.example.renovated_fruit_shop.Fragments.ui.Slash_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.renovated_fruit_shop.Fragments.ui.sig_in_Fragments.Sign_in_Fragment
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.databinding.FragmentSplash2Binding
import com.example.renovated_fruit_shop.databinding.FragmentSplash3Binding

class splash_3_Fragment : Fragment() {
    lateinit var binding: FragmentSplash3Binding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSplash3Binding.inflate(layoutInflater,container,false)


        binding.button.setOnClickListener {

            val yoursFragment: Fragment = Sign_in_Fragment()
            val trans = requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(R.id.splash_2_Fragment.toString())
            trans.commit()
        }

        binding.textView.setOnClickListener {
            val yoursFragment: Fragment = Sign_in_Fragment()
            val trans =  requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(null)
            trans.commit()
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}