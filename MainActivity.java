import android.app.Services;
import java.util;
import android.app.Activity;
import android.bluetooth.*;
import android.os.*;
import android.view.View;
import android.widget.Button;
import android.content.*;

public Class MainActivity extends Activity{
private bluetoothAdapter btAdapter;
private bluetoothManager btManager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_principale);
  
  
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
    }
      
      
    
        }
      });
        
        
  } 

  
}
