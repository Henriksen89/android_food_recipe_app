package com.example.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.db.Converts
import com.google.gson.annotations.SerializedName

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = false)
    val recipeTitle: String,
    val recipeDescription: String,
    val mealType: String,
    @SerializedName("")
    @TypeConverters
    val ingredients: List<String>,
    @TypeConverters
    val instructions: List<String>,
    @TypeConverters
    val image : Bitmap

)