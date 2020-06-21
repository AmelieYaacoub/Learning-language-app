package com.example.wikipedialanguage.Services;


import com.example.wikipedialanguage.Models.GameData;

import java.util.ArrayList;

public class SelectedWordsService {

        public GameData GetWordsFromRandomText () {

        JSONParseService parseService = new JSONParseService(); //Create new Instance

        String givenText = parseService.GetFlatWikipediaText(); //Calling the function, receiving the return of it and save it in a String Variable called text

        String[] arrOfStr = givenText.split(" "); //Split the String (the Text) and put it in an array (each word is a string now)


        ArrayList<String> arrOfSelectedWords = new ArrayList<String>(); //New List for the selected words

           while (arrOfSelectedWords.size() < 5){
               String randomItem = arrOfStr[(int) Math.floor(Math.random() * arrOfStr.length)]; //Get random item of the array
               arrOfSelectedWords.add(randomItem); //add words to the list
           }

            return new GameData(givenText,arrOfSelectedWords);

    }
}
