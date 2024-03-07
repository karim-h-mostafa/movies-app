package com.karim.data.db.local

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromListToRecord(value:List<String>):String
    {
        return value.joinToString(",")
    }
    @TypeConverter
    fun fromRecordToList(value:String) :List<String>{
        return value.split(",")
    }

}