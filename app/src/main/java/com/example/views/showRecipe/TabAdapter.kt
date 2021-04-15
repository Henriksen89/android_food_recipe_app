package com.example.views.showRecipe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.NavController
import com.example.food_recipe_app.R
import com.example.models.Recipe

class TabAdapter(var context: TabViewFragment, fm: FragmentManager, var totalTabs: Int, navController: NavController) : FragmentPagerAdapter(fm) {
    private val navController = navController

    override fun getCount(): Int {
        return totalTabs
    }

    /**
     * Creates the fragment based on the tab index
     */
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                RecipeOverviewFragment()
            }
            1 -> {
                RecipeIngredientsFragment()
            }
            2 -> {
                RecipeInstructionsFragment()
            }

            else -> getItem(position)
        }
    }

}