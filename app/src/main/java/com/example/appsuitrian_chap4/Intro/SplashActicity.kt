package com.example.appsuitrian_chap4.Intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.appsuitrian_chap4.databinding.ActivitySplashActicityBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash_acticity.*

class SplashActicity : AppCompatActivity() {

    private var timer: CountDownTimer? = null

    private val binding : ActivitySplashActicityBinding by lazy {
        ActivitySplashActicityBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setTimerSplashScreen()

        Picasso.get().load("https://miro.medium.com/max/828/0*kiiVkzXLlOvrYyX3.png").fit().centerCrop().into(img_screen)
    }

    override fun onDestroy() {
        super.onDestroy()
        //destroy the timer for case new activity still opened when splashscreen destoryed
        if (timer != null) {
            timer?.cancel()
            timer = null
        }
    }


    private fun setTimerSplashScreen() {
        timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@SplashActicity, OnboardingActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        timer?.start()
    }
}