package com.example.desarrollomobile_tp1_grupo17;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ModoAvionReceiver eventoModoAvion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventoModoAvion = new ModoAvionReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(eventoModoAvion, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(eventoModoAvion);
    }

}