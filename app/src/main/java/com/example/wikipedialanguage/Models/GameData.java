package com.example.wikipedialanguage.Models;

import java.util.ArrayList;

public class GameData {

    private String _GameText;
    private String _GameTextWithBlanks;
    private ArrayList<String> _MissingWords;
    private ArrayList<Integer> _MissingWordsPositions;

    public GameData(String GameText){


        String[] arrOfStr = GameText.split(" "); //Split the String (the Text) and put it in an array (each word is a string now)


        ArrayList<String> arrOfSelectedWords = new ArrayList<String>(); //New List for the selected words
        ArrayList<Integer> arrOfPositions = new ArrayList<Integer>(); //New List for the positions of removed words

        while (arrOfSelectedWords.size() < 5){
            Integer randomPosition = (int) Math.floor(Math.random() * arrOfStr.length);
            while(arrOfPositions.contains(randomPosition)){
                randomPosition = (int) Math.floor(Math.random() * arrOfStr.length);
            }
            String randomItem = arrOfStr[randomPosition]; //Get random item of the array
            arrOfPositions.add(randomPosition);
            arrOfSelectedWords.add(randomItem); //add words to the list
            arrOfStr[randomPosition] = arrOfStr[randomPosition].replaceAll(".", "_");
        }

        setGameText(GameText);
        setMissingWords(arrOfSelectedWords);
        set_MissingWordsPositions(arrOfPositions);
        set_GameTextWithBlanks(String.join(" " , arrOfStr));

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

    public ArrayList<Integer> get_MissingWordsPositions() {
        return _MissingWordsPositions;
    }

    public void set_MissingWordsPositions(ArrayList<Integer> _MissingWordsPositions) {
        this._MissingWordsPositions = _MissingWordsPositions;
    }

    public String get_GameTextWithBlanks() {
        return _GameTextWithBlanks;
    }

    public void set_GameTextWithBlanks(String _GameTextWithBlanks) {
        this._GameTextWithBlanks = _GameTextWithBlanks;
    }
}
