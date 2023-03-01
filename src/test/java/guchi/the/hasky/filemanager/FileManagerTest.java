package guchi.the.hasky.filemanager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {

    FileManager manager = new FileManager();

    String path = "src/main/java/guchi/the/hasky/filemanager/test";
    String wrongPath = "src/main/java/guchi/the/hasky/filemanager/task";
    String to = "src/test/java/guchi/the/hasky/three";


    @Test
    @DisplayName("Test, count all files in directory.")
    public void testCountFilesInSourceDirectory() throws FileNotFoundException {
        int actual = manager.countFiles(path);
        assertEquals(41, actual);
    }

    @Test
    @DisplayName("Test, throw exception in count files method.")
    public void testCountFilesInSourceDirectoryAndThrowException() {
        Throwable thrown = assertThrows(FileNotFoundException.class, () -> {
            manager.countFiles(wrongPath);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Test, count all packages in source directory.")
    public void testCountPackagesInSourceDirectory() throws FileNotFoundException {
        int actual = manager.countDirs(path);
        assertEquals(44, actual);
    }

    @Test
    @DisplayName("Test, count all packages in source directory and throw exception.")
    public void testCountPackagesInSourceDirectoryAndThrowException() {
        Throwable thrown = assertThrows(FileNotFoundException.class, () -> {
            manager.countDirs(wrongPath);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Test, copy file to directory: true")
    public void testCorySourceFileToSomeDirectoryTrue() throws FileNotFoundException {
        String source = "src/test/java/guchi/the/hasky/tests/one/one.txt";
        String directory = "src/test/java/guchi/the/hasky/tests/two/two.txt";
        manager.copy(source, directory);
        File file = new File(directory);
        assertTrue(file.length() > 0);
    }

    @Test
    @DisplayName("Test, copy file to directory: false")
    public void testCopySourceFileToSomeDirectoryFalse() {
        String source = "src/test/java/guchi/the/hasky/one/Q.txt";
        String directory = "src/test/java/guchi/the/hasky/two/E.txt";
        Throwable thrown = assertThrows(FileNotFoundException.class, () -> {
            manager.copy(source, directory);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Test, copy all files to directory: true")
    public void testCopyAllFilesFromSourceToSomeDirectoryTrue() throws FileNotFoundException {
        String sourceFile = "src/test/java/guchi/the/hasky/tests/one";
        String directoryFile = "src/test/java/guchi/the/hasky/tests/three";

        int before = Objects.requireNonNull(new File(directoryFile).listFiles()).length;
        manager.copyAll(sourceFile, directoryFile);
        int after = Objects.requireNonNull(new File(directoryFile).listFiles()).length;

        assertTrue(before < after);
    }

    @Test
    @DisplayName("Test, copy all files to directory: throw exception")
    public void testCopyAllFilesFromSourceToSomeDirectoryThrowException() {
        String source = "src/test/java/guchi/the/hasky/tests/non";
        String directory = "src/test/java/guchi/the/hasky/tests/three";

        Throwable thrown = assertThrows(FileNotFoundException.class, () -> {
            manager.copyAll(source, directory);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Test, move file to directory & delete file in source")
    public void testMoveFileFromSourceToSomeDirectory() throws FileNotFoundException {
        String source = "src/test/java/guchi/the/hasky/tests/four/m.txt";
        String directory = "src/test/java/guchi/the/hasky/tests/five/m.txt";

        manager.move(source, directory);
        File file = new File(source);
        assertFalse(file.exists());
        File nextFile = new File(directory);
        assertTrue(nextFile.exists());
    }

    @Test
    @DisplayName("Test, move file to directory & delete file in source, throw exception.")
    public void testMoveFileFromSourceToSomeDirectoryThrowException() {
        String source = "src/test/java/guchi/the/hasky/three/Q.txt";
        String directory = "src/test/java/guchi/the/hasky/four/P.txt";

        Throwable thrown = assertThrows(FileNotFoundException.class, () -> {
            manager.copyAll(source, directory);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Test, move all files to directory: throw exception")
    public void testMoveAllFileFromSourceToSomeDirectory() throws FileNotFoundException {
        String source = "src/test/java/guchi/the/hasky/tests/three/moveall";
        String directory = "src/test/java/guchi/the/hasky/tests/three/moveto";
        File from = new File(source);
        manager.moveAll(source, directory);
        assertFalse(from.exists());

        File to = new File(directory);
        assertTrue(Objects.requireNonNull(to.listFiles()).length > 0);
    }


}
