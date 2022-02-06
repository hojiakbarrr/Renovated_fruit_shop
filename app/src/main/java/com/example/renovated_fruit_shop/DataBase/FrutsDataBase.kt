package com.example.renovated_fruit_shop.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.DataClass.Users


@Database(entities = [FruitsData :: class], version = 1, exportSchema = false)
abstract class FrutsDataBase : RoomDatabase(){

    abstract fun allFriutssDao(): FruitsDao


    companion object {
        @Volatile
        var INSTANCE: FrutsDataBase? = null

        fun getDatabaseInstance(context: Context): FrutsDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val roomDataBaseinstance = Room.databaseBuilder(context,
                    FrutsDataBase::class.java, "FriutSs"
                ).allowMainThreadQueries().build()
                INSTANCE = roomDataBaseinstance
                return return roomDataBaseinstance
            }

        }

    }


}