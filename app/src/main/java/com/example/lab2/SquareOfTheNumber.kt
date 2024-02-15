package com.example.lab2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class SquareOfTheNumber : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.square_of_the_number)

        val text: TextView = findViewById<TextView>(R.id.textSqr)
        val backButton: Button = findViewById<Button>(R.id.backButton)
        val intent = intent
        val bundel: Bundle? = intent.extras
        val sqr = bundel?.getString("sqrt")?.toInt() ?: 0
        text.text = (sqr * sqr).toString()
        backButton.setOnClickListener {
            finish()
        }
        Log.d("SquareOfTheNumber", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("SquareOfTheNumber", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SquareOfTheNumber", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SquareOfTheNumber", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SquareOfTheNumber", "onDestroy")
    }
}