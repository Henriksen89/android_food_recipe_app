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
   // private val recipeViewModel: RViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // recipeViewModel.repository = (application as RecipeApplication).repository
        setContentView(R.layout.activity_main)

        val dao = RecipeDatabase.getAppDatabase(this)!!
        println("main oncreate")
        //addDataToDb()
        val recipes = listOf(
            Recipe("Hotdog", "NamNam"),
            Recipe("Burger", "Salat")
        )

        lifecycleScope.launch {
            recipes.forEach { dao.recipeDao.insert(it) }
        }
        println("addData")

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

    private fun addDataToDb() {
        val recipes = listOf(
            Recipe("Hotdog", "NamNam"),
            Recipe("Burger", "Salat")
        )

        lifecycleScope.launch {
            //recipes.forEach { dao.recipeDao.insert(it) }
        }
    }
}