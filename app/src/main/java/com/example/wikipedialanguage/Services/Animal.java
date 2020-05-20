package com.example.wikipedialanguage.Services;

import java.util.UUID;

public class Animal {
    private int _weight;
    private int _height;
    private String _color;
    private String _name;
    private UUID _ChipIdentificationNumber;
    public Animal(String name, int weight, int height, String color){
        _name = name;
        _weight = weight;
        _height = height;
        _color = color;
        _ChipIdentificationNumber = UUID.randomUUID();
    }
    public String Identify(){
        return "I am " +_name + " I weigh " + _weight +  "and my chip is " + _ChipIdentificationNumber.toString();
    }
}
