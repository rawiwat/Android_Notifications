package com.example.notificationassignment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val NOTIFICATION_ID = 50
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
       notification1.setOnClickListener { p0 ->
            //val contentIntent = Intent(context, MainActivity::class.java)
            val channelId = "${context.packageName}.simplechannel"
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Simple Notification Channel"
                val importance = NotificationManager.IMPORTANCE_HIGH
                val description = "Demonstrating creation of notification channels"
                val channel = NotificationChannel(channelId, name, importance)
                channel.description = description

                notificationManager.createNotificationChannel(channel)
            }
            val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setPriority(NotificationManager.IMPORTANCE_NONE)
                .setSmallIcon(android.R.drawable.ic_media_rew)
                .setContentTitle("Simple Notification")
                .setContentText("some text")
                .setColor(Color.MAGENTA)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }
}