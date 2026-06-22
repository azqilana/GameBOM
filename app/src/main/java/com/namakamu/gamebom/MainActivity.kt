package com.namakamu.gamebom

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var boxes: List<Button>
    private lateinit var tvScore: TextView
    private var score = 0
    private var bombIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvScore = findViewById(R.id.tvScore)

        boxes = listOf(
            findViewById(R.id.box0), findViewById(R.id.box1), findViewById(R.id.box2),
            findViewById(R.id.box3), findViewById(R.id.box4), findViewById(R.id.box5),
            findViewById(R.id.box6), findViewById(R.id.box7), findViewById(R.id.box8)
        )

        startNewRound()

        boxes.forEachIndexed { index, button ->
            button.setOnClickListener {
                onBoxClicked(index)
            }
        }
    }

    private fun startNewRound() {
        bombIndex = (0 until 9).random()
        boxes.forEach { it.text = "" }
    }

    private fun onBoxClicked(index: Int) {
        if (index == bombIndex) {
            boxes[index].text = "\uD83D\uDCA3"
            score = 0
            tvScore.text = "Skor: $score (Kalah! Reset)"
        } else {
            boxes[index].text = "\u2705"
            score += 1
            tvScore.text = "Skor: $score"
        }
        startNewRound()
    }
}
