package com.example.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.food_recipe_app.R
import com.example.viewmodels.RecipeViewModel


class MainActivity : AppCompatActivity() {

    //private val jokeViewModel: RecipeViewModel by viewModels()
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipeViewModel = RecipeViewModel()

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            recipeViewModel.randomRecipe()
        }

        recipeViewModel.recipe.observe(this, { recipe ->
            textView.text = recipe.text
        })
    }
}