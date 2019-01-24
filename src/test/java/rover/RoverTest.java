package rover;

import coordinates.Coordinates;
import movements.Movement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {

    private Rover rover;
    private Coordinates roverCoordinates;
    private Coordinates gridSize;
    private char direction;
    private String movement;

    @Before
    public void init() {
        roverCoordinates = new Coordinates(3, 3);
        gridSize = new Coordinates(10, 10);
        direction = 'E';
        movement = "MMMLLMRMM";
        rover = new Rover(roverCoordinates, direction, movement);
    }

    @Test
    public void roverValidPositionTest() {
        assertNotSame("Rover within boundaries", true, Coordinates.checkCoordinates(roverCoordinates, gridSize));
    }

    @Test
    public void roverInvalidPositionTest() {
        rover.getPosition().setX(8);
        rover.getPosition().setY(-4);
        assertNotSame("Rover outside boundaries", false,
                Coordinates.checkCoordinates(roverCoordinates, gridSize));
    }

    @Test
    public void roverValidMovementTest() {
        assertTrue("Movements are valid", Movement.validMovements(movement));
    }

    @Test
    public void roverInvalidMovementTest() {
        assertFalse("Movements are not valid", Movement.validMovements("MFLRMMLMM"));
    }

    @Test
    public void validRoverDirectionTest() {
        assertTrue("Valid direction", Movement.validDirection(direction));
    }

    @Test
    public void invalidRoverDirectionTest() {
        assertFalse("Valid direction", Movement.validDirection('Q'));
    }
}
