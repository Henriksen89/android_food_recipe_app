package com.example.models

import androidx.room.Embedded
import androidx.room.Relation

data class MealTypeWithRecipe (
    @Embedded val mealType: MealType,
    @Relation(
        parentColumn = "mealType",
        entityColumn = "mealType"
    )
    val recipes: List<Recipe>)