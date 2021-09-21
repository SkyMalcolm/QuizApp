package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var questionAsked: TextView
    lateinit var txtTime: TextView
    lateinit var answer1: TextView
    lateinit var answer2: TextView
    lateinit var answer3: TextView
    lateinit var answer4: TextView
    lateinit var score: TextView
    lateinit var timer: CountDownTimer


    fun startFailActivity() {
        val intent = Intent(this, FailActivity::class.java)
        startActivity(intent)
    }

    var question: Questions? = null
    var currentQuestionPosition: Int = 1
    var questionsList: MutableList<Questions>? = null
    var scoreCount: Int = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_activity)

        val gradientLayout = findViewById<ConstraintLayout>(R.id.gradientLayout)

        val animDrawable = gradientLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        questionAsked = findViewById(R.id.questionAsked)

        txtTime = findViewById(R.id.txtTime)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)

        score = findViewById(R.id.scoreCount)

        questionsList = Konstanter.getQuestions()

        timer = object : CountDownTimer(15000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                txtTime.setText((millisUntilFinished / 1000).toString())

                if ((millisUntilFinished/1000) <= 5) {
                    txtTime.setTextColor(Color.RED)
                }
            }

            override fun onFinish() {
                txtTime.setText("Time's up!")

                Thread.sleep(500)
                startFailActivity()
            }
        }

        questionDisplay()

    }

    fun questionDisplay() {

        score.text = scoreCount.toString()

        question = questionsList!![currentQuestionPosition - 1]

        questionAsked.text = question!!.question

        answer1.text = question?.optionOne
        answer2.text = question?.optionTwo
        answer3.text = question?.optionThree
        answer4.text = question?.optionFour
        timer.start()
    }

    override fun onClick(p0: View?) {

        if (question?.correctAnswer.toString() == "${p0?.tag}") {
            timer.cancel()
            currentQuestionPosition++
            scoreCount++

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