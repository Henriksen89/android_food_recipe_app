package com.example.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.db.RecipeDatabase
import com.example.food_recipe_app.R
import com.example.models.Recipe
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity()  {
    private lateinit var navController: NavController

    // some transient state for the activity instance
    var mealTypeState: String? = null

    // private val recipeViewModel: RViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recovering the instance state
        mealTypeState = savedInstanceState?.getString(MEALTYPE_STATE_KEY)

        navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.recipeFragment,
                R.id.fragmentFavorites))

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString(MEALTYPE_STATE_KEY, mealTypeState)
            //putString(TEXT_VIEW_KEY, textView.text.toString())
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)
    }
    companion object{
        val MEALTYPE_STATE_KEY = "mealType"
    }
}