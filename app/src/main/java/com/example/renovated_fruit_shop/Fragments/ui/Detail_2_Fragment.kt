package com.example.renovated_fruit_shop.Fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.renovated_fruit_shop.DataBase.FrutsDataBase
import com.example.renovated_fruit_shop.DataBase.UserDataBase
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.Static_class.ListUsers
import com.example.renovated_fruit_shop.databinding.FragmentDetail2Binding
import com.example.renovated_fruit_shop.databinding.FragmentDetailBinding

class Detail_2_Fragment : Fragment() {

    lateinit var binding: FragmentDetail2Binding

    companion object {
        var Detailsfruitsss: ArrayList<FruitsData> = ArrayList()
    }

    var detail = FruitsData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetail2Binding.inflate(layoutInflater, container, false)

        for (u in Detailsfruitsss) {

            binding.cardPhoto2.setImageResource(u.image)

            binding.favDescr2.setText(u.description)

            binding.favTitle2.setText(u.title)

            binding.favNutDesc2.setText(u.nutrition_1)

            binding.favPrice2.setText(u.per_kg)

            detail = u

            binding.buyDetail2.setOnClickListener {
                for (r in Detailsfruitsss) {
                    detail = r
                    for (o in UserDataBase.getDatabaseInstance(requireContext()).allUsersDao()
                        .getAllUser()!!) {
                        if (o.userId == ListUsers.allUsers.userId) {
                            r.Favoritess_id = ""
                            r.Orders_id = o.userId
                            detail.Orders_id = o.userId
                            detail.Favoritess_id = ""

                            FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao().update_Fruits_Favorites(detail)

                            FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao().update_Fruits_Favorites(r)

//                            FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
//                                .add_New_Fruits_Favorites(detail)
//
//                            FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
//                                .add_New_Fruits_Favorites(r)

                            Toast.makeText(requireContext(),
                                "фрукт добавляетс в лист заказов",
                                Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(requireContext(),
                                "фрукт пока не может добавиться в лист заказов",
                                Toast.LENGTH_SHORT).show()

                        }
                    }
                }
            }
        }




        // Inflate the layout for this fragment
        return binding.root
    }


}