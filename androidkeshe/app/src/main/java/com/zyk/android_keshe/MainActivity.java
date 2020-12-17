package com.zyk.android_keshe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver = null;
    private EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.hh);
    }
     //注册广播
    public void zhuce(View view) {
        if (myReceiver == null){
            myReceiver = new MyReceiver();
            IntentFilter filter = new IntentFilter("zyk.crazyit.action");
            //注册
            registerReceiver(myReceiver,filter);
            Toast.makeText(this,"注册广播接收器成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"已有广播接收器", Toast.LENGTH_SHORT).show();
        }

    }
//广播注销
    public void zhuxiao(View view) {
        if (myReceiver != null){
            unregisterReceiver(myReceiver);
            myReceiver = null;
            Toast.makeText(this,"注销接广播收器成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"没有注册广播接收器", Toast.LENGTH_SHORT).show();
        }
    }
//发送广播
    public void onSend(View view) {
        String str = editText.getText().toString();
        if (!"".equals(str) && str != null){
            if (myReceiver != null){
            Intent intent = new Intent("zyk.crazyit.action");
            intent.putExtra("hh",editText.getText().toString().trim());
            sendBroadcast(intent);
            Toast.makeText(this,"发送", Toast.LENGTH_SHORT).show();
        }else {
                Toast.makeText(this,"请先注册", Toast.LENGTH_SHORT).show();
            }
    }else {
        Toast.makeText(MainActivity.this,"消息不能为空", Toast.LENGTH_SHORT).show();
    }
    }
}
