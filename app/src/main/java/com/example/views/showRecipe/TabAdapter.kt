package com.example.views.showRecipe

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return totalTabs
    }

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