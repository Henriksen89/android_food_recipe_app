package com.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.DietType
import com.example.models.Recipe
import com.example.repository.DietTypeRepository

class DietTypeViewModel: ViewModel() {
    private val dietTypeRepository: DietTypeRepository = DietTypeRepository()
    private var dietTypes = MutableLiveData<ArrayList<DietType>>()
    private val dietTypesList = ArrayList<DietType>()

    init {
        populateDietType()
        dietTypes.value = dietTypesList
    }

    fun getDietType() : LiveData<ArrayList<DietType>> {
        return dietTypes
    }

    private fun populateDietType(){
        dietTypesList.add(DietType("Gluten Free"))
        dietTypesList.add(DietType("Vegetarian"))
        dietTypesList.add(DietType("Chicken"))
    }
}