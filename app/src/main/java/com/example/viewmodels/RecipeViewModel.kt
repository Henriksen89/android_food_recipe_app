package com.example.viewmodels

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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
    var mealType: String = "MainCourse"

    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
    private var images = ArrayList<Bitmap>()
    var context = application.applicationContext

    init {
        images = getBitmap()

        // Main Courses
        val ingredientsSalat = listOf("Salad", "Cucumber", "Tomato", "Dressing" )
        val instructionsSalat = listOf("Wash all vegetables", "Cut all vegetables", "Mix it together", "Bon appetit")

        val ingredientsBurger = listOf("Beef","Onion","Tomato","Cucumber", "Cheese", "Burger bun")
        val instructionsBurger = listOf( "Roast the beef","Cut the vegetables","toast the burger bun in the oven for 5 minutes", "The burger should be assembled and ready to be eaten", "Bon Appetit")

        val ingredientsPaprikagryderet = listOf("Beans", "Paprika", "Tomato", "Chilli" )
        val instructionsingredientsPaprikagryderet= listOf("Wash the vegetables", "Put all vegetables in a pot", "Boil it for 30 minutes", "Bon Appetit")

        // Side Dishes
        val ingredientsAsparges = listOf("Asparagus", "Salt", "Oil")
        val instructionsingredientsasparges = listOf("Wash asparagus", "Roast them on a pan for 10 minutes", "Bon Appetit")

        // Dessert
        val instructionsChokolade = listOf("The chocolate should be put in a bowl. Melt the chocolate in the microwave.",
            "Stir the cream, until all chocolate is and cream is mixed well.",
            "Put the mascarpone in a bowl and stir it until it is a soft creme.",
            "Put the cream in a icing bag and lie it aside.",
        "In a deep plate pour 1 shot of strong coffee. Break your ladyfingers. Find 2 service glasses.",
        "Dip the ladyfingers in the coffee and place 1/2 ladyfinger in each glass",
        "Seperate half of the creme and 2 half ladyfingers in the 2 glasses. Now put the rest of the creme in the two glasse - Bon Appetit.")
        val ingredientsChokolade = listOf("50 g Mascarpone", "75 g cream", "40 g dark chocolate", "1 shot strong coffee")

        val recipes = listOf(
                Recipe("Salad", "Delicious and easy salad", "MainCourse", ingredientsSalat, instructionsSalat, images.get(1)),
                Recipe("Burger","The best burger in the world","MainCourse", ingredientsBurger, instructionsBurger, images.get(0)),
                Recipe("Chocolate dessert", "Easy chocolate dessert for 2", "Dessert", ingredientsChokolade, instructionsChokolade, images.get(3)),
                Recipe("Paprika stew", "Excellent and easy stew", "MainCourse", ingredientsPaprikagryderet, instructionsingredientsPaprikagryderet, images.get(2)),
                Recipe("Roasted asparagus", "Super easy side dish", "SideDish", ingredientsAsparges, instructionsingredientsasparges, images.get(4))
        )

        val mealTypes = listOf(
                MealType("MainCourse"),
                MealType("SideDish"),
                MealType("Dessert")
        )

        recipes.forEach { insert(it) }
        mealTypes.forEach { insertMealType(it) }

        // must be coroutine
        if (recipeList.isEmpty()) {
            recipeList.addAll(dao.getRecipeMealType(mealType))
        }
        this.recipes.value = recipeList
        }

    /**
     * return images from resources
     */
    private fun getBitmap(): ArrayList<Bitmap> {
        val images = ArrayList<Bitmap>()
        val options = BitmapFactory.Options()
        options.inScaled = true

        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.bulgogi_burgers))
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.green_salat))
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.vegansk_paprikagryderet))
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.choco))
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.asparges))

        return images
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

    // Are called from recipeFragment
    fun getRecipes() : LiveData<ArrayList<Recipe>>{
        return recipes
    }
    /**
     * The updateMealType update the recipe list based on the selected meal type
     */
    // must be coroutine
    fun updateMealType(mealType: String) {
        recipeList.clear()
        recipeList.addAll(dao.getRecipeMealType(mealType))
        this.mealType = mealType
    }
}