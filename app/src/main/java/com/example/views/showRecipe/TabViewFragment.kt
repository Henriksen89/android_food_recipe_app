package com.example.views.showRecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentTabViewBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_tab_view.*


class TabViewFragment : Fragment() {
    private var _binding: FragmentTabViewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabViewBinding.inflate(inflater, container, false)
        val viewPager: ViewPager = binding.viewPager
        val tabLayout: TabLayout = binding.tabs
        val mViewPager = binding.viewPager

        createTabs(tabLayout)

        setViewPagerListener(mViewPager, tabLayout, viewPager)

        tabListener(tabLayout, viewPager)

        return binding.root
    }

    private fun setViewPagerListener(mViewPager: ViewPager, tabLayout: TabLayout, viewPager: ViewPager) {
        mViewPager.adapter = TabAdapter(this, childFragmentManager, tabLayout.tabCount, findNavController())

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    private fun tabListener(tabLayout: TabLayout, viewPager: ViewPager) {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun createTabs(tabLayout: TabLayout){
        val tabOverview: TabLayout.Tab = tabLayout.newTab().setText("Overview")
        tabLayout.addTab(tabOverview)
        val tabIngredients: TabLayout.Tab = tabLayout.newTab().setText("Ingredients")
        tabLayout.addTab(tabIngredients)
        val tabInstructions: TabLayout.Tab = tabLayout.newTab().setText("Instructions")
        tabLayout.addTab(tabInstructions)
    }
}