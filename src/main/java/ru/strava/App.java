package ru.strava;

import auxiliary.UtilsJSON;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!!");

        UtilsJSON.getTest();

    }

    public static String PORT = System.getenv("PORT");
    /*String host = "0.0.0.0";
    int port = System.getenv("PORT");*/


    public static int th = 9;
}
