package com.example.sarahemmanuels.scoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEpl(View view) {
        Intent Intent = new Intent(this, EplActivity.class);
        startActivity(Intent);
    }

    public void kenya(View view) {
        Intent Intent = new Intent(this, KenyaActivity.class);
        startActivity(Intent);
    }

    public void french(View view) {
        Intent Intent = new Intent(this, FrenchActivity.class);
        startActivity(Intent);
    }

    public void laLiga(View view) {
        Intent Intent = new Intent(this, LaligaActivity.class);
        startActivity(Intent);
    }

    public void bundesLeague(View view) {
        Intent Intent = new Intent(this, BundesLeagueActivity.class);
        startActivity(Intent);
    }

    public void wcup(View view) {
        Intent Intent = new Intent(this, WcupActivity.class);
        startActivity(Intent);
    }
}
