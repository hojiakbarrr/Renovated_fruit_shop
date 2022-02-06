package com.example.renovated_fruit_shop.DataClass

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import java.io.Serializable
import java.util.*


@Entity(tableName = "user_database")
data class Users(
    @PrimaryKey

    var login: String = "",

    var password: String = "",

    var mail: String = "",

    var name: String = "",

    var favoritesLis: String = "",

    var ordersList: String = "",

    var photo: Int? = 0,

    var likeImage: Int = 0,

    var image: Int = 0,

    var title: String = "",

    var per_kg: String = "",

    var nutrition_1: String = "",

    var description: String = "",

    var currentDate: String = "",

    var userId: String = UUID.randomUUID().toString(),

    ) : Serializable, Converter()

    open class Converter {

    @TypeConverter
    fun listToJson(value: List<FruitsData>?) = Gson().toJson(value)

    @TypeConverter
    fun JsonToList(value: String) = Gson().fromJson(value, Array<FruitsData>::class.java).toList()

}