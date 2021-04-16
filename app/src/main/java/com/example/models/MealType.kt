package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealType(
    @PrimaryKey(autoGenerate = false)
    val mealType: String)