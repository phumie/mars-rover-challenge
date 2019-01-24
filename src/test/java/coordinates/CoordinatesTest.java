package coordinates;

import filereader.ReadFile;
import org.junit.Before;
import org.junit.Test;
import rover.Rover;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoordinatesTest {
    Coordinates roverCoordinates = new Coordinates(21, -3);
    Coordinates gridCoordinates = new Coordinates(10, 10);
    Rover rover;

    @Before
    public void init() {
        rover = new Rover(roverCoordinates, 'N', "RRMMMLMLMM");
    }

	@Test
    public void testInvalidCurrentRoverPositionRelativeToGridSize() {
        assertTrue("Rover is over grid boundaries.",
                rover.getPosition().checkCoordinates(roverCoordinates, gridCoordinates));
    }

    @Test
    public void testValidCurrentRoverPositionRelativeToGridSize() {
        roverCoordinates = new Coordinates(4, 7);
        gridCoordinates = new Coordinates(10, 10);
        assertFalse("Rover is within grid boundaries.",
                rover.getPosition().checkCoordinates(roverCoordinates, gridCoordinates));
    }


}
