package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class playQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_quiz)

       lateinit var questionAsked : TextView
       lateinit var answer1 : TextView
       lateinit var answer2 : TextView
       lateinit var answer3 : TextView
       lateinit var answer4 : TextView

        questionAsked = findViewById(R.id.questionAsked)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        val questionsList = Konstanter.getQuestions()
        Log.d("Questions size", "${questionsList.size}")

        val currentPosition = 1
        val question: Questions? = questionsList[currentPosition -1]

       questionAsked.text = question!!.question

        answer1.text = question.optionOne
        answer2.text = question.optionTwo
        answer3.text = question.optionThree
        answer4.text = question.optionFour


    }
}