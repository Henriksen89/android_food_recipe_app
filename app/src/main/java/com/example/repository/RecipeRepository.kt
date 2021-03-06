package com.example.repository

import com.example.db.RecipeDao
import com.example.models.MealType
import com.example.models.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {

    suspend fun insert(recipe: Recipe){
        recipeDao.insert(recipe)
    }

    suspend fun insertMealType(mealType: MealType){
        recipeDao.insertMealType(mealType)
    }

    suspend fun getRecipe() = recipeDao.getRecipe("recipeTitle")

    //fun getRecipeWithMealType() = recipeDao.getRecipeMealType(mealTypeSelected())

    suspend fun deleteRecipe(recipe: Recipe) = recipeDao.deleteRecipe(recipe)

    fun mealTypeSelected(mealType: String): String{
        var type = mealType
        return type
    }

}
