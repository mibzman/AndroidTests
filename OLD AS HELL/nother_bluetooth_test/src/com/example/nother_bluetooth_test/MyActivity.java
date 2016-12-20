package com.example.nother_bluetooth_test;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.w3c.dom.Text;

import java.util.Set;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final int REQUEST_ENABLE_BT = 1;
    	   private Button onBtn;
    	   private Button offBtn;
    	   private Button listBtn;
    	   private Button findBtn;
    	   private TextView text;
    	   private BluetoothAdapter myBluetoothAdapter;
    	   private Set<BluetoothDevice> pairedDevices;
    	   private ListView myListView;
    	   private ArrayAdapter<String> BTArrayAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(myBluetoothAdapter == null){
            onBtn.setEnabled(false);
            offBtn.setEnabled(false);
            listBtn.setEnabled(false);
            text.setText("status: not supported");
            Toast.makeText(getApplicationContext(), "your device is an FFF!", Toast.LENGTH_LONG).show();
        }else{
            text = (TextView) findViewById(R.id.text);
            onBtn = (Button)findViewById(R.id.On);
            onBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    on(v);
                }
            });
            offBtn = (Button) findViewById(R.id.Off);
            offBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    off(v);
                }
            });
            listBtn = (Button) findViewById(R.id.list);
            listBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list(v);
                }
            });
            Button findBtn = (Button) findViewById(R.id.find);
            findBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    find(v);
                }
            });
        }
    }
        public void on(View view){
        if (!myBluetoothAdapter.isEnabled()){
            Intent turnOnIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOnIntent, REQUEST_ENABLE_BT);
             Toast.makeText(getApplicationContext(), "turning on", Toast.LENGTH_LONG).show();
        }   else {
            Toast.makeText(getApplicationContext(), "already on", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
       if (requestCode == REQUEST_ENABLE_BT){
           if (myBluetoothAdapter.isEnabled()){
           text.setText("enabled");
       }else {
           text.setText("disabled");
           }
       }
    }
    final BroadcastReceiver bReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
                    if (BluetoothDevice.ACTION_FOUND.equals(action)){
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        TextView thingy = (TextView) findViewById(R.id.longe);
                        thingy.setText(device.getName() + "\n" + device.getAddress());
                    }
        }
    }  ;
    public void list(View view){
        	      // get paired devices
        	      pairedDevices = myBluetoothAdapter.getBondedDevices();

        	      // put it's one to the adapter
        	      for(BluetoothDevice device : pairedDevices)
            	          BTArrayAdapter.add(device.getName()+ "\n" + device.getAddress());

        	      Toast.makeText(getApplicationContext(),"Show Paired Devices",
                	              Toast.LENGTH_SHORT).show();

       	   }
    public void find(View view){
        if(myBluetoothAdapter.isDiscovering()){
            myBluetoothAdapter.cancelDiscovery();
        } else {
            BTArrayAdapter.clear();
            myBluetoothAdapter.startDiscovery();
            registerReceiver(bReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));

        }

    }
    public void off (View view)        {
        myBluetoothAdapter.disable();
        text.setText("disconnected");
        Toast.makeText(getApplicationContext(), "off", Toast.LENGTH_SHORT).show();
    }
    @Override
    	   protected void onDestroy() {
        	       // TODO Auto-generated method stub
        	       super.onDestroy();
        	       unregisterReceiver(bReceiver);
        	   }
}
