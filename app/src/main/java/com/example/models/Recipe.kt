package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "recipes"
)
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val image: Int,
    val recipeTitle: String,
    val recipeDescription: String)
    //@JvmField
   // val mealType: MealType)
    //val dietType: DietType)