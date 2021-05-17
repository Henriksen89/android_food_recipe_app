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
        var ingredients: Array<String>
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Ingredient

                if (!ingredients.contentEquals(other.ingredients)) return false

                return true
        }

        override fun hashCode(): Int {
                return ingredients.contentHashCode()
        }
}