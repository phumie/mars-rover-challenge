package filereader;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReadFileTest {

    private ReadFile readFile;

    @Before
    public void init() {
        readFile = new ReadFile();
    }

    @Test
    public void validFileReaderTest() throws Exception {
        boolean result = ReadFile.doesFileExist("./commands.txt");
        assertTrue("File exists", result);
    }

    @Test
    public void invalidFileReaderTest() throws Exception {
        boolean result = ReadFile.doesFileExist(" ");
        assertFalse("Error reading file", result);
    }


    @Test
    public void emptyileEmptyTest() {
        int result = ReadFile.isFileEmpty("./commands.txt");
        assertEquals("File is empty", 3, result);
    }

    @Test
    public void invalidFileNumberOfLinesTest() {
        int num = ReadFile.getLinesCount("./commands.txt");
        assertEquals("Invalid number of lines in file", 3, num);
    }
}
