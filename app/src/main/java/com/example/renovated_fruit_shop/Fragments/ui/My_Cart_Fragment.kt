package com.example.renovated_fruit_shop.Fragments.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.renovated_fruit_shop.AdapterS.FavoritesAdapter
import com.example.renovated_fruit_shop.DataBase.FrutsDataBase
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.R
import com.example.renovated_fruit_shop.Static_class.ListUsers
import com.example.renovated_fruit_shop.databinding.FragmentDetailBinding
import com.example.renovated_fruit_shop.databinding.FragmentFavoritesBinding
import com.example.renovated_fruit_shop.databinding.FragmentMyCartBinding


class My_Cart_Fragment : Fragment(), FavoritesAdapter.NextClickListener {
    lateinit var binding: FragmentMyCartBinding
    private var adapter: FavoritesAdapter? = null

    val list: ArrayList<FruitsData> = ArrayList()
    var gg = ListUsers.allUsers.userId

    var user: String = ""
    var nazvaniye: String = ""
    var descr: String = ""
    var nutr: String = ""
    var per_: String = ""
    var imag: Int = 0
    var idFrui: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyCartBinding.inflate(layoutInflater, container, false)


        for (r in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
            .getAllFruits()!!) {

            if (gg == r.Orders_id) {

                list.add(r)
                adapter?.notifyDataSetChanged()
                Toast.makeText(requireContext(),
                    "фрукт может быть показан в список заказов",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "идет загрузка....", Toast.LENGTH_SHORT).show()
            }
        }



        adapter = FavoritesAdapter(list, this)
        binding.recOrder?.layoutManager = LinearLayoutManager(requireContext())

        binding.recOrder?.setHasFixedSize(true)
        binding.recOrder?.adapter = adapter
        adapter?.notifyDataSetChanged()



        binding.ordersBuy.setOnClickListener {
            for (o in list) {
//                o.title
//                o.description
//                o.nutrition_1
//                o.per_kg
//                o.image
//                o.fruitsId


                user = gg
                nazvaniye = o.title
                descr = o.description
                nutr = o.nutrition_1
                per_ = o.per_kg
                imag = o.image
                idFrui = o.fruitsId
            }


            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf("youremail@yahoo.com"))
            email.putExtra(Intent.EXTRA_SUBJECT, "new order")
            email.putExtra(Intent.EXTRA_TEXT,
                "Имя клиента: " + user + "\n" +
                    "Название товара: " + nazvaniye + "\n" +
                    "Цена товара в рублях : " + per_ + "\n" +
                    "id товара : " + idFrui)
            email.type = "message/rfc822"
            startActivity(Intent.createChooser(email, "Choose an Email client :"))
        }

        return binding.root
    }

    override fun fonNextClick(position: Int) {
        val detail = list[position]

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Шаблон")
        builder.setMessage("Ты хочешь удалить из списка заказов")
        builder.setPositiveButton("да", { dialogInterface: DialogInterface, i: Int ->

            for (r in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                .getAllFruits()!!) {
                if (gg == r.Orders_id) {
                    list.remove(r)
                    FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                        .delete_Fruits_Orders(detail)
                    Toast.makeText(requireContext(),
                        "фрукт удален из списка заказов",
                        Toast.LENGTH_SHORT).show()
                    list.clear()
                    for (r in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                        .getAllFruits()!!) {
                        if (gg == r.Orders_id) {
                            list.add(r)
                            adapter?.notifyDataSetChanged()
                        }
                    }

                    adapter?.notifyDataSetChanged()
                } else {
                    Toast.makeText(requireContext(), "фрукт пока не удален", Toast.LENGTH_SHORT)
                        .show()
                }
                adapter?.notifyDataSetChanged()

            }

        })
        builder.setNegativeButton("нет",
            { DialogInterface, i: Int -> })
        builder.show()
    }


    override fun fonDetailClick(position: Int) {
        Detail_Fragment.Detailsfruits.add(list[position])

        val yoursFragment: Fragment = Detail_Fragment()
        val trans = requireFragmentManager().beginTransaction()
        trans.replace(R.id.nav_host_fragment_content_main, yoursFragment).setReorderingAllowed(true)
            .addToBackStack(R.layout.fragment_my__cart_.toString())
        trans.commit()

    }

}