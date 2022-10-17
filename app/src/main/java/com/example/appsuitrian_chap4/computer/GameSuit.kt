package com.example.appsuitrian_chap4.computer

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

    fun picRandomOption(): String = options[Random.nextInt(0,3)]

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!

    fun isWin2(to: String, from: String): Boolean = rules ["$to-$from"]!!



}