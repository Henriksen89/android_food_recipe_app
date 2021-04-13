package com.example.repository

import androidx.lifecycle.MutableLiveData
import com.example.food_recipe_app.R
import com.example.models.MealType
import com.example.models.Recipe

class RecipeRepository {
    private val recipies: MutableList<Recipe> = ArrayList()
    private val recipeList = ArrayList<Recipe>()
    private var images: IntArray = intArrayOf(
        R.drawable.bulgogi_burgers,
        R.drawable.green_salat,
        R.drawable.vegansk_paprikagryderet)
    private val mealTypeMainCourse = MealType("Main Course")
    private val mealTypeSideDish = MealType("Side Dish")
    private val mealTypesList = ArrayList<MealType>()



    init {
        if (recipies.isEmpty()) {
            recipeList.add(Recipe(images[1],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
            recipeList.add(Recipe(images[0],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
            recipeList.add(Recipe(images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
            recipeList.add(Recipe(images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeSideDish))
            recipeList.add(Recipe(images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeSideDish))
        }

    }

    fun fetchRecipes(): ArrayList<Recipe>{
        return recipeList
    }



}