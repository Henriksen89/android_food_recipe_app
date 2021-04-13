package com.example.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.models.Recipe

@Database(
    entities = [Recipe::class],
    version = 1,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        // Singleton to prevent multiple instances from existing
        private var INSTANCE: RecipeDatabase? = null

        fun getAppDatabase(context: Context): RecipeDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, RecipeDatabase::class.java, "recipe-db")
                    // Allow queries on the main thread.
                    // Don't do this on a real app!
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

}