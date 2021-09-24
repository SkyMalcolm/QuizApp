package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*
import kotlin.concurrent.schedule

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var questionAsked: TextView
    lateinit var txtTime: TextView
    lateinit var cardAnswer1: CardView
    lateinit var cardAnswer2: CardView
    lateinit var cardAnswer3: CardView
    lateinit var cardAnswer4: CardView
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

        /*val gradientLayout = findViewById<ConstraintLayout>(R.id.gradientLayout)

        val animDrawable = gradientLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

         */

        questionAsked = findViewById(R.id.questionAsked)

        txtTime = findViewById(R.id.txtTime)

        cardAnswer1 = findViewById(R.id.cardAnswer1)
        cardAnswer2 = findViewById(R.id.cardAnswer2)
        cardAnswer3 = findViewById(R.id.cardAnswer3)
        cardAnswer4 = findViewById(R.id.cardAnswer4)

        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)

        cardAnswer1.setOnClickListener(this)
        cardAnswer2.setOnClickListener(this)
        cardAnswer3.setOnClickListener(this)
        cardAnswer4.setOnClickListener(this)

        score = findViewById(R.id.scoreCount)

        questionsList = Konstanter.getQuestions()

        timer = object : CountDownTimer(17000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished / 1000) <= 2) {
                    txtTime.setText("Time's up")
                } else {
                    txtTime.setText((millisUntilFinished / 1000 - 2).toString())
                }


                if ((millisUntilFinished / 1000) <= 7) {
                    txtTime.setTextColor(Color.RED)
                } else {
                    txtTime.setTextColor(Color.WHITE)
                }
            }

            override fun onFinish() {
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
            p0?.setBackgroundColor(Color.GREEN)
            Handler().postDelayed( {
                p0?.setBackgroundColor(Color.WHITE)
                currentQuestionPosition++
                scoreCount++
                when {
                    currentQuestionPosition <= questionsList!!.size -> {
                        questionDisplay()
                    }
                }
            } , 2000)

            } else {
            p0?.setBackgroundColor(Color.RED)
                Handler().postDelayed({
                    startFailActivity()
                } , 2000)
            }



        }

    }


