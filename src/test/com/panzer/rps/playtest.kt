package test.com.panzer.rps

import com.panzer.rps.Choices
import com.panzer.rps.Play
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlayTest {

    @Test fun `selects correct enum when starting`() {
        var sut: Play = Play('p')
        assertEquals(Choices.PAPER, sut.choice, "Player intended to provide choice Paper")
    }

    @Test fun `selects none when an invalid input is provided`() {
        var sut: Play = Play('h')
        assertEquals(Choices.NONE, sut.choice, "Player should have been default to NONE")
    }

    @Test fun `player competes against arbitrary value`() {
        var sut: Play = Play('r')
        assertEquals(Choices.ROCK, sut.choice, "Player intended to provide choice Rock")
        sut.opponentsChoice = Choices.SCISSORS
        var result: Play.Companion.LeftRightOrBoth = sut.compete()
        assertEquals(Play.Companion.LeftRightOrBoth.LEFT, result, "Player should have won")
    }

    @Test fun `reports a tie if both choices match`() {
        var sut: Play = Play('s')
        sut.opponentsChoice = Choices.SCISSORS
        var result: Play.Companion.LeftRightOrBoth = sut.compete()
        assertEquals(Play.Companion.LeftRightOrBoth.BOTH, result, "Player should have tied")
    }

    @Test fun `player competes and loses`() {
        var sut: Play = Play('r')
        sut.opponentsChoice = Choices.PAPER
        var result: Play.Companion.LeftRightOrBoth = sut.compete()
        assertEquals(Play.Companion.LeftRightOrBoth.RIGHT, result, "Player should have lost")
    }

    @Test fun `player competes against rando value and opponit will not get none`() {
        for (i in 1..100) {
            var sut: Play = Play('s')
            assertTrue(Choices.values().contains(sut.opponentsChoice))
            assertFalse(sut.opponentsChoice.equals(Choices.NONE))
        }
    }
}