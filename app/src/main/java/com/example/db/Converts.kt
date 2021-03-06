package com.example.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.google.gson.Gson

import java.io.ByteArrayOutputStream


class Converts {
    @TypeConverter
    fun listToJson(value: List<String>?) : String {return Gson().toJson(value)}

    @TypeConverter
    fun jsonToList(value: String) : List<String> { return Gson().fromJson(value, Array<String>::class.java).toList()}


    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }


}