package com.example.quizapp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quizapp.Questions

@Database(entities = [Questions::class], version = 2)
abstract class AppDataBase: RoomDatabase() {
    abstract fun listDao() : ListDao

    companion object {

        @Volatile
        var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context) : AppDataBase?{
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDataBase::class.java,
                    "questionDB").
                fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}