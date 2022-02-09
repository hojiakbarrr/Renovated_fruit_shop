package com.example.renovated_fruit_shop.Fragments.ui.sig_in_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import com.example.renovated_fruit_shop.DataBase.UserDataBase
import com.example.renovated_fruit_shop.Fragments.ui.Detail_2_Fragment
import com.example.renovated_fruit_shop.Static_class.DataModel
import com.example.renovated_fruit_shop.Fragments.ui.home.HomeFragment
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.Static_class.ListUsers
import com.example.renovated_fruit_shop.databinding.FragmentSignInBinding

class Sign_in_Fragment : Fragment() {

    lateinit var binding: FragmentSignInBinding
    var log: Boolean = false
    var par: Boolean = false

    private val dataModel: DataModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)


        binding.editLogin.doOnTextChanged { text, start, before, count ->
            if (text!!.length < 4) {
                binding.laylogin.error = "No more"
            } else if (text.length > 4) {
                binding.editLogin.error = null
            }
        }

        binding.register.setOnClickListener {
//            val yoursFragment: Fragment =  Sign_up_Fragment()
//            val trans = requireFragmentManager().beginTransaction()
//            trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).addToBackStack(R.id.sign_in_Fragment.toString())
//            trans.commit()

            parentFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,Sign_up_Fragment()).addToBackStack(R.id.splash_1_Fragment.toString()).commit()
        }



        binding.enter.setOnClickListener {
            var logIn = binding.editLogin.text.toString()
            var parol = binding.editPassword.text.toString()

//            UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().getAllUser()!!

            for (o in UserDataBase.getDatabaseInstance(requireContext()).allUsersDao().getAllUser()!!) {
                if (o.login == logIn && o.password == parol) {
                    log = true
                    dataModel.name.value = o.name
                    dataModel.mail.value = o.mail
                    ListUsers.allUsers = o
                    Toast.makeText(requireContext(), "Вы в главном меню", Toast.LENGTH_SHORT).show()
//                    var intent: Intent? = Intent(context, Drawer_activity::class.java)
                    val yoursFragment: Fragment =  HomeFragment()
                    val trans = requireFragmentManager().beginTransaction()
                    trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).setReorderingAllowed(true).addToBackStack(R.id.sign_in_Fragment.toString())
                    trans.commit()

//                    startActivity(intent)
                    par = true
                } else if (!log) {
                    par = true
                    Toast.makeText(requireContext(), "Такого аккаунiта нет", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            if (!par) {
                Toast.makeText(requireContext(), "Такого аккаунiта нет", Toast.LENGTH_SHORT).show()
            } else {

            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}