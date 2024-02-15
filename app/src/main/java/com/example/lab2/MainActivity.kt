package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.runtime.mutableIntStateOf

val counter = mutableIntStateOf(-1)


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        counter.intValue += 1
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
        val countText: TextView = findViewById(R.id.textCount)
        countText.text = counter.intValue.toString()
        val textButton: Button = findViewById(R.id.square_of_the_number)
        textButton.setOnClickListener {
            val intent = Intent(this, SquareOfTheNumber::class.java).apply {
                putExtra("sqrt", counter.intValue.toString())
            }
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}


