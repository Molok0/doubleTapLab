package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
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
        val countText: TextView = findViewById<TextView>(R.id.textCount)
        val textButton: Button = findViewById<Button>(R.id.square_of_the_number)
        countText.text = counter.intValue.toString()

        textButton.setOnClickListener {
            val intent = Intent(this, SquareOfTheNumber::class.java).apply {
                val bundle: Bundle = Bundle().apply {
                    putString("sqrt", counter.intValue.toString())
                }
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
//    fun toClickTo(view:View){
//        val intent = Intent(this, SquareOfTheNumber::class.java).apply {
//            val bundle: Bundle = Bundle().apply {
//                putString("sqrt", counter.intValue.toString())
//            }
//            putExtras(bundle)
//        }
//        startActivity(intent)
//    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}


