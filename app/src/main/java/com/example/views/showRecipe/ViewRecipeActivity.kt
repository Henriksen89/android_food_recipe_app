package com.example.views.showRecipe

import android.content.Intent
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.food_recipe_app.R
import com.example.models.Recipe
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

class ViewRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)


        //println("bundle print in viewrecipe " + bundle)
        //val json : JsonObject = bundle.getString()
        println("haaalooo this is the intent extras in ViewRecipeActivity" + intent.extras)
        //val recipe1 : Recipe = intent.extras()

        val jsonRecipe = intent.getStringExtra("Recipe")
        println("jsonRecipe in ViewRecipeActivity" +jsonRecipe)
        val selectedRecipe = Gson().fromJson<Recipe>(jsonRecipe, Recipe::class.java)

        println("selectedRecipe in ViewRecipeActivity " + selectedRecipe)

        //val bundle : Bundle = intent.extras!!
        //val recipe : Recipe = bundle.getSerializable("Gson().fromJson()") as Recipe
        //println("recipe in ViewRecipeActivity" + recipe)


        // val recipe : Recipe = Json.decodeFromJsonElement(intent.getSerializableExtra("Recipe"))
        // val recipe : Recipe = Json.decodeFromJsonElement(intent.)

        tabs.addTab(tabs.newTab().setText("Overview"))
        tabs.addTab(tabs.newTab().setText("Ingredients"))
        tabs.addTab(tabs.newTab().setText("Instructions"))

        tabs.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = TabAdapter(this, selectedRecipe, supportFragmentManager,
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

    }
}