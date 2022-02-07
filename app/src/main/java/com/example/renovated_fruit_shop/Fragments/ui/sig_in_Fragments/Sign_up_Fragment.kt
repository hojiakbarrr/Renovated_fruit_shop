package com.example.renovated_fruit_shop.Fragments.ui.sig_in_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.renovated_fruit_shop.DataBase.FrutsDataBase
import com.example.renovated_fruit_shop.DataBase.UserDataBase
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.DataClass.Users
import com.example.renovated_fruit_shop.Fragments.ui.home.HomeFragment
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.Static_class.ListUsers
import com.example.renovated_fruit_shop.databinding.FragmentSignUpBinding

class Sign_up_Fragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding

    var logIn: String = ""

    var parol: String = ""

    var mail: String = ""

    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)


        binding.registerCreat.setOnClickListener {

            logIn = binding.CreatLoginn.text.toString()

            parol = binding.CreatPassword.text.toString()

            mail = binding.CreatMail.text.toString()

            name = binding.CreatName.text.toString()

            /////*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
            /////*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
            var usersF = Users()

            usersF.login = logIn

            usersF.password = parol

            usersF.mail = mail

            usersF.name = name
            /////*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
            /////*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/

            UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().add_New_User(usersF)

//            var frukt = FruitsData()
//            frukt.Favoritess_id = usersF.userId

            Toast.makeText(requireContext(), "аккаунт создан", Toast.LENGTH_SHORT).show()

            /////*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
            /////*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/
            val yoursFragment: Fragment =  Sign_in_Fragment()
            val trans = requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(null)
            trans.commit()

        }


        binding.creatLogin.setOnClickListener {
            val yoursFragment: Fragment =  Sign_in_Fragment()
            val trans = requireFragmentManager().beginTransaction()
            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(null)
            trans.commit()
        }

        return binding.root
    }


}