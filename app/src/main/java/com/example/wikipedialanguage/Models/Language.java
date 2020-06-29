package com.example.wikipedialanguage.Models;

public class Language {

    public enum LanguageCode { //enum = enumerate
        EN, PT, FR, DE
    };


    public LanguageCode get_WPCode() {
        return _WPCode;
    }

    public void set_WPCode(LanguageCode _WPCode) {
        this._WPCode = _WPCode;
    }

    public String get_Description() {
        return _Description;
    }

    public void set_Description(String _Description) {
        this._Description = _Description;
    }


    private LanguageCode _WPCode; //Attribute
    private String _Description; //Attribute

    public Language(LanguageCode Code, String Description){ //Constructor
        _WPCode = Code;
        _Description = Description;

    }
}
