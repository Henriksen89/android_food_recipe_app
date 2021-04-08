package com.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food_recipe_app.R
import com.example.models.Recipe
import com.example.repository.RecipeRepository

class RecipeViewModel: ViewModel() {
    private val recipeRepository: RecipeRepository = RecipeRepository()
    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private var recipeList = ArrayList<Recipe>()
    


    init {
        populateRecipes()
        recipes.value = recipeList
    }

    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return recipes
    }

    private fun populateRecipes(){
        recipeList = recipeRepository.fetchRecipes()
    }



}