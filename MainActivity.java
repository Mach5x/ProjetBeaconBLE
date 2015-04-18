package com.example.boutheina.projettest1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.bluetooth.*;
import android.os.*;
import android.view.View;
import android.widget.Button;
import android.content.*;

public class MainActivity extends Activity {
    private BluetoothAdapter btAdapter;
    private BluetoothManager btManager;

    private static final int REQUEST_ENABLE_BT=1;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//obtenir l'appareil qui possède le bluetooth LE et demande à l'activer si l'appareil est déconnecté
            btManager = (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
            btAdapter = btManager.getAdapter();
            if (btAdapter != null && !btAdapter.isEnabled()) {
                Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableIntent,REQUEST_ENABLE_BT);
            }
// Setup the Scanning button
            final Button buttAdd = (Button) findViewById(R.id.button);
            buttAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
// action à exectuter
//lance la recherche d'appareils
                    btAdapter.startLeScan(leScanCallback);
//arrête la recherche d'appareils
                    btAdapter.stopLeScan(leScanCallback);
//fonction qui est implémenté à chaque fois qu'un nouvel appareil est découvert
                    private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
                        @Override
                        public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
// your implementation here
                        }
                    };
                }
            });
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
