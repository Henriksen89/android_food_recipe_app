package com.example.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = false)
    val recipeTitle: String,
    val recipeDescription: String,
    val mealType: String,
    @TypeConverters
    val ingredients: List<String>,
    @TypeConverters
    val instructions: List<String>,
    @TypeConverters
    val image : Bitmap

)


