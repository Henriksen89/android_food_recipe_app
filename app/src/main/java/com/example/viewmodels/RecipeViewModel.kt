package com.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food_recipe_app.R
import com.example.models.MealType
import com.example.models.Recipe
import com.example.repository.RecipeRepository
import com.example.views.BottomSheetFragment

class RecipeViewModel: ViewModel() {
    private val recipeRepository: RecipeRepository = RecipeRepository()
    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private var recipeList = ArrayList<Recipe>()

    private val bottomSheetFragment = BottomSheetFragment()




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