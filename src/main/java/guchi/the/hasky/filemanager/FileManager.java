package guchi.the.hasky.filemanager;

import java.io.*;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

public class FileManager {
    public static void main(String[] args) throws IOException {
        FileManager manager = new FileManager();
        File path = new File("src/main/java/guchi/the/hasky/filemanager/test");

        int countFiles = manager.countFiles(path);
        System.out.println("Files count: " + countFiles);

        int countDirectories = manager.countDirs(path);
        System.out.println("Dirs count: " + countDirectories);

        String from = "src/main/java/guchi/the/hasky/filemanager/test/aaa.txt";
        String to = "src/main/java/guchi/the/hasky/filemanager/test/testtwo/testeight/lll.txt";
        File source = new File(from);
        File directory = new File(to);
        manager.copy(from, to);

        copyAll("src/main/java/guchi/the/hasky/filemanager/test",
                "src/main/java/guchi/the/hasky/filemanager/test/testtwo/testeight/apachi");

        move("src/main/java/guchi/the/hasky/filemanager/test/aaa.txt",
          "src/main/java/guchi/the/hasky/filemanager/test/testtwo/testeight/aaa.txt");

        moveAll("src/main/java/guchi/the/hasky/filemanager/test/testtwo/testeight/apachi",
                "src/main/java/guchi/the/hasky/filemanager/test/nine/apachi");


    }

    public int countFiles(File directory) {
        int count = 0;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                count += countFiles(file);
            }
            if (file.isFile()) {
                count++;
            }
        }
        return count;
    }

    public int countDirs(File path) {
        int count = 0;
        if (path.isDirectory()) {
            for (File file : Objects.requireNonNull(path.listFiles())) {
                if (file.isDirectory()) {
                    count++;
                    count += countDirs(file);
                }
            }
        }
        return count;
    }

    public void copy(String source, String destination) throws IOException {
        File file = new File(source);
        File dest = new File(destination);
        if (dest.exists() || file.exists()) {
            System.err.println("Error, incorrect source or destination file.");
        } else {
            try (FileInputStream input = new FileInputStream(file);
                 FileOutputStream output = new FileOutputStream(dest)) {

                int size = source.length();
                byte[] buffer = new byte[size];
                int length;
                while ((length = input.read(buffer)) != -1) {
                    output.write(buffer, 0, length);
                    System.out.println("Operation, success.");
                }
            }
        }
    }

    public static void copyAll(String source, String destination) throws IOException {
        File from = new File(source);
        File to = new File(destination);
        if (to.listFiles() == null) {
            FileUtils.copyDirectory(from, to);
            System.out.println("Operation, success.");
        } else {
            System.err.println("Error, destination file, already exist.");
        }
    }

    public static void move(String source, String destination) throws IOException {
        File from = new File(source);
        File to = new File(destination);
        if (to.exists()) {
            System.err.println("Error, destination file, already exist.");
        } else {
            FileUtils.moveFile(from, to);
            System.out.println("Operation, success.");
        }
    }

    public static void moveAll(String source, String destination) throws IOException {
        File from = new File(source);
        File to = new File(destination);
        if (to.listFiles() == null) {
            FileUtils.moveDirectory(from, to);
            System.out.println("Operation, success.");
        } else {
            System.err.println("Error, destination file, already exist.");
        }
    }



}









    /*2: Пишем class FileManager с методами
public class FileManager {
// public static int countFiles(String path) - принимает путь к папке,
// возвращает количество файлов в папке и всех подпапках по пути
public static int countFiles(String path) {
return 0;
}

// public static int countDirs(String path) - принимает путь к папке,
// возвращает количество папок в папке и всех подпапках по пути
public static int countDirs(String path) {
return 0;
}
}

public static void copy(String from, String to) - метод по копированию папок и файлов.
Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
public static void move(String from, String to) - метод по перемещению папок и файлов.
Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.*/


