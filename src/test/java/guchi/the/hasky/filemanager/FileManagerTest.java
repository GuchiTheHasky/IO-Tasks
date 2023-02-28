package guchi.the.hasky.filemanager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagerTest {

    FileManager manager = new FileManager();
    File path = new File("src/main/java/guchi/the/hasky/filemanager/test");


    @Test
    @DisplayName("Test, count all files in directory.")
    public void testCountFilesInRootDirectory() {
       int actual = manager.countFiles(path);
       assertEquals(39, actual);
    }

    @Test
    @DisplayName("Test, count all directories in directory.")
    public void testCountDirectoriesInRootDirectory() {
       int actual = manager.countDirs(path);
       assertEquals(44, actual);
    }

    @Test
    @DisplayName("Test, copy file to directory: true")
    public void testCorySourceFileToSomeDirectoryTrue(){

    }
    @Test
    @DisplayName("Test, copy file to directory: false")
    public void testCorySourceFileToSomeDirectoryFalse() throws IOException {
        String from = "src/main/java/guchi/the/hasky/filemanager/test/aaa.txt";
        String to = "src/main/java/guchi/the/hasky/filemanager/test/testtwo/testeight/lll.txt";
        File source = new File(from);
        File directory = new File(to);



    }
}
