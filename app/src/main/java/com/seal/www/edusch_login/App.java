package com.seal.www.edusch_login;

import android.app.Application;

import com.seal.www.edusch_login.core.C2SNotifyImpl;
import com.seal.www.edusch_login.core.ClientSessMgr;
import com.seal.www.edusch_login.core.IC2SNotify;

/**
 * Created by Administrator on 2016/11/16.
 */
public class App extends Application{


    private static int clientId;

    public static int getClientId() {
        return clientId;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initJNI();
    }

    private void initJNI() {
        IC2SNotify notify = new C2SNotifyImpl();
        clientId = ClientSessMgr.CSMCreateEMClient(notify, this);
    }
}
