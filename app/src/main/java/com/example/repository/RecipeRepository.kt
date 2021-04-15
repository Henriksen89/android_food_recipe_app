package com.example.repository

import androidx.room.Query
import androidx.room.Transaction
import com.example.db.RecipeDao
import com.example.db.RecipeDatabase
import com.example.models.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {
    suspend fun insert(recipe: Recipe){
        recipeDao.insert(recipe)
    }

    fun getRecipe() = recipeDao.getRecipe("recipeTitle")

    suspend fun deleteRecipe(recipe: Recipe) = recipeDao.deleteRecipe(recipe)

}