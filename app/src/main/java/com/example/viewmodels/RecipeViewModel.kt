package com.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.Recipe
import com.example.repository.RecipeRepository

class RecipeViewModel: ViewModel() {
    private val recipeRepository: RecipeRepository = RecipeRepository()
    private val _recipe = MutableLiveData<Recipe>()

    val recipe: LiveData<Recipe>
        get() = _recipe

    fun randomRecipe(){
        _recipe.value = recipeRepository.fetchRecipe()
    }
}