package com.example.suraj.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Suraj on 7/1/2017.
 */

public class NetworkingDemo {

    private static String downloadFileFromInterNet(String url) throws JSONException {
        String strline = null;
        try {
            InputStream inputStream = new URL(url).openStream();

            // this will read in json format .
            // we have to convert it in string frmt.
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            strline = convertJsonToString(reader);
            System.out.println(strline);

        } catch (MalformedURLException e) {
            System.out.println("MF Exception");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return strline;
    }

    private static String convertJsonToString(BufferedReader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            stringBuilder.append(buffer);
        }
        return stringBuilder.toString();

    }


    public static void main(String args[]) throws JSONException {

        System.out.println(" Type any website Json File to Parse");

        //Scanner scanner = new Scanner(System.in);
        String jsonfile = downloadFileFromInterNet("http://samples.openweathermap        .org/data/2.5/weather?zip=94040,us&appid=b1b15e88fa797225412429c1c50c122a1");
        JSONObject jo = new JSONObject(jsonfile);
        JSONArray jsonArray = (JSONArray) jo.names();
        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.get(i) + "");//key
            System.out.println(jo.get(jsonArray.get(i).toString()));//values
        }

        try {
            FileReader fileReader = new FileReader("contact.txt");
            BufferedReader reader = new BufferedReader(new FileReader("contact.txt"));
            String line;
            while ( ( line = reader.ha()) != null ){
                String  str = reader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
