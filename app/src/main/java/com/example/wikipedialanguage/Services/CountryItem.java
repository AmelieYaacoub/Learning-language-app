package com.example.wikipedialanguage.Services;


public class CountryItem {
    private String mCountryName;
    private int mFlagImage; //integer for the flag images

    //creating constructor, passing the values which are inside -> countryName and flagimage
    public CountryItem(String countryName, int flagImage) {
        //and save them into the variables I have created -> Line 5 and 6
        mCountryName = countryName;
        mFlagImage = flagImage;
    }

    //Getting the values out of the object by calling these methods -> getCountryName and getFlagImage:
    public String getCountryName() {
        return mCountryName;
    }
    public int getFlagImage() {
        return mFlagImage;
    }
}