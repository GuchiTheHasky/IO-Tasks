package guchi.the.hasky.fileanalyzer;

import java.io.*;

public class Main {
    private static void printMenu() {
        System.out.println("Input:\n-> File path;\n-> Word;");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileAnalyzer analyzer = new FileAnalyzer();

        String str = "";
        String separator = File.separator;
        while (!analyzer.isFileExist(str)) {
            printMenu();
            /**
             * Recommended file name: TextOne.txt
             */
            str = "src" + separator + "main" + separator +
                    "java" + separator + "guchi" + separator +
                    "the" + separator + "hasky" + separator +
                    "fileanalyzer" + separator + "test" + separator +
                    reader.readLine();
            if (!analyzer.isFileExist(str)) {
                System.err.println("Try harder, wrong file name.");
            }
        }

        System.out.println("Word: ");
        String word = reader.readLine();

        String text = analyzer.fileToString(str);

        analyzer.getResult(text, word);


    }














//    public static void main(String[] args) throws IOException {
//        System.out.println("Input file name: ");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileAnalyzer analyzer = new FileAnalyzer();
//
//        String fileName = "src/main/java/guchi/the/hasky/fileanalyzer/test/TextOne.txt"; //reader.readLine();
//        if (analyzer.isFileExist(fileName)) {
//            String path = analyzer.fileToString(fileName);
//            String[] array = analyzer.stringToArray(path);
//            System.out.println("Input some word: ");
//            String word = reader.readLine();
//            analyzer.getResult(array, word);
//        } else {
//            System.err.println("Error, wrong file name.");
//        }
//
//
//        }
    }

