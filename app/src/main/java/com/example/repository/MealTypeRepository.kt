package com.example.repository

import com.example.models.MealType

class MealTypeRepository {
    private val mealTypesList = ArrayList<MealType>()

    init {
        populateMealType()
    }

    fun fetchMealTypes(): ArrayList<MealType>{
        return mealTypesList
    }

    fun populateMealType(){
        mealTypesList.add(MealType("Main Course"))
        mealTypesList.add(MealType("Side Dishes"))
        mealTypesList.add(MealType("Dessert"))
    }
}