package com.anjualex.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myintent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent mypending=PendingIntent.getActivity(getApplicationContext(),1,myintent,0);

        Notification mynotification=new Notification.Builder(this)
                .setContentTitle("chats to read")

                .setContentText("you there?")
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentIntent(mypending)
                .addAction(android.R.drawable.sym_action_chat,"Chat",mypending)   //pending intent works only when clicked
                .build();
        NotificationManager mymanager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mymanager.notify(1,mynotification);
    }
}
