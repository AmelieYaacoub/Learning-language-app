package com.example.wikipedialanguage.Services;

import com.example.wikipedialanguage.Models.Language;

import java.util.HashMap;

public class LanguageManagementService {
    private HashMap<Language.LanguageCode, Language> languages; //A HashMap store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String)
    public LanguageManagementService(){
        //Creating a HashMap object called languages:
        languages = new HashMap<Language.LanguageCode, Language>();
        //Add keys and values with .put():
        languages.put(Language.LanguageCode.EN,new Language(Language.LanguageCode.EN, "English" ));
        languages.put(Language.LanguageCode.PT,new Language(Language.LanguageCode.PT, "Portugues" ));
        languages.put(Language.LanguageCode.FR,new Language(Language.LanguageCode.FR, "Francais" ));
        languages.put(Language.LanguageCode.DE,new Language(Language.LanguageCode.DE, "Deutsch" ));

    }

    public Language GetLanguageFromCode(Language.LanguageCode code){
        return languages.get(code);

    }
}
