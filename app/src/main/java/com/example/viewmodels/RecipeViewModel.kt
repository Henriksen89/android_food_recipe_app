package com.example.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.db.RecipeDatabase
import com.example.models.Ingredient
import com.example.models.Instruction
import com.example.models.MealType
import com.example.models.Recipe
import com.example.repository.RecipeRepository
import com.example.views.BottomSheetFragment
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {
    val dao = RecipeDatabase.getAppDatabase(application)!!.recipeDao
    private val repository: RecipeRepository = RecipeRepository(dao)
    var fragment: BottomSheetFragment? = BottomSheetFragment()
    var mealType: String = "Dessert"

    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
   // private var images: IntArray = intArrayOf(
   //         R.drawable.bulgogi_burgers,
   //         R.drawable.green_salat,
    //        R.drawable.vegansk_paprikagryderet)

    init {
        val ingredientsHotdog = Ingredient(listOf("Pølse", "Brød"))
        val instructionsHotdog = Instruction(listOf(
                "Steg pølsen",
                "Varm brødet",
                "Put ketchup, remoulade og pølse i brødet")
        )

        val ingredientsBurger = Ingredient(listOf(
                "Oksekød",
                "Løg",
                "Tomat",
                "Etc")
        )

        val instructionsBurger = Instruction(listOf(
                "Steg bøf",
                "Skær grøntsager",
                "Lav resten")
        )


        val recipes = listOf(
            Recipe("Hotdog", "NamNam", "MainCourse", ingredientsHotdog, instructionsHotdog),
            Recipe("Burger", "Salat", "MainCourse", ingredientsBurger, instructionsBurger),
            Recipe("IsLagkage", "Is", "Dessert", ingredientsBurger, instructionsBurger)
        )

        val mealTypes = listOf(
            MealType("MainCourse"),
            MealType("SideDish"),
            MealType("Dessert")
        )

        recipes.forEach { insert(it) }
        mealTypes.forEach { insertMealType(it) }

        if (recipeList.isEmpty()) {
            recipeList.addAll(dao.getRecipeMealType(mealType))
        }

        this.recipes.value = recipeList
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

    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return recipes
    }
    /*
    The updateMealType update the recipe list based on the selected meal type
     */
    fun updateMealType(mealType: String) {
        recipeList.clear()
        recipeList.addAll(dao.getRecipeMealType(mealType))
        this.mealType = mealType
    }

    fun getUpdatedMealType(): String{
        return this.mealType
    }
}