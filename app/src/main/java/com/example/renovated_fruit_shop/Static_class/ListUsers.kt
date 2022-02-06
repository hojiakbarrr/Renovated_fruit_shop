package com.example.renovated_fruit_shop.Static_class

import com.example.renovated_fruit_shop.DataClass.FruitsData
import com.example.renovated_fruit_shop.DataClass.Users

class ListUsers {

    companion object {
        var allUsers = Users()
        var allFri : ArrayList<FruitsData> = ArrayList()
    }

}