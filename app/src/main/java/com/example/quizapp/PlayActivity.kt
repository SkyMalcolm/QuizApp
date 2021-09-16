package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    var currentPosition: Int = 1
    var questionsList: MutableList<Questions>? = null
    var SelectedPosition : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_quiz)


        questionsList = Konstanter.getQuestions()

        question()

    }

    fun question() {

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

        currentPosition = 1
        val question = questionsList!![currentPosition-1]

        questionAsked.text = question!!.question

        answer1.text = question.optionOne
        answer2.text = question.optionTwo
        answer3.text = question.optionThree
        answer4.text = question.optionFour

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
    Log.d("hej", "jaja")
    }


}

