package com.example.viewmodels

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.lifecycle.*
import com.example.db.RecipeDatabase
import com.example.food_recipe_app.R
import com.example.models.MealType
import com.example.models.Recipe
import com.example.repository.RecipeRepository
import com.example.views.BottomSheetFragment
import kotlinx.coroutines.launch
import java.io.InputStream


class RecipeViewModel(application: Application): AndroidViewModel(application) {
    val dao = RecipeDatabase.getAppDatabase(application)!!.recipeDao
    private val repository: RecipeRepository = RecipeRepository(dao)
    var fragment: BottomSheetFragment? = BottomSheetFragment()
    var mealType: String = "Dessert"

    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
    private var images = ArrayList<Bitmap>()

    init {

        images = getBitmap()

        val ingredientsHotdog = listOf("Pølse", "Brød")
        val instructionsHotdog = listOf(
                "Steg pølsen",
                "Varm brødet",
                "Put ketchup, remoulade og pølse i brødet"
        )


        val ingredientsBurger = listOf(
                "Oksekød",
                "Løg",
                "Tomat",
                "Etc"
        )


        val instructionsBurger = listOf(
                "Steg bøf",
                "Skær grøntsager",
                "Lav resten"
        )
        val instructionsIsLagKage = listOf("Smid", "det oven på hinanden")

        val ingredientsIsLagKage = listOf("vaniljeis", "lagkagebund fra rema")


        val recipes = listOf(
                Recipe("Hotdog", "NamNam", "MainCourse", ingredientsHotdog, instructionsHotdog, images.get(0)),
                Recipe("Burger", "Salat", "MainCourse", ingredientsBurger, instructionsBurger, images.get(1)),
                Recipe("IsLagkage", "Is", "Dessert", ingredientsIsLagKage, instructionsIsLagKage, images.get(2))
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
        var assetInStream: InputStream? = null
        lateinit var context: Context
        //val d: Drawable = Resources.getSystem().getDrawable(R.drawable.bulgogi_burgers)
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.bulgogi_burgers))
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.green_salat))
        images.add(BitmapFactory.decodeResource(context.resources, R.drawable.vegansk_paprikagryderet))

        println("images printed " + images)
        println("a image on index 0" + images.get(0))

        //var fileName = "bulgogi_burgers.jpg";
        //var documentsPath = Environment.(Environment.getRootDirectory().absoluteFile);
        //var path = Path.Combine(documentsPath, fileName);

        //println("Environemnt path " + Environment.getRootDirectory().absolutePath)
        //images.add(BitmapFactory.decodeFile(Environment.getRootDirectory().absolutePath))
        //val file = File("drawable/bulgogi_burgers.jpg")
        //val file2 = File("drawable/green_salat.jpg")
        //val file3 = File("drawable/vegansk_paprikagryderet.jpg")
        //println("file path " + file.absolutePath)
        //images.add(BitmapFactory.decodeFile(file.absolutePath))
        //images.add(BitmapFactory.decodeFile(file2.absolutePath))
        //images.add(BitmapFactory.decodeFile(file3.absolutePath))
        //res/drawable/bulgogi_burgers.jpg
        //println("img in getbitmap recipeviewmodel " + images)
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

    fun getUpdatedMealType(): String{
        return this.mealType
    }
}