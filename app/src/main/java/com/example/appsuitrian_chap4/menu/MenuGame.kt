package com.example.appsuitrian_chap4.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appsuitrian_chap4.MainActivity
import com.example.appsuitrian_chap4.R
import com.example.appsuitrian_chap4.databinding.ActivityMainBinding
import com.example.appsuitrian_chap4.databinding.ActivityMenuGameBinding

class MenuGame : AppCompatActivity() {
    private lateinit var binding: ActivityMenuGameBinding

    private val name: String? by lazy {
        intent.getStringExtra(NAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setNameOnTitle()
        setMenuClickListeners()
    }

    private fun setMenuClickListeners() {
        binding.ivMenuVsComputer.setOnClickListener {
            MainActivity.startActivity(this, false)
        }
        /* binding.ivMenuVsPlayer.setOnClickListener {
             GameActivity.startActivity(this,true)
         }*/
    }

    private fun setNameOnTitle() {
        binding.tvTitleMenu.text = getString(R.string.placeholder_title_menu_game, name)
        binding.tvVsComputer.text = name + "   vs   Computer"
        binding.tvVsPlayer.text = name + "   vs   Player"

    }


    companion object {
        private const val NAME = ""
        fun startActivity(context: Context, name: String) {
            Toast.makeText(context,"Selamat datang "+ name, Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, MenuGame::class.java).apply {
                putExtra(NAME, name)
            })
        }
    }
}