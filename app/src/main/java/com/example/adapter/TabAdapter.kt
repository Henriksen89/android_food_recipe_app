package com.example.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.NavController
import com.example.views.showRecipe.RecipeIngredientsFragment
import com.example.views.showRecipe.RecipeInstructionsFragment
import com.example.views.showRecipe.RecipeOverviewFragment
import com.example.views.showRecipe.TabViewFragment

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