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
import com.example.wikipedialanguage.Services.JSONParseService;
import com.example.wikipedialanguage.Services.SelectedWordsService;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class GameTextActivity extends AppCompatActivity {
    private Button button;
    Toolbar toolbar;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_text);

        APIConnectivityService APIConnection = new APIConnectivityService();
        SelectedWordsService callWordList = new SelectedWordsService(); //Calling the Class

      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        TextView mainText = (TextView)findViewById(R.id.textView3);




        TextView wordListView = (TextView)findViewById(R.id.wordList);

        GameData gameData = callWordList.GetWordsFromRandomText();
        String res = String.join(",", gameData.getMissingWords());
        wordListView.setText(res);
        mainText.setText(gameData.getGameText());



    }
    public void GoBack(View V){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


    
}
