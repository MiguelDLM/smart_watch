package com.baidu.mapclient.liteapp;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import androidx.media2.session.Oxx0IOOO;
import com.szabh.navi.R;

/* loaded from: classes7.dex */
public class ForegroundService extends Service {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int RES_ID = R.layout.activity_navi;

    @RequiresApi(26)
    private void createNotificationChannel(String str, String str2) {
        NotificationChannel oIX0oI2 = Oxx0IOOO.oIX0oI(str, str2, 0);
        oIX0oI2.setLightColor(-16776961);
        oIX0oI2.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(oIX0oI2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    @SuppressLint({"ForegroundServiceType"})
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel("my_service", "My Background Service");
        }
        Notification notification = new Notification();
        try {
            notification = new NotificationCompat.Builder(this, "my_service").setTicker("正在导航").setWhen(System.currentTimeMillis()).setContentTitle("正在导航").setContentText("百度地图").build();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 34) {
            ServiceCompat.startForeground(this, RES_ID, notification, 8);
        } else {
            startForeground(RES_ID, notification);
        }
    }
}
