package com.example.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.models.Recipe

@Database(
    entities = [Recipe::class],
    version = 1
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract val recipeDao: RecipeDao

    companion object {
        // Singleton to prevent multiple instances from existing
        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getAppDatabase(context: Context): RecipeDatabase? {
            println("context:" + context)
            synchronized(this) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RecipeDatabase::class.java,
                        "recipe-db")
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