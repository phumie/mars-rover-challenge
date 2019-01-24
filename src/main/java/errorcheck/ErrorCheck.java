package errorcheck;

import filereader.ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ErrorCheck {
    private static String line;
    private static String[] lines = null;

    private static boolean isNumber(String line) {
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c))
                return true;
        }
        return false;
    }

    private static boolean checkGridSize(String str) {
        String items[] = str.split("\\s");

        if (items.length > 2 || items.length < 2)
            return false;
        if (isNumber(items[0]) && isNumber(items[1]))
            return false;
        return true;
    }

    private static boolean checkRoverCoordinatesAndDirections(String str) {
        String items[] = str.split("\\s");

        if (items.length > 3 || items.length < 2)
            return false;
        if (items.length == 2){
            if (isNumber(items[0]))
                return false;
            if (items[1].equals("E") || items[1].equals("W") || items[1].equals("N") || items[1].equals("S"))
                return true;
            else
                return false;
        }
        if (items.length == 3){
            if (isNumber(items[0]) && isNumber(items[1]))
                return false;
            if (items[2].equals("E") || items[2].equals("W") || items[2].equals("N") || items[2].equals("S"))
                return true;
            else
                return false;
        }
        return true;
    }

    private static boolean checkMovements(String str) {
        for (char c : str.toCharArray()) {
            if (c == 'M' || c == 'L' || c == 'R')
                return true;
            else
                return false;
        }
        return true;
    }

    public static boolean checkLines(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            lines = new String[ReadFile.getLinesCount(file)];

            for (int index = 0; (line = reader.readLine()) != null; index++){
                lines[index] = line;
            }

            if (lines[0] == null){
                return false;
            }
            if (lines.length > 3 || lines.length < 3){
                System.out.println("Invalid number of lines.");
                return false;
            }
            if (!checkGridSize(lines[0])){
                System.out.println(lines[0] + " not valid values.");
                return false;
            }
            if (!checkRoverCoordinatesAndDirections(lines[1])) {
                System.out.println(lines[1] + " not valid coordinates and or direction.");
                return false;
            }
            if (!checkMovements(lines[2])) {
                System.out.println(lines[2] + " not valid movements");
                return false;
            }

        } catch (IOException e) {
            System.out.println("Invalid file: " + e.getMessage());
        }
        return true;
    }
}
