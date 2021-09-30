package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class PlayActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var questionAsked: TextView
    lateinit var txtTime: TextView
    lateinit var score: TextView
    lateinit var timer: CountDownTimer

    lateinit var cardAnswer1: CardView
    lateinit var cardAnswer2: CardView
    lateinit var cardAnswer3: CardView
    lateinit var cardAnswer4: CardView
    lateinit var answer1: TextView
    lateinit var answer2: TextView
    lateinit var answer3: TextView
    lateinit var answer4: TextView


    lateinit var cardPrize1: CardView
    lateinit var cardPrize2: CardView
    lateinit var cardPrize3: CardView
    lateinit var cardPrize4: CardView
    lateinit var cardPrize5: CardView
    lateinit var cardPrize6: CardView
    lateinit var cardPrize7: CardView
    lateinit var cardPrize8: CardView
    lateinit var cardPrize9: CardView
    lateinit var cardPrize10: CardView
    lateinit var txtPrize1: TextView
    lateinit var txtPrize2: TextView
    lateinit var txtPrize3: TextView
    lateinit var txtPrize4: TextView
    lateinit var txtPrize5: TextView
    lateinit var txtPrize6: TextView
    lateinit var txtPrize7: TextView
    lateinit var txtPrize8: TextView
    lateinit var txtPrize9: TextView
    lateinit var txtPrize10: TextView

    lateinit var currentPrize: CardView
    var currentPrizePosition: Int = 0

    var question: Questions? = null
    var currentQuestionPosition: Int = 1
    var questionsList: MutableList<Questions>? = null
    var scoreCount: Int = 0

    var prizeList = mutableListOf<CardView>()

    fun startWinActivity() {
        val intent = Intent(this@PlayActivity, WinActivity::class.java)
        startActivity(intent)
    }

    fun startFailActivity() {
        val intent = Intent(this, FailActivity::class.java)
        startActivity(intent)
    }


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
        score = findViewById(R.id.scoreCount)
        txtTime = findViewById(R.id.txtTime)

        cardAnswer1 = findViewById(R.id.cardAnswer1)
        cardAnswer2 = findViewById(R.id.cardAnswer2)
        cardAnswer3 = findViewById(R.id.cardAnswer3)
        cardAnswer4 = findViewById(R.id.cardAnswer4)
        cardAnswer1.setOnClickListener(this)
        cardAnswer2.setOnClickListener(this)
        cardAnswer3.setOnClickListener(this)
        cardAnswer4.setOnClickListener(this)

        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)


        cardPrize1 = findViewById(R.id.prize1)
        cardPrize2 = findViewById(R.id.prize2)
        cardPrize3 = findViewById(R.id.prize3)
        cardPrize4 = findViewById(R.id.prize4)
        cardPrize5 = findViewById(R.id.prize5)
        cardPrize6 = findViewById(R.id.prize6)
        cardPrize7 = findViewById(R.id.prize7)
        cardPrize8 = findViewById(R.id.prize8)
        cardPrize9 = findViewById(R.id.prize9)
        cardPrize10 = findViewById(R.id.prize10)

        prizeList.add(cardPrize1)
        prizeList.add(cardPrize2)
        prizeList.add(cardPrize3)
        prizeList.add(cardPrize4)
        prizeList.add(cardPrize5)
        prizeList.add(cardPrize6)
        prizeList.add(cardPrize7)
        prizeList.add(cardPrize8)
        prizeList.add(cardPrize9)
        prizeList.add(cardPrize10)

        questionsList = Konstanter.getQuestions()

        timer = object : CountDownTimer(18000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished / 1000) <= 2) {
                    currentPrize.setCardBackgroundColor(Color.rgb(247, 12, 40))
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

        currentPrize = prizeList[currentPrizePosition]
        currentPrize.setCardBackgroundColor(Color.rgb(52,64,201))

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
            Handler().postDelayed({
                p0?.setBackgroundColor(Color.WHITE)
                currentPrize = prizeList[currentPrizePosition]
                currentPrize.setCardBackgroundColor(Color.rgb(183, 255, 0))
                currentQuestionPosition++
                currentPrizePosition++
                scoreCount++
                if ( currentQuestionPosition <= questionsList!!.size ) {
                        questionDisplay()
                } else {
                    timer.cancel()
                    val intent = Intent(this, WinActivity::class.java)
                    startActivity(intent)
                    finish()
                }


            }, 1500)

        } else {
            timer.cancel()
            p0?.setBackgroundColor(Color.RED)
            currentPrize.setCardBackgroundColor(Color.rgb(247, 12, 40))
            Handler().postDelayed({
                startFailActivity()
                finish()
            }, 1500)
        }

    }


}




