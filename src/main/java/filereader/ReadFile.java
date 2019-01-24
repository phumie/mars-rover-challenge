package filereader;

import coordinates.Coordinates;

import java.io.*;
import java.io.BufferedReader;

public class ReadFile {

    private static String[] lines = null;

    public ReadFile() {
        lines = readFile("../../../../commands.txt");
    }

    public static boolean doesFileExist(String fileName) throws Exception {
        boolean check = new File(fileName).exists();

        if (check == true)
            return true;
        return false;
    }

    public static int isFileEmpty(String fileName) {
        return getLinesCount(fileName);
    }

    public static int getLinesCount(String fileName){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int lines = 0;
            while (reader.readLine() != null) 
                lines++;
            reader.close();

            return lines;
		}
		catch (IOException ioe){
			ioe.getMessage();
		}
		return 0;
	}


    public static String[] readFile(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            lines = new String[getLinesCount(file)];

            for (int index = 0; (line = reader.readLine()) != null; index++){
                lines[index] = line;
            }

            reader.close();
            return lines;
        }
        catch (FileNotFoundException e){
            System.out.println("Error openening file: '" + file + "'.");
        }
        catch (IOException e) {
            System.out.println("Error reading file: '" + file + "'.");
        }

        return null;
    }

    public static Coordinates getGridSize() {
        Coordinates gridSize = new Coordinates(Integer.parseInt(lines[0].split(" ")[0]),
                Integer.parseInt(lines[0].split(" ")[1]));
        return gridSize;
    }

    public static Coordinates getRoverCoordinates() {
        int num = Integer.parseInt(String.valueOf(lines[1].split(" ").length));
        Coordinates roverCoordinates;

        if (num == 3){
            roverCoordinates = new Coordinates(Integer.parseInt(lines[1].split(" ")[0]),
                    Integer.parseInt(lines[1].split(" ")[1]));
        }
        else
            roverCoordinates = new Coordinates(Integer.parseInt(String.valueOf((lines[1].split(" ")[0].charAt(0)))),
                    Integer.parseInt(String.valueOf((lines[1].split(" ")[0].charAt(1)))));

        return roverCoordinates;
    }

    public static char getRoverDirection() {
        int num = Integer.parseInt(String.valueOf(lines[1].split(" ").length));

        if (num == 3)
            return (lines[1].split(" ")[2]).charAt(0);
        else
            return (lines[1].split(" ")[1]).charAt(0);

    }

    public static String getRoverMovement() {
        return lines[2];
    }
}
