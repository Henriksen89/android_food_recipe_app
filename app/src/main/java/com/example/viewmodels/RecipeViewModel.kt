package com.example.viewmodels

import android.app.Application
import android.content.res.Resources
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
import java.io.ByteArrayOutputStream
import java.io.InputStream


class RecipeViewModel(application: Application): AndroidViewModel(application) {
    val dao = RecipeDatabase.getAppDatabase(application)!!.recipeDao
    private val repository: RecipeRepository = RecipeRepository(dao)
    var fragment: BottomSheetFragment? = BottomSheetFragment()
    var mealType: String = "Dessert"

    private var recipes = MutableLiveData<ArrayList<Recipe>>()
    private val recipeList = ArrayList<Recipe>()
    private var images = ArrayList<Bitmap>()
    var context = application.applicationContext
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


        //val d: Drawable = Resources.getSystem().getDrawable(R.drawable.bulgogi_burgers)
        //val b1 : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.bulgogi_burgers)
        //val b2 : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.green_salat)
        //val b3 : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.vegansk_paprikagryderet)
        //images.add(Bitmap.createScaledBitmap(b1, 120, 120, false))
        //val out = ByteArrayOutputStream()
        //val b1 : Bitmap? = shrinkBitmap(context.resources, R.drawable.bulgogi_burgers, 50,50)
        //val b2 : Bitmap? = shrinkBitmap(context.resources, R.drawable.green_salat, 50,50)

        //val b3 : Bitmap? = shrinkBitmap(context.resources, R.drawable.vegansk_paprikagryderet, 50,50)

        //if (b1 != null && b2 !=null && b3!= null) {
        //    images.add(b1)
        //    images.add(b2)
        //    images.add(b3)
       //}


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

    fun shrinkBitmap(res: Resources,file: Int, width: Int, height: Int): Bitmap? {
        val bmpFactoryOptions = BitmapFactory.Options()
        bmpFactoryOptions.inJustDecodeBounds = true
        var bitmap = BitmapFactory.decodeResource(res, file, bmpFactoryOptions)
        val heightRatio = Math.ceil((bmpFactoryOptions.outHeight / height.toFloat()).toDouble()).toInt()
        val widthRatio = Math.ceil((bmpFactoryOptions.outWidth / width.toFloat()).toDouble()).toInt()
        if (heightRatio > 1 || widthRatio > 1) {
            if (heightRatio > widthRatio) {
                bmpFactoryOptions.inSampleSize = heightRatio
            } else {
                bmpFactoryOptions.inSampleSize = widthRatio
            }
        }
        bmpFactoryOptions.inJustDecodeBounds = false
        bitmap = BitmapFactory.decodeResource(res, file, bmpFactoryOptions)
        return bitmap
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