package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = false)
    val recipeTitle: String,
    val recipeDescription: String,
    val mealType: String,
    val ingredients: Ingredient,
    val instructions: Instruction
)