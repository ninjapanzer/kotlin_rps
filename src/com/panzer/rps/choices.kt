package com.panzer.rps

enum class Choices constructor(choiceFirstChar: Char) {
    ROCK('r'),
    SCISSORS('s'),
    PAPER('p'),
    NONE(' ');

    var initial: Char = choiceFirstChar

    fun getIntial(): Char {
        return this.initial
    }

    companion object {
        fun find(choice: Char): Choices? {
            var picked: Choices? = Choices.values().filter { a -> a.getIntial() == choice.toLowerCase() }.firstOrNull()
            if (picked == null) {
                return NONE
            } else {
                return picked
            }
        }
    }
}