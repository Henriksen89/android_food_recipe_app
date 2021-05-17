package com.example.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.models.MealType
import com.example.models.MealTypeWithRecipe
import com.example.models.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealType(mealType: MealType)

    @Transaction
    @Query("SELECT * FROM recipe WHERE recipeTitle=:recipeTitle")
    suspend fun getRecipe(recipeTitle: String): List<Recipe>

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Transaction
    @Query("SELECT * FROM recipe WHERE mealType = :mealType")
    fun getRecipeMealType(mealType: String): List<Recipe>

    @Update
    fun update(mealType: MealType)
}