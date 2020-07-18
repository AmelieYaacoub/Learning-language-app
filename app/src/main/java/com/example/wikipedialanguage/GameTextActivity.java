package com.example.wikipedialanguage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wikipedialanguage.Models.GameData;
import com.example.wikipedialanguage.Models.Language;
import com.example.wikipedialanguage.Services.CountryAdapter;
import com.example.wikipedialanguage.Services.CountryItem;
import com.example.wikipedialanguage.Services.SelectedWordsService;

import java.util.ArrayList;

//public class Subclass extends Superclass {}
//extends = The GameTextActivity class (subclass) inherits the attributes and methods from the AppCompatActivity class (superclass):
public class GameTextActivity extends AppCompatActivity {
    private Button button;

    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_text);


        //Spinner:
        initList();
        Spinner spinnerCountries = findViewById(R.id.spinner_countries);
        mAdapter = new CountryAdapter(this, mCountryList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getCountryName();
                //Toast.makeText()= A toast provides simple feedback on an event in a small pop-up window:
                Toast.makeText(GameTextActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
                textFunction(view, clickedItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //Connectivity:
    public void textFunction(View V) {
        textFunction(V, new CountryItem("English", R.drawable.button_language_en, Language.LanguageCode.EN));
    }

    public void textFunction(View V, CountryItem countryItem){
        SelectedWordsService callWordList = new SelectedWordsService(); //Calling the Class

        TextView mainText = (TextView) findViewById(R.id.textView3);

        TextView wordListView = (TextView) findViewById(R.id.wordList);

        GameData gameData = callWordList.GetWordsFromRandomText(countryItem.getLanguageCode());
        String res = String.join(",", gameData.getMissingWords());
        wordListView.setText(res);
        mainText.setText(gameData.get_GameTextWithBlanks());
        }


    public void GoBack(View V){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


    //Items for the Spinner:
    private void initList() {
        mCountryList = new ArrayList<>();
            mCountryList.add(new CountryItem("Português", R.drawable.button_language_pt, Language.LanguageCode.PT));
            mCountryList.add(new CountryItem("English", R.drawable.button_language_en, Language.LanguageCode.EN));
            mCountryList.add(new CountryItem("Français", R.drawable.button_language_fr, Language.LanguageCode.FR));
            mCountryList.add(new CountryItem("Deutsch", R.drawable.button_language_de, Language.LanguageCode.DE));
    }


}


