package com.example.renovated_fruit_shop.AdapterS

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.Fragments.ui.FavoritesFragment
import com.example.renovated_fruit_shop.Fragments.ui.home.HomeFragment
import com.example.renovated_fruit_shop.Fragments.ui.home.HomeFragmentDirections
import com.example.renovated_fruit_shop.R

class MainAdapter (val list: MutableList<FruitsData>, val clickListener: IconClickListener) :
    RecyclerView.Adapter<MainAdapter.FruitsHolder>(){
    var rr : Boolean = false

    inner class FruitsHolder(item: View) : RecyclerView.ViewHolder(item) {
        var fruitImage_shablon: ImageView = itemView.findViewById(R.id.photo)
        var title_shablon: TextView = itemView.findViewById(R.id.title_shablon)
        var kgr: TextView = itemView.findViewById(R.id.kg)
        var like: ImageView = itemView.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shablon, parent, false)
        return FruitsHolder(view)    }

    override fun onBindViewHolder(holder: FruitsHolder, position: Int) {

        holder.itemView.apply {
            holder.fruitImage_shablon.setImageResource(list[position].image)
            holder.title_shablon.text = list[position].title
            holder.kgr.text = list[position].per_kg + " Per/kg"
            holder.like.setImageResource(list[position].likeImage)

        }

        holder.itemView.setOnClickListener {
            clickListener.fonItemClick(position)
        }

        holder.like.setOnClickListener {
            val data = list[position]
            if(!rr){
                holder.like.setImageResource(R.drawable.favorite)
                clickListener.fonLikeClick(position,data)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface IconClickListener {
        fun fonItemClick(position: Int)
        fun fonLikeClick(position: Int, data: FruitsData)
    }
}


