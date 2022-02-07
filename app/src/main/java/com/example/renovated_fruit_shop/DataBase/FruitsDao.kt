package com.example.renovated_fruit_shop.DataBase

import androidx.room.*
import com.example.renovated_fruit_shop.DataClass.FruitsData


@Dao
interface FruitsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add_New_Fruits_Favorites(fruits: FruitsData)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update_Fruits_Favorites(fruits: FruitsData)

    @Delete
    fun delete_Fruits_Favoritesr(fruits: FruitsData)

    ////*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*//*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*/
/////*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*//*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add_New_Fruits_Orders(fruits: FruitsData)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update_Fruits_Orders(fruits: FruitsData)

    @Delete
    fun delete_Fruits_Orders(fruits: FruitsData)

    ////*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*//*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*/
/////*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*//*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*/

    @Query("select * from fruits_database")
    fun getAllFruits(): MutableList<FruitsData>?


    @Query("select * from fruits_database where  Favoritess_id ==:ceId")
    fun getFruitFavorites(ceId: String): FruitsData


    @Query("select * from fruits_database where  Orders_id ==:ceId")
    fun getFruitOrders(ceId: String): FruitsData
////*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*//*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*/
/////*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*//*-/*-/*-/*-/*-/*-/*-/*-/*-/*-/*/-/*-/*-/*-/*-/*-/*-/*-/*-*/*-*//*/*/





}