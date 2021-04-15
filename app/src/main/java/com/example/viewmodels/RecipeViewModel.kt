package com.example.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.db.RecipeDatabase
import com.example.food_recipe_app.R
import com.example.models.MealType
import com.example.models.Recipe
import com.example.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {
    private val repository: RecipeRepository
    private var reci = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
    private var images: IntArray = intArrayOf(
            R.drawable.bulgogi_burgers,
            R.drawable.green_salat,
            R.drawable.vegansk_paprikagryderet)
    private val mealTypeMainCourse = MealType(true, false, false)
    private val mealTypeSideDish = MealType(false, true, false)

    init {
        val dao = RecipeDatabase.getAppDatabase(application)!!.recipeDao
        repository = RecipeRepository(dao)

        val recipes = listOf(
            Recipe("Hotdog", "NamNam"),
            Recipe("Burger", "Salat")
        )

        recipes.forEach { insert(it) }

        val recipe = getReciTest()
        println("reciTest" + recipe)

        populateRecipes()
        reci.value = recipeList

        println(dao.getRecipe("Hotdog"))
        }

    fun insert(recipe: Recipe){
        viewModelScope.launch {
            repository.insert(recipe)
        }
    }
    fun getReciTest(){
        viewModelScope.launch {
            repository.getRecipe().toString()
        }
    }

    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return reci
    }


    private fun populateRecipes(){
       recipeList.add(Recipe("RecipeTitle blaaah", "This is a nice dish mateee"))
       // recipeList.add(Recipe(2, images[0],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
       // recipeList.add(Recipe(3, images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
       // recipeList.add(Recipe(4, images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeSideDish))
       // recipeList.add(Recipe(5, images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeSideDish))
    }
    }