package com.example.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipe_app.R
import com.example.viewmodels.RecipeViewModel


class MainActivity : AppCompatActivity(), RecipeAdapter.ViewHolderListener  {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private val recipeViewModel: RecipeViewModel by viewmodels()
    //private val jokeViewModel: RecipeViewModel by viewModels()
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Bind s Recycler view with id, and sets variables
         */
        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.setHasFixedSize(true)

        /**
         * Layout Managers available, can be commented out if you wanna try some other
         */
        recyclerView.layoutManager = LinearLayoutManager(this)

        /**
         * Creates new CustomAdapter, with the dataset of numbers
         * and makes it the adapter for the recyclerview
         */
        adapter = RecipeAdapter(this)


        val recipeViewModel = RecipeViewModel()



    }

    override fun addRecipeOnClick(position: Int, number: Int) {
        TODO("Not yet implemented")
    }
}