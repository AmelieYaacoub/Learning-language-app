package com.example.wikipedialanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wikipedialanguage.Services.Animal;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animal myAnimal = new Animal("Iris", 40, 1 , "brown");
        // globally
        TextView myAwesomeTextView = (TextView)findViewById(R.id.AnimalView);

        //in your OnCreate() method
        myAwesomeTextView.setText(myAnimal.Identify());
    }

    public void GoToGame(View V){
        Intent intent = new Intent(getBaseContext(), GameTextActivity.class);
        startActivity(intent);
    }

}
