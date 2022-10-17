package com.example.appsuitrian_chap4.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appsuitrian_chap4.computer.MainActivity
import com.example.appsuitrian_chap4.R
import com.example.appsuitrian_chap4.databinding.ActivityMenuGameBinding
import com.example.appsuitrian_chap4.player.VsPlayer
import com.google.android.material.snackbar.Snackbar

class MenuGame : AppCompatActivity() {
    private lateinit var binding: ActivityMenuGameBinding

    private val name: String? by lazy {
        intent.getStringExtra(NAME)
    }

    override fun onCreate(savedInstanceState:  Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setNameOnTitle()
        setMenuClickListeners()
        showSnakcbar()
    }

    fun showSnakcbar(){
        Snackbar.make(
            binding.menuGame, "Selamat datang ${name?.replaceFirstChar { it.uppercase() }}",
            Snackbar.LENGTH_LONG
        )
            .setAction("Dismiss") {}.show()
    }

    private fun setMenuClickListeners() {
        binding.ivMenuVsComputer.setOnClickListener {
            MainActivity.startActivity(this, false)
        }
        binding.ivMenuVsPlayer.setOnClickListener {
            VsPlayer.startActivity(this,false)
         }
    }

    private fun setNameOnTitle() {
        binding.tvTitleMenu.text = getString(R.string.placeholder_title_menu_game, name)
        binding.tvVsComputer.text = name + "   vs   Computer"
        binding.tvVsPlayer.text = name + "   vs   Player"

    }

    companion object {
        private const val NAME = ""
        fun startActivity(context: Context, name: String) {
            context.startActivity(Intent(context, MenuGame::class.java).apply {
                putExtra(NAME, name)
            })
        }
    }
}