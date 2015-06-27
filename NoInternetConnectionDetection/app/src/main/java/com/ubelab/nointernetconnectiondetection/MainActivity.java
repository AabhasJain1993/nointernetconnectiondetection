package com.ubelab.nointernetconnectiondetection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    Button checkConnectivityBtn;

    @Override
    protected void onResume() {
        super.onResume();
        checkConnectivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnectivityBtn = (Button)findViewById(R.id.checkConnectivityBtn);
        checkConnectivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnectivity();
            }
        });
    }

    private void checkConnectivity(){
        if(ConnectionHelper.isConnectedOrConnecting(getApplicationContext())) {
            hideErrorsBar(true);
        }else {
            hideErrorsBar(false);
        }
    }
}
