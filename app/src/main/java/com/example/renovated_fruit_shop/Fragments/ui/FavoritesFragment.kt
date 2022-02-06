package com.example.renovated_fruit_shop.Fragments.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.renovated_fruit_shop.AdapterS.FavoritesAdapter
import com.example.renovated_fruit_shop.DataBase.FrutsDataBase
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.DataClass.Users
import com.example.renovated_fruit_shop.Fragments.ui.home.HomeFragment.Companion.FRUIT_KEY
import com.example.renovated_fruit_shop.Static_class.DataModel
import com.example.renovated_fruit_shop.Static_class.ListUsers
import com.example.renovated_fruit_shop.databinding.FragmentFavoritesBinding
import java.util.*
import kotlin.collections.ArrayList

class FavoritesFragment : Fragment(), FavoritesAdapter.NextClickListener {
//    private val oldNotes by navArgs<FavoritesFragmentArgs>()

    lateinit var binding: FragmentFavoritesBinding
    private var adapter: FavoritesAdapter? = null
    var fruitList: ArrayList<FruitsData> = ArrayList()

    var curreeentDate = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(Date())!!
    private var nameMessage: String = ""


    companion object {
        var allfruits: ArrayList<FruitsData> = ArrayList()
    }

    private val dataModel: DataModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        fruitList.clear()


//        val fruit = requireArguments().getSerializable(FRUIT_KEY) as FruitsData

//        fruitList.add(fruit)

        var dd = ListUsers.allFri
        for (o in dd) {
            fruitList.add(o)
            adapter?.notifyDataSetChanged()
        }

        dataModel.message.observe(activity as LifecycleOwner, {
            nameMessage = it
        })

        dataModel.fruit.observe(activity as LifecycleOwner, {
            fruitList.add(it)
            adapter?.notifyDataSetChanged()
        })
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
// */*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*

//
//        fruitList.add(oldNotes as FruitsData)
//        adapter?.notifyDataSetChanged()

//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.clear()
        fruitList = allfruits
        var gg = ListUsers.allUsers.userId
        var id = FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao().getFruit(gg)

        for (o in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
            .getAllFruits()!!) {
//            for (r in ListUsers.allUsers) {
                if (gg == o.id) {
                    fruitList.add(o)
                    adapter?.notifyDataSetChanged()
                    Toast.makeText(requireContext(), "фрукт может быть показан", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(), "что то пошло не так", Toast.LENGTH_SHORT).show()
                }

//            }

        }


        adapter = FavoritesAdapter(fruitList, this)
        binding.recFavorites?.layoutManager = LinearLayoutManager(requireContext())

        binding.recFavorites?.setHasFixedSize(true)
        binding.recFavorites?.adapter = adapter
        adapter?.notifyDataSetChanged()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun fonNextClick(position: Int) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Шаблон")
        builder.setMessage("Ты хочешь удалить из избранных")
        builder.setPositiveButton("да", { dialogInterface: DialogInterface, i: Int ->
            fruitList.removeAt(position)
            for (o in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                .getAllFruits()!!) {
//            for (r in ListUsers.allUsers) {
                if (ListUsers.allUsers.userId == o.id) {
//                    fruitList.add(o)
                    FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao().delete_Fruits_Favoritesr(o)
                    Toast.makeText(requireContext(), "фрукт удален", Toast.LENGTH_SHORT).show()
                    adapter?.notifyDataSetChanged()
                }
            }

        })
        builder.setNegativeButton("нет", { DialogInterface, i: Int -> })
        builder.show()
    }


}