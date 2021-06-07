package com.example.views

import android.database.CursorWindow
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.food_recipe_app.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Field


class MainActivity : AppCompatActivity()  {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // CursorWindow is a read or write operation for database call
        // Increasing size of the cursor window to extend memory due to the large images in db
        try {
            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
            field.setAccessible(true)
            field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
        } catch (e: Exception) {
            e.printStackTrace()
        }

        setContentView(R.layout.activity_main)
        // Get navigation graph by call the id of the navHostFragment in the mainActivity.xml
        // navController is an object that handles the app navigation through nav host
        navController = findNavController(R.id.navHostFragment)
        // Bottom appBar activity view
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.recipeFragment,
                R.id.fragmentFavorites
            )
        )
        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}