package rover;

import coordinates.Coordinates;
import movements.Movement;

public class Rover extends Movement{
    private Coordinates position;
    private char direction;
    private String movement;

    public Rover(Coordinates position, char direction, String movement){
        this.position = position;
        this.movement = movement;
        this.direction = direction;
    }

    public String moveRover(){
        int len = movement.length();
        for (int index = 0; index < len; index++){
            if (movement.charAt(index) == 'M') {
                switch (direction) {
                    case 'E':
                        position.setX(1);
                        break;
                    case 'W':
                        position.setX(-1);
                        break;
                    case 'N':
                        position.setY(1);
                        break;
                    case 'S':
                        position.setY(-1);
                        break;
                }
            }
            else if (movement.charAt(index) == 'L') {
                switch (direction) {
                    case 'E':
                        setDirection('N');
                        break;
                    case 'W':
                        setDirection('S');
                        break;
                    case 'N':
                        setDirection('W');
                        break;
                    case 'S':
                        setDirection('E');
                        break;
                }
            }
            else if (movement.charAt(index) == 'R') {
                switch (direction) {
                    case 'E':
                        setDirection('S');
                        break;
                    case 'W':
                        setDirection('N');
                        break;
                    case 'N':
                        setDirection('E');
                        break;
                    case 'S':
                        setDirection('W');
                        break;
                }
            }
        }
        return (position.getX() + " " + position.getY() + " " + direction);
    }

    /**
     * @return the direction
     */
    public char getDirection() {
        return direction;
    }

    /**
     * @return the position
     */
    public Coordinates getPosition() {
        return position;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }
}

