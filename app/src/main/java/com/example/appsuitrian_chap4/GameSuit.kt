package com.example.appsuitrian_chap4

import kotlin.random.Random

object GameSuit {

    private val rules = mapOf(
        "ROCK-SCISSORS" to true,
        "ROCK-PAPER" to false,
        "SCISSORS-PAPER" to true,
        "SCISSORS-ROCK" to false,
        "PAPER-ROCK" to true,
        "PAPER-SCISSORS" to false
    )

    private val options = listOf("ROCK","SCISSORS","PAPER")

    private val optionDrawable = mapOf(
        "ROCK" to R.drawable.rock,
        "SCISSORS" to R.drawable.scissors,
        "PAPER" to R.drawable.paper
    )

    fun picRandomOption(): String = options[Random.nextInt(0,3)]

    //fun pickDrawable(option: String): Int = optionDrawable[option]!!

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!

    fun isWin2(from: String, to: String): Boolean = rules["$from-$to"]!!


}