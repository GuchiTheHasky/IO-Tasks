package guchi.the.hasky.fileanalyzer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {

    FileAnalyzer analyzer = new FileAnalyzer();

    @DisplayName("Test, is file.txt exist? True/False.")
    @Test
    public void testFileExistTrueFalse(){
        boolean resultTrue = analyzer.isFileExist("Hello");
        assertTrue(resultTrue);

        boolean resultFalse = analyzer.isFileExist("ByeBye");
        assertFalse(resultFalse);
    }
    @DisplayName("Test, convert path to String, work correctly.")
    @Test
    public void testFileToStringReturnString(){
        String strTest = analyzer.fileToString("c:/test/Hello.txt");
        assertNotNull(strTest);
    }

    @DisplayName("Test, convert path to String, don't work correctly.")
    @Test
    public void testFileToStringReturnNull(){
        String strTest = analyzer.fileToString("c:/test/ByeBye.txt");
        assertNull(strTest);
    }

    @DisplayName("Test, convert String to Array, work correctly.")
    @Test
    public void testConvertStringToArray(){
        String text = analyzer.fileToString("c:/test/Hello.txt");
       // String[] array = analyzer.stringToArray(text);
       // assertTrue(array.length > 0);
    }





}
