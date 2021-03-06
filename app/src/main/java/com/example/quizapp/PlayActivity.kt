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
import com.example.quizapp.DataBase.AppDataBase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PlayActivity : AppCompatActivity(), View.OnClickListener, CoroutineScope {
    lateinit var questionAsked: TextView
    lateinit var txtTime: TextView
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
    lateinit var currentPrize: CardView

    lateinit var db : AppDataBase

    private lateinit var job : Job

    var questionList : MutableList<Questions> = mutableListOf()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var currentPrizePosition: Int = 0

    var question: Questions? = null

    var currentQuestionPosition: Int = 1

    var prizeList = mutableListOf<CardView>()

    fun startFailActivity(prize: String) {
        val intent = Intent(this, FailActivity::class.java)
        intent.putExtra("Prize", prize)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_activity)

        job = Job()

        db = AppDataBase.getInstance(this)!!

      //addNewQuestions(questionList)

        loadAllQuestions()

        questionAsked = findViewById(R.id.questionAsked)
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

        timer = object : CountDownTimer(18000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished / 1000) <= 2) {
                    currentPrize.setCardBackgroundColor(Color.rgb(247, 12, 40))
                    txtTime.setText("Time's up")
                } else {
                    txtTime.setText("Remaining time: " + (millisUntilFinished / 1000 - 2).toString())
                }


                if ((millisUntilFinished / 1000) <= 7) {
                    txtTime.setTextColor(Color.RED)
                } else {
                    txtTime.setTextColor(Color.WHITE)
                }
            }

            override fun onFinish() {
                startFailActivity(currentPrize.tag.toString())
            }
        }


    }

    fun addNewQuestions(list: MutableList<Questions>) {

        launch(Dispatchers.IO) {
            db.listDao().insertAll(list)
        }

    }

    fun loadAllQuestions() {
        val questions = async(Dispatchers.IO) {
            db.listDao().getAll()
        }

        launch {
            questionList = questions.await().toMutableList()

            questionDisplay()

        }


    }

    fun questionDisplay() {

        question = questionList!![currentQuestionPosition - 1]

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
                if ( currentQuestionPosition <= questionList!!.size ) {
                        questionDisplay()
                } else {
                    timer.cancel()
                    val intent = Intent(this, WinActivity::class.java)
                    startActivity(intent)
                    finish()
                }


            }, 250)

        } else {
            timer.cancel()
            p0?.setBackgroundColor(Color.RED)
            currentPrize.setCardBackgroundColor(Color.rgb(247, 12, 40))
            Handler().postDelayed({
                startFailActivity(currentPrize.tag.toString())
                finish()
            }, 250)
        }

    }


}




