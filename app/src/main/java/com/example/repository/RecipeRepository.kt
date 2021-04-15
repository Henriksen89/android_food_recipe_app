package com.example.repository

import com.example.db.RecipeDao
import com.example.db.RecipeDatabase
import com.example.models.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {

    suspend fun insert(recipe: Recipe){
        recipeDao.insert(recipe)
    }


   // fun getSavedRecipes() = recipeDao.getAllRecipes()

    suspend fun deleteRecipe(recipe: Recipe) = recipeDao.deleteRecipe(recipe)

   // fun count(): Int {
    //    return recipeDao.countRecipes()
   // }

}