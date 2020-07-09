package com.example.wikipedialanguage.Services;


import com.example.wikipedialanguage.Models.Language;

public class CountryItem {
    private String mCountryName;
    private int mFlagImage; //integer for the flag images
    private Language.LanguageCode languageCode;
    //creating constructor, passing the values which are inside -> countryName and flagimage
    public CountryItem(String countryName, int flagImage, Language.LanguageCode code) {
        //and save them into the variables I have created -> Line 5 and 6
        mCountryName = countryName;
        mFlagImage = flagImage;
        languageCode = code;
    }

    //Getting the values out of the object by calling these methods -> getCountryName and getFlagImage:
    public String getCountryName() {
        return mCountryName;
    }
    public int getFlagImage() {
        return mFlagImage;
    }

    public Language.LanguageCode getLanguageCode() {
        return languageCode;
    }
}