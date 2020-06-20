package com.example.wikipedialanguage.Services;

public class SelectedWordsService {

    public String GetWordsFromRandomText () {

        JSONParseService parseService = new JSONParseService(); //Create new Instance

        String givenText = parseService.GetFlatWikipediaText(); //Calling the function, receiving the return of it and save it in a String Variable called text

        String[] arrOfStr = givenText.split(" "); //Split the String (the Text) and put it in an array (each word is a string now)

        String randomItem = arrOfStr[(int) Math.floor(Math.random() * arrOfStr.length)]; //Get random item of the array


    }
}
