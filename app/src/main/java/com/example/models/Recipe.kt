package com.example.models

import android.widget.ImageView

data class Recipe(val image: Int,
                  val recipeTitle: String,
                  val recipeDescription: String,
                  val mealType: MealType,)
                 // val dietType: DietType)