package com.example.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food_recipe_app.R


class MainActivity : AppCompatActivity()  {
   // private val recipeViewModel: RViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // recipeViewModel.repository = (application as RecipeApplication).repository
        setContentView(R.layout.activity_main)
    }
}