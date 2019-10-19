package com.padcmyanmar.padc9.mynetflixmovieapplication.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreListTypeConverter {
    @TypeConverter
    fun toString(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<Int> {
        return Gson().fromJson<List<Int>>(json, object : TypeToken<List<Int>>() {}.type)
    }
}