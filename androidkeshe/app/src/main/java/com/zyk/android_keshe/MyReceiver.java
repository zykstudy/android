package com.zyk.android_keshe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       Toast.makeText(context,"接收到的Intent的Action为："+intent.getAction()+":"+intent.getStringExtra("hh"),
               Toast.LENGTH_LONG).show();
        System.out.println(intent.getStringExtra("hh"));
    }

}
