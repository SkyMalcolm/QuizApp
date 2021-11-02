package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.quizapp.DataBase.AppDataBase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.playButton)

        button.setOnClickListener {
            startPlayActivity()
        }

    }

     fun startPlayActivity() {
        val intent = Intent(this, PlayActivity::class.java)

        startActivity(intent)

    }


}