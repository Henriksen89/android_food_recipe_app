package com.example.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.example.models.Ingredient
import com.example.models.Instruction
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.io.ByteArrayOutputStream
import java.lang.reflect.Type


class Converts {
    @TypeConverter
    fun ingredientsListToJson(value: List<Ingredient>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToIngredientList(value: String) = Gson().fromJson(value, Array<Ingredient>::class.java).toList()

    @TypeConverter
    fun jsonToInstructionsList(value: String) = Gson().fromJson(value, Array<Instruction>::class.java).toList()

    @TypeConverter
    fun instructionListToJson(value: List<Ingredient>?) = Gson().toJson(value)


    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }
}