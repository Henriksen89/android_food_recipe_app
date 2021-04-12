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
    abstract fun getRecipeDao(): RecipeDao

    companion object{
        // Volatile - other thread can immediately see when a thread changes this instance
        // Singleton instance
        @Volatile
        private var instance: RecipeDatabase? = null
        // Make sure that there only is a single instance of our database
        private val LOCK = Any()
        // code here cannot be accessed by other threads at the same time
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RecipeDatabase::class.java,
                "recipe_db.dk"
            ).build()
    }

}