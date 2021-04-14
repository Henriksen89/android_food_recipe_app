package com.example.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.food_recipe_app.R
import com.example.models.Recipe
import com.example.repository.RecipeRepository

class ViewModel: ViewModel() {
    private lateinit var recipe: Recipe
    lateinit var repository: RecipeRepository
    var currentRecipe: Recipe? = null
    var id = ObservableField<Int>()
    var image = ObservableField<Int>()
    var title = ObservableField<String>()
    var recipeDescription = ObservableField<String>()

    private var images: IntArray = intArrayOf(
        R.drawable.bulgogi_burgers,
        R.drawable.green_salat,
        R.drawable.vegansk_paprikagryderet)

    fun init() {
        println("init")
        createNewRecipe()
    }

    private fun insert(recipe: Recipe) {
        repository.insert(recipe)
    }

    private fun count(): Int {
        return repository.count()
    }

    private fun createNewRecipe(): Recipe {
        println("here")
        recipe.id
        recipe.image = images[1]
        recipe.recipeTitle = "Flot"
        recipe.recipeDescription = "flot flot opskrift"
        println(recipe)
        return recipe
    }
}