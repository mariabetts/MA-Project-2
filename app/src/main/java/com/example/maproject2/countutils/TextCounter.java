package com.example.maproject2.countutils;

public class TextCounter {
    public static int getcharcount(String textl) {
        return textl.length();
    }

    public static int getwordcount(String wordl) {
        String[] sentence = wordl.split("\\W");
        return sentence.length;
    }
}






