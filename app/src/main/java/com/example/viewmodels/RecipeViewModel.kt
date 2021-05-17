package com.example.viewmodels

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.*
import com.example.db.RecipeDatabase
import com.example.food_recipe_app.R
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
    private val images = ArrayList<Bitmap>()


    private suspend fun getBitmap(url : String): Bitmap {
        val options = BitmapFactory.Options()
        options.inScaled = true
        images.add(BitmapFactory.decodeResource(resources, R.drawable.bulgogi_burgers))
        images.add(BitmapFactory.decodeResource(resources, R.drawable.green_salat))
        images.add(BitmapFactory.decodeResource(resources, R.drawable.vegansk_paprikagryderet))

    }

    init {
        val ingredientsHotdog = listOf("Pølse", "Brød")
        val instructionsHotdog = listOf(
                "Steg pølsen",
                "Varm brødet",
                "Put ketchup, remoulade og pølse i brødet")


        val ingredientsBurger = listOf(
                "Oksekød",
                "Løg",
                "Tomat",
                "Etc")


        val instructionsBurger = listOf(
                "Steg bøf",
                "Skær grøntsager",
                "Lav resten")
        val instructionsIsLagKage = listOf("Smid",  "det oven på hinanden")

        val ingredientsIsLagKage = listOf("vaniljeis", "lagkagebund fra rema")


        val recipes = listOf(
            Recipe("Hotdog", "NamNam", "MainCourse", ingredientsHotdog, instructionsHotdog),
            Recipe("Burger", "Salat", "MainCourse", ingredientsBurger, instructionsBurger),
            Recipe("IsLagkage", "Is", "Dessert", ingredientsIsLagKage, instructionsIsLagKage)
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
        println(recipeList)

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