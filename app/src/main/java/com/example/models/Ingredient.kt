package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.db.Converts
import com.google.gson.annotations.SerializedName

@Entity
data class Ingredient(
        @PrimaryKey(autoGenerate = false)
        @SerializedName("instructions")
        @TypeConverters(Converts::class)
        var ingredients: List<String>
)
