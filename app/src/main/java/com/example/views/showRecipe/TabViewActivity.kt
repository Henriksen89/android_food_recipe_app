package com.example.views.showRecipe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.food_recipe_app.R
import com.example.models.Recipe
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tab_view.*

class TabViewActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // recipeViewModel.repository = (application as RecipeApplication).repository
        setContentView(R.layout.activity_tab_view)

        navController = findNavController(R.id.navHostFragment_showRecipe)



    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}