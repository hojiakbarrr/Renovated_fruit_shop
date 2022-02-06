package com.example.renovated_fruit_shop.AdapterS

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.Fragments.ui.FavoritesFragmentDirections
import com.example.renovated_fruit_shop.R
import java.util.*

class FavoritesAdapter(val list: MutableList<FruitsData>, val clickListener: NextClickListener) :
    RecyclerView.Adapter<FavoritesAdapter.Favorites_Holder>() {

    var rr = R.drawable.next

    inner class Favorites_Holder(item: View) : RecyclerView.ViewHolder(item) {
        var fruitImage_shablon: ImageView = itemView.findViewById(R.id.shablon_fav_foto)
        var title_shablon: TextView = itemView.findViewById(R.id.shablon_fav_title)
        var time: TextView = itemView.findViewById(R.id.shablon_fav_date)
        var next: ImageView = itemView.findViewById(R.id.shablon_fav_next)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): FavoritesAdapter.Favorites_Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shablon_favorites, parent, false)
        return Favorites_Holder(view)    }

    override fun onBindViewHolder(holder: FavoritesAdapter.Favorites_Holder, position: Int) {
        var curreeentDate = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(Date())

        holder.itemView.apply {
            holder.fruitImage_shablon.setImageResource(list[position].image)
            holder.title_shablon.text = list[position].title
            holder.time.text = curreeentDate
            holder.next.setImageResource(rr)



            holder.next.setOnClickListener {

                val data = list[position]

//                val action =  FavoritesFragmentDirections.actionNavFavouritesToDetailFragment(data)
//                Navigation.findNavController(it).navigate(action)
            }

            holder.itemView.setOnClickListener {
                clickListener.fonNextClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface NextClickListener {
        fun fonNextClick(position: Int)
    }

}


