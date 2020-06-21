package com.example.wikipedialanguage.Models;

import java.util.ArrayList;

public class GameData {

    private String _GameText;
    private ArrayList<String> _MissingWords;

    public GameData(String GameText , ArrayList<String> MissingWords){
        setGameText(GameText);
        setMissingWords(MissingWords);

    }

    public String getGameText() {
        return _GameText;
    }

    public void setGameText(String gameText) {
        _GameText = gameText;
    }

    public ArrayList<String> getMissingWords() {
        return _MissingWords;
    }

    public void setMissingWords(ArrayList<String> _MissingWords) {
        this._MissingWords = _MissingWords;
    }
}
