package com.panzer.rps

import java.util.*

class Play(choice: Char) {
    var choice: Choices = Choices.find(choice)!!
    var opponentsChoice: Choices = Choices.values()[Random().nextInt(3)]

    companion object {
        var winners: Map<Choices, Choices> = mapOf(
                Choices.PAPER to Choices.ROCK,
                Choices.ROCK to Choices.SCISSORS,
                Choices.SCISSORS to Choices.ROCK)

        enum class LeftRightOrBoth {
            LEFT, RIGHT, BOTH;
        }
    }

    fun compete(): LeftRightOrBoth {
        if (isNone()) return LeftRightOrBoth.RIGHT
        if (isTie()) return LeftRightOrBoth.BOTH

        if (winners[choice]!!.equals(opponentsChoice)) {
            return LeftRightOrBoth.LEFT
        } else {
            return LeftRightOrBoth.RIGHT
        }
    }

    fun isNone(): Boolean {
        return choice.equals(Choices.NONE)
    }

    fun isTie(): Boolean {
        return choice.equals(opponentsChoice)
    }
}