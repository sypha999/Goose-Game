package game_activites;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiceTest {

    @Test
    public void testRoll() {
        assertEquals(2, (new Dice()).roll().length);
    }


    @Test
    public void testGetrandom() {

        assertTrue(Dice.getrandom()>0 && Dice.getrandom()<7);

    }
}

