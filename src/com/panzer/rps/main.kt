package com.panzer.rps;

import kotlin.reflect.KTypeProjection

fun main(args: Array<String>) {
    var play: String?= readLine()
    var game: Play = Play(play!!.toCharArray().first())
    println("You Choose: " + game.choice.name)
    println("Opponent Choose: " + game.opponentsChoice.name)
    var winner: com.panzer.rps.Play.Companion.LeftRightOrBoth = game.compete()
    if (winner.equals(Play.Companion.LeftRightOrBoth.LEFT)) {
        println("YOU WIN")
    } else if (winner.equals(Play.Companion.LeftRightOrBoth.RIGHT)) {
        println("YOU LOSE")
    } else {
        println("TIE")
    }
}