package guchi.the.hasky.fileanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class FileAnalyzer {
    public boolean isFileExist(String s) {
        return new File(s).exists();
    }

    public String fileToString(String path) {
        File file = new File(path);
        try (FileInputStream input = new FileInputStream(file)) {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            while (input.read(bytes) != -1) {
                return new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public void getResult(String str, String word) {
        StringTokenizer tokenizer = new StringTokenizer(str, "[.?!\n]");
        int count = 0;
        Set<String> list = new HashSet<>();
        try {
            while (tokenizer.hasMoreTokens()) {
                String[] words = tokenizer.nextToken().split(" ");
                for (String s : words) {
                    if (s.equalsIgnoreCase(word)) {
                        count++;
                        list.add(Arrays.toString(words));
                    }
                }
            }
        } catch (Throwable ignored) {
        }
        System.out.printf("Count of: \"%s\" \nis: %d.\n", word, count);
        for (String s : list) {
            System.out.println(s);
        }

    }
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
