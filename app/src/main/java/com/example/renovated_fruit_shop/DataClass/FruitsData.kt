package com.example.renovated_fruit_shop.DataClass

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


@Entity(tableName = "fruits_database")
class FruitsData(



    var title: String = "",

    var likeImage: Int = 0,

    var image: Int = 0,

    var per_kg: String = "",

    var nutrition_1: String = "",

    var description: String = "",

    var currentDate: String = "",

    var isClicked: Boolean = false,

    var Orders_id: String = "",

    var Favoritess_id: String = "",

    @PrimaryKey

    var fruitsId: String = UUID.randomUUID().toString(),


    ) : Serializable