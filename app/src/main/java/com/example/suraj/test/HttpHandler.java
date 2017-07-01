package com.example.suraj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Suraj on 7/1/2017.
 */

class HttpHandler {


     HttpHandler() {
    }

     String makeServiceCall(String reqUrl) {
        try {

            HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(reqUrl)).openConnection();
            httpURLConnection.setRequestMethod("GET");

            // read the response
            InputStream in = httpURLConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder sb = new StringBuilder();
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}


