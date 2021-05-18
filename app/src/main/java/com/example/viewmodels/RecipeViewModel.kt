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
        val ingredientsSalat = listOf("Salat", "Agurk", "Tomat", "Dressing" )
        val instructionsSalat = listOf("Vask alle grønsager", "Snit grønsager og salaten groft", "Bland det hele sammen", "Velbekomme")

        val ingredientsBurger = listOf("Oksekød","Løg","Tomat","Agurk", "Ost", "Burger bolle")
        val instructionsBurger = listOf( "Steg bøf","Skær grøntsager","Varm bruger bollen i ovnen i 5 min", "Burgeren samles og er klar til at spise", "Velbekomme")

        val ingredientsPaprikagryderet = listOf("Bønner", "Paprika", "Tomat", "Chili" )
        val instructionsingredientsPaprikagryderet= listOf("Vask grønsager", "Smid hele molivitten i en gryde", "Kog sammen i 30 min", "Velbekomme")

        // Side Dishes
        val ingredientsAsparges = listOf("Asparges", "Salt", "Olie")
        val instructionsingredientsasparges = listOf("Vask aspargesene", "Steg på pande i 10 min", "Velbekomme")

        // Dessert
        val instructionsChokolade = listOf("Chokoladen kommes i en mikroovns sikker skål. Smelt chokoladen i mikroovnen, til den er helt smeltet.",
            "Rør fløden i 1 spsk. ad gangen, rør til alt fløden er indarbejdet i chokoladen, inden næste spsk. fløde hældes i.",
            "Kom nu din mascarpone i skålen, og pisk med en elmixer, til du har en blød creme.",
            "Kom din creme i en sprøjtepose, og læg den til side mens du forbereder resten.",
        "I en dyb tallerken hælder du 1 shot stærk kaffe (og evt. 2-4 spsk baileys, hvis du er til det) Knæk dine ladyfingers midt over. Find dine 2 serverings glas frem.",
        "Dyp dine ladyfingers kort i kaffen, sørg for at dyppe begge sider. Og placer så 1/2 ladyfinger i hvert glas",
        "Fordel halvdelen af cremen i de 2 glas, og kom 2 halve ladyfingers i hvert glas. Fordel resten af cremen i glassene.")
        val ingredientsChokolade = listOf("50 g Mascarpone", "75 g Fløde", "40 g Mørk chokolade", "1 shot Stærk kaffe", "Evt. 2-4 spsk. Bailyes")

        val recipes = listOf(
                Recipe("Salat", "Lækker nem salat", "MainCourse", ingredientsSalat, instructionsSalat, images.get(1)),
                Recipe("Burger","Verdens bedste burger","MainCourse", ingredientsBurger, instructionsBurger, images.get(0)),
                Recipe("Chokolade dessert", "Hurtig chokolade dessert til 2", "Dessert", ingredientsChokolade, instructionsChokolade, images.get(3)),
                Recipe("Paprikagryderet", "Fremragende og nem gryderet", "MainCourse", ingredientsPaprikagryderet, instructionsingredientsPaprikagryderet, images.get(2)),
                Recipe("Risted asparges", "Super nem side dish", "SideDish", ingredientsAsparges, instructionsingredientsasparges, images.get(4))
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
}