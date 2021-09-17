package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    fun startFailActivity() {
        val intent = Intent(this, FailActivity::class.java)
        startActivity(intent)
    }

    var question: Questions? = null
    var currentQuestionPosition: Int = 1
    var questionsList: MutableList<Questions>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_activity)



        questionsList = Konstanter.getQuestions()

        questionDisplay()

    }

    fun questionDisplay() {
        lateinit var questionAsked: TextView
        lateinit var answer1: TextView
        lateinit var answer2: TextView
        lateinit var answer3: TextView
        lateinit var answer4: TextView

        questionAsked = findViewById(R.id.questionAsked)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)


        question = questionsList!![currentQuestionPosition - 1]

        questionAsked.text = question!!.question

        answer1.text = question?.optionOne
        answer2.text = question?.optionTwo
        answer3.text = question?.optionThree
        answer4.text = question?.optionFour

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)


    }


    override fun onClick(p0: View?) {


        if (question?.correctAnswer.toString() == "${p0?.tag}") {
            currentQuestionPosition++

        } else {
            startFailActivity()

        }
        when {
            currentQuestionPosition <= questionsList!!.size -> {
                questionDisplay()

            }
        }

    }

}