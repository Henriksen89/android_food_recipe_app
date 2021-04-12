package com.example.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.models.Recipe

@Dao
interface RecipeDao {
    // onClick define that we one to replace recipe if its exist
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(recipe: Recipe): Long

    // select all from table recipes defined on out model class
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)
}