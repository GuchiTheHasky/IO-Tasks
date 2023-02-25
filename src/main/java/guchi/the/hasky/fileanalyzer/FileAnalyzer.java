package guchi.the.hasky.fileanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class FileAnalyzer {
    private final Pattern pattern = Pattern.compile("[.?!]");

    public void getResult(String[] array, String word) {
        int count = 0;
        List<String> list = new ArrayList<>();
        for (String s : array) {
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i)) && Character.isLetter(s.charAt(i))) {
                    temp += s.charAt(i);
                } else if (s.charAt(i) == ' ') {
                    temp = "";
                }
                if (temp.equalsIgnoreCase(word)) {
                    count++;
                    list.add(s);
                    temp = "";
                }
            }
        }
        System.out.println("Word count: " + count);
        for (String str : list) {
            System.out.println(str);
        }
    }

    public String[] stringToArray(String str) {
        String[] array;
        return array = str.split(String.valueOf(pattern));
    }

    public String fileToString(String path) {
        File file = new File(path);
        if (file.exists()) {
            try (FileInputStream input = new FileInputStream(file)) {
                int length = (int) file.length();
                byte[] bytes = new byte[length];
                while (input.read(bytes) != -1) {
                    return new String(bytes, StandardCharsets.UTF_8);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private static String printEx(){
        return "Error, wrong file name.";
    }

    public boolean isFileExist(String s){
        return new File("c:/test/" + s + ".txt").exists();
    }


    /*
    *
    public static String inputNameFromDisk(BufferedReader reader) throws IOException {
        System.out.println("Input file name: ");
        return "c:/test/" + reader.readLine();
    }

    public static String inputNameFromPackege(BufferedReader reader) throws IOException {
        System.out.println("Input file name: ");
        return reader.readLine();
    }
    *
    *
    *    public String fromFileToString(File file) throws IOException {
        FileInputStream reader = new FileInputStream(file);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while ((i = reader.read()) != -1) {
            builder.append((char) i);
        }
        return builder.toString();
    }

    public String readFile() throws IOException {
        File file = new File(path);
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(path)) {
                StringBuilder builder = new StringBuilder();
                int i = 0;
                while ((i = in.available()) != -1) {
                    builder.append((char) i);
                }
                return builder.toString();
            }
        }
        return "File, doesn't exist";
    }
    *
    *     public static int getDuplicateWordCount(String str, String word) {
        String[] temp = str.split(" ");
        int count = 0;
        for (String string : temp) {
            String s = "";
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isDigit(string.charAt(i)) && Character.isLetter(string.charAt(i))) {
                    s += string.charAt(i);
                }
                if (s.equalsIgnoreCase(word)) {
                    count++;
                    s = "";
                }
            }
        }
        return count;
    }*/




}
/*Используем классы FileInputStream, FileOutputStream, File
Практика:
1: Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:
1) путь к файлу
2) слово
Usage:
java FileAnalyzer C:/test/story.txt duck

Выводит:
1) Кол-во вхождений искомого слова в файле
2) Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!").
Каждое предложение выводится с новой строки.


*/
