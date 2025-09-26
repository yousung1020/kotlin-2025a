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

        val buttonColor = findViewById<Button>(R.id.buttonGreet)

        buttonColor.setOnClickListener{
            startActivity(Intent(this, GreetingActivity::class.java))
        }
    }
}