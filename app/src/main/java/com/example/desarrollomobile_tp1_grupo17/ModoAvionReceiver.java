package com.example.desarrollomobile_tp1_grupo17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean modoAvionOn = intent.getBooleanExtra("state", false);

            if (modoAvionOn) {
                Toast.makeText(context, "Modo Avión ACTIVADO", Toast.LENGTH_SHORT).show();

                Intent intentLlamada = new Intent(Intent.ACTION_DIAL);

                intentLlamada.setData(Uri.parse("tel:2664553747"));
                intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intentLlamada);

            } else {
                Toast.makeText(context, "Modo Avión DESACTIVADO", Toast.LENGTH_SHORT).show();
            }
        }
    }
}