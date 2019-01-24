import coordinates.Coordinates;
import errorcheck.ErrorCheck;
import filereader.ReadFile;
import rover.Rover;

public class RoverMain {
    public static void main(String[] args) {
        if (ErrorCheck.checkLines("../../../../commands.txt")){
            ReadFile readFile = new ReadFile();
            Coordinates gridSize = ReadFile.getGridSize();
            Coordinates roverCoordinates = ReadFile.getRoverCoordinates();
            char roverDirection = ReadFile.getRoverDirection();
            String movements = ReadFile.getRoverMovement();
            Rover rover = new Rover(roverCoordinates, roverDirection, movements);
            if (!Coordinates.checkCoordinates(roverCoordinates, gridSize))
                System.out.println(rover.moveRover());
        }
        else
            return;
    }
}
