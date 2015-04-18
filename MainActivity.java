import android.app.Services;
import java.util;
import android.app.Activity;
import android.bluetooth.*;
import android.os.*;
import android.view.View;
import android.widget.Button;


public Class MainActivity extends Activity{
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_principale);


    // Setup the Scanning button
    final Button buttAdd = (Button) findViewById(R.id.button);
    buttAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(final View v) {
      // action à exectuter
      
        }
      });
        
        
  } 

  
}
