package com.example.braintrainer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
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
    lateinit var resultTextView: TextView
    lateinit var scoreTextView: TextView
    lateinit var timerTextView: TextView
    lateinit var playAgainButton: Button

    private val answers = ArrayList<Int>()
    private var locationOfCorrectAnswer = -1
    private var totalNumberOfIssuedQuestions = 0
    private var totalNumberOfCorrectAnswers = 0

    fun start(view: View) {
        goButton.visibility = View.INVISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun newQuestion() {
        val random = Random()

        val a = random.nextInt(21)
        val b = random.nextInt(21)
        val correctAnswer = a + b

        sumTextView.text = "$a + $b"

        answers.clear()
        locationOfCorrectAnswer = random.nextInt(4)
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

    @SuppressLint("SetTextI18n")
    fun chooseAnswer(view: View) {
        if (locationOfCorrectAnswer.toString() == view.tag.toString()) {
            resultTextView.text = "Correct!"
            totalNumberOfCorrectAnswers++
        }
        else {
            resultTextView.text = "Wrong!"
        }
        totalNumberOfIssuedQuestions++
        scoreTextView.text = "$totalNumberOfCorrectAnswers/$totalNumberOfIssuedQuestions"

        newQuestion()
    }

    fun playAgain(view: View) {
        totalNumberOfIssuedQuestions = 0
        totalNumberOfCorrectAnswers = 0
        timerTextView.text = "30s"
        scoreTextView.text = "$totalNumberOfCorrectAnswers/$totalNumberOfIssuedQuestions"
        newQuestion()
        playAgainButton.visibility = View.INVISIBLE
        resultTextView.text = ""

        val countDownTimer = object : CountDownTimer(30100, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = "${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                resultTextView.text = "Done!"
                playAgainButton.visibility = View.VISIBLE
            }

        }.start()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goButton = findViewById(R.id.goButton)
        sumTextView = findViewById(R.id.sumTextView)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        resultTextView = findViewById(R.id.resultTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
        timerTextView = findViewById(R.id.timerTextView)
        playAgainButton = findViewById(R.id.playAgainButton)

        playAgain(resultTextView)
    }

}