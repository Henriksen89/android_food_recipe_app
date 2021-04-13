package com.example

import android.app.Application
import com.example.db.RecipeDatabase
import com.example.repository.RecipeRepository

class RecipeApplication: Application() {
    val database by lazy {RecipeDatabase.getAppDatabase(this)}
    val repository by lazy {RecipeRepository(database!!.recipeDao())}
}