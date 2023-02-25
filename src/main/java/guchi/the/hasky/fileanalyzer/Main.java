package guchi.the.hasky.fileanalyzer;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Input file name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileAnalyzer analyzer = new FileAnalyzer();

        String fileName = reader.readLine();
        if (analyzer.isFileExist(fileName)) {
            String path = analyzer.fileToString("c:/test/" + fileName + ".txt");
            String[] array = analyzer.stringToArray(path);
            System.out.println("Input some word: ");
            String word = reader.readLine();
            analyzer.getResult(array, word);
        } else {
            System.err.println("Error, wrong file name.");
        }


        }
    }

