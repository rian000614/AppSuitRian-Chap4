package com.example.appsuitrian_chap4.computer

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appsuitrian_chap4.R
import com.example.appsuitrian_chap4.databinding.ActivityMainBinding
import com.example.appsuitrian_chap4.menu.MenuGame


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val name: String? by lazy {
        intent.getStringExtra(EXTRAS_MULTIPLAYER_MODE)
    }

    private fun initListeners() {
        binding.imgRock.setOnClickListener {
            startGame("ROCK").apply {
                Toast.makeText(this@MainActivity, "Pemain 1 memilih Batu",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgScissors.setOnClickListener {
            startGame("SCISSORS").apply {
                Toast.makeText(this@MainActivity, "Pemain 1 memilih Gunting",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgPaper.setOnClickListener {
            startGame("PAPER").apply {
                Toast.makeText(this@MainActivity, "Pemain 1 memilih Kertas" ,
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgResult.setImageResource(R.drawable.ic_vs)
    }

    fun refreshGame() {
        binding.imgRefresh.setOnClickListener {
            initListeners()
        }
    }

    private fun startGame(option: String) {
        val computerOption = GameSuit.picRandomOption()

        when {
            GameSuit.isDraw(
                option,
                computerOption
            ) -> alertClickDraw()
            GameSuit.isWin(
                option,
                computerOption
            ) -> alertClickWin()
            else -> alertClickLose()
        }
    }

    fun alertClickWin() {
        AlertDialog.Builder(this)
            .setTitle("Hasil Permainan")
            .setMessage("Anda Menang melawan komputer!!!")
            .setPositiveButton("Main Lagi", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Siap bermain kembali", Toast.LENGTH_LONG).show()
            })
            .setNegativeButton(
                "Kembali Ke Menu Utama",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    startActivity(Intent(this, MenuGame::class.java))
                })
            .show()
    }

    fun alertClickDraw() {
        AlertDialog.Builder(this)
            .setTitle("Hasil Permainan")
            .setMessage("Seimbang!!!")
            .setPositiveButton("Main Lagi", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Siap bermain kembali", Toast.LENGTH_LONG).show()
            })
            .setNegativeButton(
                "Kembali Ke Menu Utama",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    startActivity(Intent(this, MenuGame::class.java))
                })
            .show()
    }

    fun alertClickLose() {
        AlertDialog.Builder(this)
            .setTitle("Hasil Permainan")
            .setMessage("Komputer Menang melawan anda!!!")
            .setPositiveButton("Main Lagi", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Siap bermain kembali", Toast.LENGTH_LONG).show()
            })
            .setNegativeButton(
                "Kembali Ke Menu Utama",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    startActivity(Intent(this, MenuGame::class.java))
                })
            .show()
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
            context.startActivity(Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRAS_MULTIPLAYER_MODE, isUsingMultiplayerMode)
            })
        }
    }
}
