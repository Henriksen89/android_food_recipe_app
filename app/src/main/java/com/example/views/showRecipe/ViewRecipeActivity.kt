package com.example.views.showRecipe

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.food_recipe_app.R

class ViewRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)

        tabs.addTab(tabs.newTab().setText("Overview"))
        tabs.addTab(tabs.newTab().setText("Ingredients"))
        tabs.addTab(tabs.newTab().setText("Instructions"))

        tabs.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = TabAdapter(this, supportFragmentManager,
            tabs.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


        //tabs.setupWithViewPager(viewPager)

    }
}