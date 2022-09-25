package com.example.appsuitrian_chap4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rock(view: View) {}
    fun paper(view: View) {}
    fun scissors(view: View) {}
}