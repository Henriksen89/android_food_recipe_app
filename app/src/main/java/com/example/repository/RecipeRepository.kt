package com.example.repository

import com.example.food_recipe_app.R
import com.example.models.Recipe

class RecipeRepository {
    private val recipies: MutableList<Recipe> = ArrayList()
    private val recipeList = ArrayList<Recipe>()
    private var images: IntArray = intArrayOf(
        R.drawable.bulgogi_burgers,
        R.drawable.green_salat,
        R.drawable.vegansk_paprikagryderet)

    init {
        if (recipies.isEmpty()) {
            recipeList.add(Recipe(images[0],"RecipeTitle blaaah", "This is a nice dish mateee"))
            recipeList.add(Recipe(images[1],"RecipeTitle blaaah", "This is a nice dish mateee"))
            recipeList.add(Recipe(images[2],"RecipeTitle blaaah", "This is a nice dish mateee"))
        }

    }

    fun fetchRecipes(): ArrayList<Recipe>{
        return recipeList
    }
}