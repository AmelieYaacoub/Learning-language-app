package com.example.wikipedialanguage.Services;

import com.example.wikipedialanguage.Models.Language;

import java.util.HashMap;

public class LanguageManagementService {
    private HashMap<Language.LanguageCode, Language> languages;
    public LanguageManagementService(){
        languages = new HashMap<Language.LanguageCode, Language>();
        languages.put(Language.LanguageCode.EN,new Language(Language.LanguageCode.EN, "English" ));
        languages.put(Language.LanguageCode.PT,new Language(Language.LanguageCode.PT, "Portugues" ));
        languages.put(Language.LanguageCode.FR,new Language(Language.LanguageCode.FR, "Francais" ));
        languages.put(Language.LanguageCode.DE,new Language(Language.LanguageCode.DE, "Deutsch" ));

    }

    public Language GetLanguageFromCode(Language.LanguageCode code){
        return languages.get(code);

    }
}
