package com.example.quizapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions_table")
data class Questions (

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo (name = "question") val question: String,
    @ColumnInfo(name = "option one") val optionOne: String,
    @ColumnInfo(name = "option two") val optionTwo: String,
    @ColumnInfo(name = "option three") val optionThree: String,
    @ColumnInfo(name = "option four") val optionFour: String,
    @ColumnInfo(name = "correct option") val correctAnswer: Int,
)
