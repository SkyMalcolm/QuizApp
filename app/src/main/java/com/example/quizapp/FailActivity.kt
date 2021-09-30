package com.example.quizapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class FailActivity : AppCompatActivity() {

    lateinit var prizeView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail)

        val intent = intent
        val wonPrize = intent.getStringExtra("Prize")
        prizeView = findViewById(R.id.prizeView)
        prizeView.setText("But you won $" + wonPrize + "!")
        var button: Button = findViewById(R.id.restartButton)

        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}