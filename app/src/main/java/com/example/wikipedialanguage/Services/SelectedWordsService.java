package com.example.wikipedialanguage.Services;


import com.example.wikipedialanguage.Models.GameData;
import com.example.wikipedialanguage.Models.Language;

import java.util.ArrayList;

public class SelectedWordsService {

        public GameData GetWordsFromRandomText (Language.LanguageCode languageCode) {

        JSONParseService parseService = new JSONParseService(); //Create new Instance

        String givenText = parseService.GetFlatWikipediaText(languageCode); //Calling the function, receiving the return of it and save it in a String Variable called text


            return new GameData(givenText);

    }
}
