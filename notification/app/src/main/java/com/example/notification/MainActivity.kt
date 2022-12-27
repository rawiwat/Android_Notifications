package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        val NOTIFICATION_ID = 50
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*this is the same thing it's just longer and sometime
         it can do more complicate stuff

        btn_notification_simple.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }

        })*/
        val context = this

        btn_notification_simple.setOnClickListener{p0 ->
            val channelId = "$packageName.simplechannel"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
            as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Simple Notification Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val description = "Demonstrating creation of notification channels"
            val channel = NotificationChannel(channelId,name,importance)
            channel.description = description

            notificationManager.createNotificationChannel(channel)
        }
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setSmallIcon(android.R.drawable.ic_media_rew)
                notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
    }

    }
}
