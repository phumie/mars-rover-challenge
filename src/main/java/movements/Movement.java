package movements;

public class Movement {

    public static boolean validMovements(String movement) {
        int len = movement.length();
        boolean check = false;

        for (int index = 0; index < len; index++){
            if (movement.charAt(index) == 'M' || movement.charAt(index) == 'L' || movement.charAt(index) == 'R')
               check = true;
            else {
                check = false;
                break;
            }
        }
        return check;
    }

    public static boolean validDirection(char direction) {
        switch(direction) {
            case 'E' :
                return true;
            case 'W' :
                return true;
            case 'N' :
                return true;
            case 'S' :
                return true;
            default :
                return false;
        }
    }
}
