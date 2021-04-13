package com.example.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.models.Recipe

@Dao
interface RecipeDao {
    @Insert
    fun insert(recipe: Recipe)

    // select all from table recipes defined on out model class
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)
}