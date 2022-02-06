package com.example.renovated_fruit_shop.Static_class

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.renovated_fruit_shop.DataClass.FruitsData

open class DataModel : ViewModel(){

    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val fruit: MutableLiveData<FruitsData> by lazy {
        MutableLiveData<FruitsData>()
    }

}