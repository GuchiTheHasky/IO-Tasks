package guchi.the.hasky.fileanalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {

    private FileAnalyzer analyzer;
    @BeforeEach
    void init(){
        analyzer = new FileAnalyzer();
    }

    @Test
    @DisplayName("Test, calculate words count.")
    public void testCalculateWordsCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FileAnalyzer.class.getDeclaredMethod("fileContent", String.class);
        method.setAccessible(true);
        String content = (String) method.invoke(analyzer, "Hello.txt");

        int expected = 9;
        int actual = analyzer.wordCount(content, "Hello");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test, throw exception message if file not found.")
    public void f() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expected = "Error code 404:\nWrong file name.";
        Method method = FileAnalyzer.class.getDeclaredMethod("fileContent", String.class);
        method.setAccessible(true);

        String actual = (String) method.invoke(analyzer, "Content.txt");

        assertEquals(expected, actual);
    }








}
