package com.example.models

import android.widget.ImageView
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(val image: Int, val recipeTitle: String, val recipeDescription: String)