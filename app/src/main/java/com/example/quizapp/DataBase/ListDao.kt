package com.example.quizapp.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.Questions

@Dao
interface ListDao {
    @Query("SELECT * FROM questions_table")
    fun getAll(): List<Questions>

    @Insert
    fun insertAll(list: MutableList<Questions>)

    @Delete
    fun delete(list: Questions)
}