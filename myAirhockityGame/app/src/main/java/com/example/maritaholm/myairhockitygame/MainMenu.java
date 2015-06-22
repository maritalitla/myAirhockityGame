package com.example.maritaholm.myairhockitygame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainMenu extends Activity {
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


        //Sets up shared preferences and puts in default setting values
        prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        final MediaPlayer playSoundButtonTouch = MediaPlayer.create(getApplicationContext(),R.raw.menutouch);

        //Sets up buttons
        final Button startButton = (Button) findViewById(R.id.quickgamebutton);
        final Button outOf3Button = (Button) findViewById(R.id.outof3button);
        final Button settingsButton = (Button) findViewById(R.id.settingsbutton);
        final Button quitButton = (Button) findViewById(R.id.quitbutton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefs.getBoolean("sound",true)){
                    playSoundButtonTouch.start();
                }
                Intent quickGame = new Intent(MainMenu.this, Game.class);
                startActivity(quickGame);
            }
        });

        outOf3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSoundButtonTouch.start();
                //Sets the bestOutOf3 mode to true to identify that a best out of 3 game is started
                prefs.edit().putBoolean("bestOutOf3", true).apply();
                Intent outOf3Game = new Intent(MainMenu.this, Game.class);
                startActivity(outOf3Game);
                //Sets the bestOutOf3 mode to true to identify that a best out of 3 game is started.
                prefs.edit().putBoolean("bestOutOf3", true).commit();
                if (prefs.getBoolean("sound",true)){
                    playSoundButtonTouch.start();
                }
                Intent outof3Game = new Intent(MainMenu.this, Game.class);
                startActivity(outof3Game);


            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //For starting settings
                Intent settings = new Intent(MainMenu.this,Settings.class);
                if (prefs.getBoolean("sound",true)){
                    playSoundButtonTouch.start();
                }
                startActivity(settings);
            }
        });

        //Quit game
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }





}
