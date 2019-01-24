package coordinates;

public class Coordinates {
    private int x;
    private int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean checkCoordinates(Coordinates roverCoordinates, Coordinates gridSize){
        if ((roverCoordinates.getX() < 0 || roverCoordinates.getX() > gridSize.getX()) ||
                (roverCoordinates.getY() < 0 || roverCoordinates.getY() > gridSize.getY()))
            return true;
        else
            return false;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = this.x + x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = this.y + y;
    }
}

