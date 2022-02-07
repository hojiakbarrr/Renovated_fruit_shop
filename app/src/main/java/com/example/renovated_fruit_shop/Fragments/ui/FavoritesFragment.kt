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

    val list: ArrayList<FruitsData> = ArrayList()
    var gg = ListUsers.allUsers.userId

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        fruitList.clear()
        allfruits.clear()


//        val fruit = requireArguments().getSerializable(FRUIT_KEY) as FruitsData
//        fruitList.add(fruit)


        dataModel.message.observe(activity as LifecycleOwner, {
            nameMessage = it
        })

//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
// */*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*


//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.clear()
//        fruitList = allfruits
//
//        for (y in allfruits){
//            val fruit = FruitsData()
//            fruit.Favoritess_id = gg
//            fruit.description = y.description
//            fruit.image = y.image
//            fruit.likeImage = y.likeImage
//            fruit.nutrition_1 = y.nutrition_1
//            fruit.per_kg = y.per_kg
//            fruit.title = y.title
//            FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao().add_New_Fruits_Favorites(fruit)
//            Toast.makeText(requireContext(), "фрукт добавлен в базу данных", Toast.LENGTH_SHORT).show()
//        }

        for (r in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
            .getAllFruits()!!) {

//            for (o in fruitList){
            if (gg == r.Favoritess_id) {

                list.add(r)

                adapter?.notifyDataSetChanged()
                Toast.makeText(requireContext(), "фрукт может быть показан", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "идет загрузка....", Toast.LENGTH_SHORT).show()
            }
        }


        adapter = FavoritesAdapter(list, this)
        binding.recFavorites?.layoutManager = LinearLayoutManager(requireContext())

        binding.recFavorites?.setHasFixedSize(true)
        binding.recFavorites?.adapter = adapter
        adapter?.notifyDataSetChanged()


        return binding.root
    }

    override fun fonNextClick(position: Int) {

        val detail = list[position]

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Шаблон")
        builder.setMessage("Ты хочешь удалить из избранных")
        builder.setPositiveButton("да", { dialogInterface: DialogInterface, i: Int ->

            for (r in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                .getAllFruits()!!) {
                if (gg == r.Favoritess_id) {
                    list.remove(r)
                    FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                        .delete_Fruits_Favoritesr(detail)
                    Toast.makeText(requireContext(), "фрукт удален", Toast.LENGTH_SHORT).show()
                    list.clear()
                    for (r in FrutsDataBase.getDatabaseInstance(requireContext()).allFriutssDao()
                        .getAllFruits()!!) {
//            for (o in fruitList){
                        if (gg == r.Favoritess_id) {
                            list.add(r)

                            adapter?.notifyDataSetChanged()
                            Toast.makeText(requireContext(),
                                "фрукт может быть показан",
                                Toast.LENGTH_SHORT)
                                .show()
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
        TODO("Not yet implemented")
    }


}