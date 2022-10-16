package com.example.appsuitrian_chap4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appsuitrian_chap4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private fun initListeners() {
        binding.imgRock.setOnClickListener { startGame("ROCK") }
        binding.imgScissors.setOnClickListener { startGame("SCISSORS") }
        binding.imgPaper.setOnClickListener { startGame("PAPER") }
        binding.imgResult.setImageResource(R.drawable.ic_vs)


    }
    fun refreshGame(){
        binding.imgRefresh.setOnClickListener {
            initListeners()
        }
    }

    private fun startGame(option: String) {
        val computerOption = GameSuit.picRandomOption()
        when {
            GameSuit.isDraw(option, computerOption) -> binding.imgResult.setImageResource(R.drawable.ic_draw)
            GameSuit.isWin(option, computerOption) -> binding.imgResult.setImageResource(R.drawable.ic_p1win)
            else -> binding.imgResult.setImageResource((R.drawable.ic_p2win))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        refreshGame()
        initListeners()
    }

    companion object {
        private const val EXTRAS_MULTIPLAYER_MODE = "EXTRAS_MULTIPLAYER_MODE"

        fun startActivity(context: Context, isUsingMultiplayerMode: Boolean) {
            context.startActivity(Intent(context, MainActivity::class.java) .apply {
                putExtra(EXTRAS_MULTIPLAYER_MODE, isUsingMultiplayerMode)
            })
        }
    }
}