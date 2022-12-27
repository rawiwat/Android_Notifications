package com.example.notification.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.notification.MainActivity

object notificationgenerator {

    fun simpleNotification(context: Context) {
        val contentIntent = Intent(context, MainActivity::class.java)
        val pendingContentIntent = PendingIntent.getActivity(context, 0, contentIntent, PendingIntent.FLAG_MUTABLE)
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
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setSmallIcon(android.R.drawable.ic_media_ff)
            .setContentTitle("Simple Notification")
            .setContentText("some text")
            .setDeleteIntent(pendingContentIntent)
            .setAutoCancel(true)
        notificationManager.notify(MainActivity.NOTIFICATION_ID, notificationBuilder.build())
    }
}