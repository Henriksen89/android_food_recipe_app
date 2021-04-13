package com.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.MealType

class MealTypeViewModel: ViewModel() {
   // private val mealTypeRepository: MealTypeRepository = MealTypeRepository()
    private var mealTypes = MutableLiveData<ArrayList<MealType>>()
    private val mealTypesList = ArrayList<MealType>()

    init {
      //  populateMealType()
        mealTypes.value = mealTypesList
    }

    fun getMealType() : LiveData<ArrayList<MealType>> {
        return mealTypes
    }

    //fun populateMealType(){
     //   mealTypesList.add(MealType("Main Course"))
     //   mealTypesList.add(MealType("Side Dishes"))
      //  mealTypesList.add(MealType("Dessert"))
    //}
}

