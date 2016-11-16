package com.seal.www.edusch_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.seal.www.edusch_login.core.ClientSessMgr;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static{
        System.loadLibrary("zigsun");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_connect).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_connect:
                ClientSessMgr.CSMConnect(App.getClientId(), "192.168.10.12", (short)4888);
                Toast.makeText(this,"connected!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_login:
                ClientSessMgr.CSMLogin(App.getClientId(),"13400000001","123456","183.63.35.29","3.0");
                break;
        }
    }
}
