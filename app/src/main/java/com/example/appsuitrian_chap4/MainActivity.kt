package com.example.appsuitrian_chap4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var computerPic: ImageView
    private lateinit var playerPic: ImageView
    private val choices = mutableListOf<String>("Rock","Paper","Scissors")
    lateinit var playerScoreText: TextView
    lateinit var computerScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img_refresh.setOnClickListener {
            clear()
        }
        playerScoreText = findViewById(R.id.player_score)
        computerScoreText = findViewById(R.id.computer_score)
    }

    fun rock(view: View) {
        when(choices.random()){
            "Rock" ->{
                tv_winner.text="Seri BATU dengan BATU"
            }
            "Paper" ->{

                tv_winner.text="Player1 Kalah BATU lawan KERTAS"
                val computerScore: Int = computerScoreText.text.toString().toInt() +1
                computerScoreText.text = computerScore.toString()
            }
            "Scissors" ->{
                tv_winner.text="Yuhu Menang BATU lawan GUNTING"
                val playerScore: Int = playerScoreText.text.toString().toInt() +1
                playerScoreText.text = playerScore.toString()
            }
        }
    }
    fun paper(view: View) {
        when(choices.random()){
            "Rock" ->{
                tv_winner.text="Player 1 Menang KERTAS lawan BATU"
            }
            "Paper" ->{
                tv_winner.text="Seri KERTAS lawan KERTAS"
                val computerScore: Int = computerScoreText.text.toString().toInt() +1
                computerScoreText.text = computerScore.toString()
            }
            "Scissors" ->{
                tv_winner.text="Aduh player1 kalah KERTAS lawan GUNTING"
                val playerScore: Int = playerScoreText.text.toString().toInt() +1
                playerScoreText.text = playerScore.toString()
            }
        }
    }
    fun scissors(view: View) {
        when(choices.random()){
            "Rock" ->{
                tv_winner.text="Aduh  player1 Kalah GUNTING lawan batu"
            }
            "Paper" ->{
                tv_winner.text="Player 1 Menang GUNTING lawan KERTAS"
                val computerScore: Int = computerScoreText.text.toString().toInt() +1
                computerScoreText.text = computerScore.toString()
            }
            "Scissors" ->{
                tv_winner.text="Seri GUNTING lawan GUNTING"
                val playerScore: Int = playerScoreText.text.toString().toInt() +1
                playerScoreText.text = playerScore.toString()
            }
        }
    }

    private fun clear() {
        computerScoreText.text ="0"
        playerScoreText.text="0"
        tv_winner.text = "VS"

    }
}