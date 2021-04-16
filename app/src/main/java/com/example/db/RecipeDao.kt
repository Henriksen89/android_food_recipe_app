package com.example.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.models.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)

    // select all from table recipes defined on out model class
   // @Query("SELECT * FROM recipes")
    //fun getAllRecipes(): Recipe

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    //@Query("SELECT COUNT(*) from recipes")
    //fun countRecipes(): Int
}