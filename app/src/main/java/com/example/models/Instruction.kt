package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.db.Converts
import com.google.gson.annotations.SerializedName

@Entity
data class Instruction(
        @PrimaryKey(autoGenerate = false)
        @SerializedName("instructions")
        @TypeConverters(Converts::class)
        var instructions: Array<String>
)