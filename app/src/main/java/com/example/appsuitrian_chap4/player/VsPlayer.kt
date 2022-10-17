package com.example.appsuitrian_chap4.player

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appsuitrian_chap4.R
import com.example.appsuitrian_chap4.databinding.ActivityVsPlayerBinding

class VsPlayer : AppCompatActivity() {

    private val binding: ActivityVsPlayerBinding by lazy {
        ActivityVsPlayerBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListeners()

    }
    private fun initListeners() {
        binding.imgRock.setOnClickListener {
            resultGameSuit("ROCK","SCISSORS").apply {
                Toast.makeText(this@VsPlayer, "Pemain 1 memilih Batu ",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgScissors.setOnClickListener {
            resultGameSuit("SCISSORS","ROCK").apply {
                Toast.makeText(this@VsPlayer, "Pemain 1 memilih Gunting",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgPaper.setOnClickListener {
            resultGameSuit("PAPER","SCISSORS").apply {
                Toast.makeText(this@VsPlayer, "Pemain 1 memilih kertas ",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgScissorsRight.setOnClickListener {
            resultGameSuit("ROCK","SCISSORS").apply {
                Toast.makeText(this@VsPlayer, "Pemain 2 memilih Gunting",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgRockRight.setOnClickListener {
            resultGameSuit("SCISSORS","ROCK").apply {
                Toast.makeText(this@VsPlayer, "Pemain 2 menang memilih Batu ",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgPaperRight.setOnClickListener {
            resultGameSuit("SCISSORS","PAPER").apply {
                Toast.makeText(this@VsPlayer, "Pemain 2 memilih Kertas",
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.imgResult.setImageResource(R.drawable.ic_vs)
    }


    fun resultGameSuit (playerOne: String, playerTwo: String): Int {
        return if (playerOne == playerTwo) {
            DRAW
        } else if (playerOne == "ROCK") {
            if (playerTwo == "SCISSOR") {
                PLAYER_ONE_WIN
            } else {
                PLAYER_TWO_WIN
            }
        } else if (playerOne == "PAPER") {
            if (playerTwo == "ROCK") {
                PLAYER_ONE_WIN
            } else {
                PLAYER_TWO_WIN
            }
        } else {
            if (playerTwo == "PAPER") {
                PLAYER_ONE_WIN
            } else {
                PLAYER_TWO_WIN
            }
        }
    }
    companion object {
        const val DRAW = 0
        const val PLAYER_ONE_WIN = 1
        const val PLAYER_TWO_WIN = 2

        private const val EXTRAS_MULTIPLAYER_MODE = "EXTRAS_MULTIPLAYER_MODE"
        fun startActivity(context: Context, isUsingMultiplayerMode: Boolean) {
            context.startActivity(Intent(context, VsPlayer::class.java).apply {
                putExtra(EXTRAS_MULTIPLAYER_MODE, isUsingMultiplayerMode)
            })
        }
    }
}