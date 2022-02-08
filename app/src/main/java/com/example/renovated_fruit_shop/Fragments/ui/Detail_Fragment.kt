package com.example.renovated_fruit_shop.Fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.renovated_fruit_shop.DataBase.FrutsDataBase
import com.example.renovated_fruit_shop.DataBase.UserDataBase
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.Static_class.ListUsers
import com.example.renovated_fruit_shop.databinding.FragmentDetailBinding

class Detail_Fragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    companion object {
        var Detailsfruits: ArrayList<FruitsData> = ArrayList()
    }

    var detail = FruitsData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        for (u in Detailsfruits) {

            binding.cardPhoto.setImageResource(u.image)

            binding.favDescr.setText(u.description)

            binding.favTitle.setText(u.title)

            binding.favNutDesc.setText(u.nutrition_1)

            binding.favPrice.setText(u.per_kg)

            detail = u


        }

        binding.buyDetail.setOnClickListener {
            for (r in Detailsfruits) {
                detail = r
                for (o in UserDataBase.getDatabaseInstance(requireContext()).allUsersDao()
                    .getAllUser()!!) {
                    if (o.userId == ListUsers.allUsers.userId) {
                        r.Orders_id = o.userId
                        detail.Orders_id = o.userId
                        FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                            .add_New_Fruits_Favorites(detail)
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


        // Inflate the layout for this fragment
        return binding.root
    }

}