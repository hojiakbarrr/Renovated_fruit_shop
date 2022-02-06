package com.example.renovated_fruit_shop.DataBase

import androidx.room.*
import com.example.renovated_fruit_shop.DataClass.Users


@Dao
interface UserssDao {

    ////////////////////////////////////////////////////////// ////////
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add_New_User(user: Users)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun update_User(user: Users)

    @Delete
    fun delete_User(user: Users)

    @Query("select * from user_database")
    fun getAllUser(): MutableList<Users>?

    @Query("select * from user_database where  userId ==:ceId")
    fun getUser(ceId: Int): Users
}