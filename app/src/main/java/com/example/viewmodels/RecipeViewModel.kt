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
    private val recipeList = ArrayList<Recipe>()
    private var images: IntArray = intArrayOf(
            R.drawable.bulgogi_burgers,
            R.drawable.green_salat,
            R.drawable.vegansk_paprikagryderet)


    init {
        populateRecipes()
        recipes.value = recipeList
    }

    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return recipes
    }

    private fun populateRecipes(){
        recipeList.add(Recipe(images[0],"RecipeTitle blaaah"))
        recipeList.add(Recipe(images[1],"RecipeTitle blaaah"))
        recipeList.add(Recipe(images[2],"RecipeTitle blaaah"))
    }



}