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
    val dao = RecipeDatabase.getAppDatabase(application)!!.recipeDao
    private val repository: RecipeRepository = RecipeRepository(dao)
    private var reci = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
   // private var images: IntArray = intArrayOf(
   //         R.drawable.bulgogi_burgers,
   //         R.drawable.green_salat,
    //        R.drawable.vegansk_paprikagryderet)

    init {

        val recipes = listOf(
            Recipe("Hotdog", "NamNam", "MainCourse"),
            Recipe("Burger", "Salat", "MainCourse"),
            Recipe("IsLagkage", "Is", "Dessert")
        )

        val mealTypes = listOf(
            MealType("MainCourse"),
            MealType("SideDish"),
            MealType("Dessert")
        )

        recipes.forEach { insert(it) }
        mealTypes.forEach { insertMealType(it) }

        recipeList.addAll(dao.getRecipeMealType("MainCourse"))
        reci.value = recipeList
        }

    fun insert(recipe: Recipe){
        viewModelScope.launch {
            repository.insert(recipe)
        }
    }

    fun insertMealType(mealType: MealType){
        viewModelScope.launch {
            repository.insertMealType(mealType)
        }
    }

    fun getMealTypeWithRecipes(){
        viewModelScope.launch {
            repository.getRecipeWithMealType()
        }
    }

    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return reci
    }
}