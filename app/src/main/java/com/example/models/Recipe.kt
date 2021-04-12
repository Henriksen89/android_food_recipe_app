package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(val image: Int,
                  val recipeTitle: String,
                  val recipeDescription: String,
                  )
//val ingredients : ArrayList<String>,
//val instructions : ArrayList<String>