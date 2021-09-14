package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.playButton)

        button.setOnClickListener {
            startPlayQuiz()
        }

    }


    fun startPlayQuiz() {
        val intent = Intent(this, playQuiz::class.java)

        startActivity(intent)
    }

}