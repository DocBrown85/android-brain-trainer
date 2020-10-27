package com.example.braintrainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goButton = findViewById(R.id.goButton)
    }

    fun start(view: View) {
        goButton.visibility = View.INVISIBLE
    }
}