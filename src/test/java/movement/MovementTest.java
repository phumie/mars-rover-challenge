package movement;

import org.junit.Test;

import movements.Movement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovementTest {
	@Test
    public void testInvalidMovements() {
        assertFalse("Invalid rover movements", Movement.validMovements("MMRRELL"));
    }

    @Test
    public void testValidMovements() {
        assertTrue("Valid rover movements", Movement.validMovements("MMRRLL"));
    }

    @Test
    public void testValidDirections() {
        assertTrue("Valid direction", Movement.validDirection('E'));
        assertTrue("Valid direction", Movement.validDirection('W'));
        assertTrue("Valid direction", Movement.validDirection('N'));
        assertTrue("Valid direction", Movement.validDirection('S'));
    }

    @Test
    public void testInvalidDirections() {
        assertFalse("Invalid direction", Movement.validDirection('G'));
        assertFalse("Invalid direction", Movement.validDirection('2'));
    }

}
