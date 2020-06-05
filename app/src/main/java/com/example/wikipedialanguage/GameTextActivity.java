package com.example.wikipedialanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wikipedialanguage.Services.APIConnectivityService;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class GameTextActivity extends AppCompatActivity {
    private Button button;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_text);

        APIConnectivityService APIConnection = new APIConnectivityService();


      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TextView mainText = (TextView)findViewById(R.id.textView3);

        try {
            String something = APIConnection.execute().get();
            mainText.setText(something);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
    public void GoBack(View V){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


    
}
