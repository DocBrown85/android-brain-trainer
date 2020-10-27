package com.example.braintrainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var goButton: Button
    lateinit var sumTextView: TextView
    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button

    private val answers = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goButton = findViewById(R.id.goButton)
        sumTextView = findViewById(R.id.sumTextView)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        val random = Random()

        val a = random.nextInt(21)
        val b = random.nextInt(21)
        val correctAnswer = a + b

        sumTextView.text = a.toString() + " + " + b.toString()

        val locationOfCorrectAnswer = random.nextInt(4)
        for (i in 0 until 4) {
            if (i == locationOfCorrectAnswer) {
                answers.add(i, correctAnswer)
            }
            else {

                var wrongAnswer: Int
                do {
                    wrongAnswer = random.nextInt(41)
                } while (wrongAnswer == correctAnswer)

                answers.add(i, wrongAnswer)
            }
        }

        button0.text = answers[0].toString()
        button1.text = answers[1].toString()
        button2.text = answers[2].toString()
        button3.text = answers[3].toString()
    }

    fun start(view: View) {
        goButton.visibility = View.INVISIBLE
    }

    fun chooseAnswer(view: View) {

    }
}