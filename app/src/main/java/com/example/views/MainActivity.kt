package com.example.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipe_app.R
import com.example.viewmodels.RecipeViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), RecipeAdapter.ViewHolderListener  {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private val recipeViewModel: RecipeViewModel by viewModels()
    private lateinit var cardview: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetFragment = BottomSheetFragment()

        btnFilterRecipe.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")
        }


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
        adapter.setRecipes(recipeViewModel.getRecipes().value!!)
        recyclerView.adapter = adapter

        recipeViewModel.getRecipes().observe(this, { recipes ->
            adapter.setRecipes(recipes)
        })


    }



    override fun addRecipeOnClick(position: Int, number: Int) {
        TODO("Not yet implemented")
    }

    override fun viewRecipe(position: Int) {
        val intent = Intent(this, RecipeActivity::class.java)
        startActivity(intent)
    }
}