package com.example.quizapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gradientLayout = findViewById<ConstraintLayout>(R.id.gradientLayout)

        val animDrawable = gradientLayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val button = findViewById<Button>(R.id.playButton)

        button.setOnClickListener {
            startPlayActivity()
        }

    }


    private fun startPlayActivity() {
        val intent = Intent(this, PlayActivity::class.java)

        startActivity(intent)

    }

}