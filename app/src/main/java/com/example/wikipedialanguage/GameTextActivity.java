package com.example.wikipedialanguage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wikipedialanguage.Models.GameData;
import com.example.wikipedialanguage.Services.APIConnectivityService;
import com.example.wikipedialanguage.Services.CountryAdapter;
import com.example.wikipedialanguage.Services.CountryItem;
import com.example.wikipedialanguage.Services.JSONParseService;
import com.example.wikipedialanguage.Services.SelectedWordsService;

import org.json.JSONObject;

import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class GameTextActivity extends AppCompatActivity {
    private Button button;

    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_text);

        textFunction(null);

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
                Toast.makeText(GameTextActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    //Connectivity:
    public void textFunction(View V) {
        APIConnectivityService APIConnection = new APIConnectivityService();
        SelectedWordsService callWordList = new SelectedWordsService(); //Calling the Class

        TextView mainText = (TextView) findViewById(R.id.textView3);

        TextView wordListView = (TextView) findViewById(R.id.wordList);

        GameData gameData = callWordList.GetWordsFromRandomText();
        String res = String.join(",", gameData.getMissingWords());
        wordListView.setText(res);
        mainText.setText(gameData.getGameText());
    }

    public void GoBack(View V){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


        //Items for the Spinner:
        private void initList() {
            mCountryList = new ArrayList<>();
            mCountryList.add(new CountryItem("Português", R.drawable.button_language_pt));
            mCountryList.add(new CountryItem("English", R.drawable.button_language_en));
            mCountryList.add(new CountryItem("Français", R.drawable.button_language_fr));
            mCountryList.add(new CountryItem("Deutsch", R.drawable.button_language_de));
        }

    
}
