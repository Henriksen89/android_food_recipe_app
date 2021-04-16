package com.example.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.views.showRecipe.RecipeIngredientsFragment
import com.example.views.showRecipe.RecipeInstructionsFragment
import com.example.views.showRecipe.RecipeOverviewFragment
import com.example.views.showRecipe.TabViewFragment

class TabAdapter(var context: TabViewFragment, fm: FragmentManager, var totalTabs: Int, bundle: Bundle) : FragmentPagerAdapter(fm) {
    private var bundle: Bundle = bundle
    override fun getCount(): Int {
        return totalTabs
    }

    /**
     * Creates the fragment based on the tab index
     */
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                RecipeOverviewFragment(bundle)
            }
            1 -> {
                RecipeIngredientsFragment(bundle)
            }
            2 -> {
                RecipeInstructionsFragment(bundle)
            }

            else -> getItem(position)
        }
    }

}