package com.emmmer.killer;

import java.io.*;
import java.util.Arrays;

public class getQuestion {
    public static int lineNumbers(String filename) {
        String temp = null;
        File txtFile = new File(filename);
        int position = 0;
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(txtFile));
            temp = bufReader.readLine();
            while (temp != null) {
                temp = bufReader.readLine();
                position++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return position;
    }


    public static String readByLines(String filename, int line) {
        String tempString = null;
        File danmakuFile = new File(filename);
        try (BufferedReader bufReader = new BufferedReader(new FileReader(danmakuFile))) {
            int position = 0;
            while (position != line) {
                tempString = bufReader.readLine();
                position++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempString;
    }


    public static String[] outPut(String filename) {
        var random = Math.random();
        random *= (lineNumbers(filename) + 1);
        var ordinaryQuestion = readByLines(filename, (int) random);
        return ordinaryQuestion.split(":", 3);
    }


    public static void main(String[] args) {
        System.out.println(lineNumbers("file.txt"));
        var out = outPut("file.txt");
        System.out.println(Arrays.toString(out));
    }
}
