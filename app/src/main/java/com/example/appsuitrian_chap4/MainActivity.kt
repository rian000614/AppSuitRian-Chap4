package com.example.appsuitrian_chap4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var rockImageView: ImageView
    lateinit var scissorsImageView: ImageView
    lateinit var paperImageView: ImageView
    lateinit var resultImageView: ImageView
    lateinit var refreshImageView: ImageView

    private fun initComponents(){
        rockImageView = findViewById(R.id.img_rock)
        scissorsImageView = findViewById(R.id.img_scissors)
        paperImageView = findViewById(R.id.img_paper)
        resultImageView = findViewById(R.id.img_result)
        refreshImageView = findViewById(R.id.img_refresh)
    }

    private fun initListeners(){
        rockImageView.setOnClickListener{ startGame("ROCK")}
        scissorsImageView.setOnClickListener{ startGame("SCISSORS")}
        paperImageView.setOnClickListener{ startGame("PAPER")}

        refreshImageView.setOnClickListener {
            rockImageView.setOnClickListener{ startGame("ROCK")}
            scissorsImageView.setOnClickListener{ startGame("SCISSORS")}
            paperImageView.setOnClickListener{ startGame("PAPER")}
            resultImageView.setImageResource(R.drawable.ic_vs)
        }
    }

    private fun startGame(option: String){
        val computerOption = GameSuit.picRandomOption()
        when{
            GameSuit.isDraw(option, computerOption)-> resultImageView.setImageResource(R.drawable.ic_draw)
            GameSuit.isWin(option, computerOption)-> resultImageView.setImageResource(R.drawable.ic_p1win)
            else -> resultImageView.setImageResource((R.drawable.ic_p2win))
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()
    }
}