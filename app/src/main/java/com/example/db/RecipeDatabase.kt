package com.example.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.models.MealType
import com.example.models.Recipe

@Database(
    entities = [
        Recipe::class,
        MealType::class],
    version = 7
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract val recipeDao: RecipeDao

    companion object {
        // Singleton to prevent multiple instances from existing
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getAppDatabase(context: Context): RecipeDatabase? {
            synchronized(this) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RecipeDatabase::class.java,
                        "recipe-db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build().also {
                            INSTANCE = it
                        }

                }
            }
            return INSTANCE!!
        }
    }
}