package com.appweek04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGreet = findViewById<Button>(R.id.buttonGreet)
        val buttonCounter = findViewById<Button>(R.id.buttonCounter)

        buttonGreet.setOnClickListener{
            startActivity(Intent(this, GreetingActivity::class.java))
        }

        buttonCounter.setOnClickListener{
            startActivity(Intent(this, CounterActivity::class.java))
        }
    }
}