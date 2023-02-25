package guchi.the.hasky.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileManager {

    public static void copyOne(String from, String to) throws IOException {
        File fileFrom = new File(from);
        File fileTo = new File(to);

        try (FileInputStream in = new FileInputStream(fileFrom);
             FileOutputStream out = new FileOutputStream(fileTo)) {

            byte[] buffer = new byte[(int)fileFrom.length()];
            while (in.available() != -1){

            }
        }
    }

    public static int countFiles(File directory) { //Вивели всі файли в директорії
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

    public static int countPackage(File directory) {
        int count = 0;
        for (File pack : directory.listFiles()) {
            if (pack.isDirectory()) {
                count++;
            }
            if (pack.isAbsolute()) {
                count += countPackage(directory);
            }
        }
        return count;
    }

    public static int countPackages(String path) { // вивели всі директорії і директорії в них
        File file = new File(path);
        int count = 0;
        if (file.isAbsolute()) {
            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()) {
                    count++;
                    count += countPackages(file1.getAbsolutePath());
                }
            }
        }
        return count;
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

}
