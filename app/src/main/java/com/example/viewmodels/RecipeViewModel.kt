package com.example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.food_recipe_app.R
import com.example.models.MealType
import com.example.models.Recipe
import com.example.repository.RecipeRepository
import com.example.views.BottomSheetFragment

class RecipeViewModel: ViewModel() {
   // private val recipeRepository: RecipeRepository = RecipeRepository()
    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
    private var images: IntArray = intArrayOf(
            R.drawable.bulgogi_burgers,
            R.drawable.green_salat,
            R.drawable.vegansk_paprikagryderet)
    private val bottomSheetFragment = BottomSheetFragment()
    private val mealTypeMainCourse = MealType(true, false, false)
    private val mealTypeSideDish = MealType(false, true, false)



    init {
        populateRecipes()
        recipes.value = recipeList
    }

    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return recipes
    }

    private fun populateRecipes(){
       // recipeList.add(Recipe(1, images[0],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
       // recipeList.add(Recipe(2, images[0],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
       // recipeList.add(Recipe(3, images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeMainCourse))
       // recipeList.add(Recipe(4, images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeSideDish))
       // recipeList.add(Recipe(5, images[2],"RecipeTitle blaaah", "This is a nice dish mateee", mealTypeSideDish))
    }
    }