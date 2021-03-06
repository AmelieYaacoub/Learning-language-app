package com.example.wikipedialanguage.Services;

import com.example.wikipedialanguage.Models.Language;

import org.json.JSONObject;


public class JSONParseService {

    public String GetFlatWikipediaText (Language.LanguageCode languageCode)
    {
        String extract = "";
        try {
            APIConnectivityService connection = new APIConnectivityService(languageCode); //New Instance of the class APIConnectivityService
            String con = connection.execute().get(); //Gets the String into a variable, here a String because you need to tell what exactly the variable is (a String)

            JSONObject objcon = new JSONObject(con); //Parsing the JSON String into a JSON Object

            extract = objcon.getString("extract"); //WikiApi calls the Textsection I need "extract"

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return extract;

        }

    }
}
