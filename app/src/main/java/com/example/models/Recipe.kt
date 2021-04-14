package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "recipes"
)
data class Recipe(
    @JvmField
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @JvmField
    var image: Int,

    @JvmField
    var recipeTitle: String,

    @JvmField
    var recipeDescription: String)
    //@JvmField
   // val mealType: MealType)
    //val dietType: DietType)