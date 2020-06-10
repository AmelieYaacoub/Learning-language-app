package com.example.wikipedialanguage.Services;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnectivityService  extends AsyncTask<String,String,String> {
    private String GetFlatWikipediaText(){
        try{
            URL url = new URL("https://en.wikipedia.org/api/rest_v1/page/random/summary");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }catch(IOException E){
            return "Connection error";
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return GetFlatWikipediaText();
    }
}
