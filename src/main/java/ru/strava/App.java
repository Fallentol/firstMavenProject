package ru.strava;

import dataBase.DataBase;
import org.json.JSONArray;
import org.json.JSONObject;
import sObjects.SObject;

import java.io.IOException;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!!");


    }

    public static String test1(String serverJSON) {
        System.out.println("start test");
        DataBase.INSTANCE.mainSObjectMap = new HashMap<String, SObject>();
        long begin = System.currentTimeMillis();

        try {

            JSONObject serverJSONObject = new JSONObject(serverJSON);
            JSONArray recordsArray = serverJSONObject.getJSONArray("records");
            System.out.println("array size=" + recordsArray.length());



            for (int k = 0; k < 5; k++) {
                for (int i = 0; i < recordsArray.length(); i++) {
                    SObject test = SObject.createNewSObjectFromJSONString(recordsArray.getJSONObject(i).toString());
                }
            }

        } catch (Exception e) {
            System.out.println("Exception TEST!: " + e.getMessage());
        }
        System.out.println("Total = " + DataBase.INSTANCE.mainSObjectMap.size());
        System.out.println("Total Time:" + (System.currentTimeMillis() - begin));

        String result = "Total = " + DataBase.INSTANCE.mainSObjectMap.size() + " || " + "Total Time:" + (System.currentTimeMillis() - begin);

        return result;
    }

    public static String PORT = System.getenv("PORT");
    /*String host = "0.0.0.0";
    int port = System.getenv("PORT");*/


    public static int th = 9;
}
