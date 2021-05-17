package com.example.db

import androidx.room.*
import com.example.models.Ingredient
import com.example.models.Instruction
import com.example.models.MealType
import com.example.models.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealType(mealType: MealType)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient(ingredient: Ingredient)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInstruction(instruction: Instruction)

    @Transaction
    @Query("SELECT * FROM recipe WHERE recipeTitle=:recipeTitle")
    suspend fun getRecipe(recipeTitle: String): List<Recipe>

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Transaction
    @Query("SELECT * FROM recipe WHERE mealType = :mealType")
    fun getRecipeMealType(mealType: String): List<Recipe>

}