package com.example.repository

import com.example.models.Recipe

class RecipeRepository {
    private val recipies: MutableList<Recipe> = ArrayList()

    init {
        if (recipies.isEmpty()) {
            recipies.add(Recipe("Suppe"))
            recipies.add(Recipe("Bræk"))
        }
    }

    fun fetchRecipe(): Recipe {
        return recipies.random()
    }
}