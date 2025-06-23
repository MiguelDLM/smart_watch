package com.realsil.sdk.core.base;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.IBinder;
import android.view.Display;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.media2.session.Oxx0IOOO;
import com.baidu.ar.auth.FeatureCodes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.internal.ServerProtocol;
import com.realsil.sdk.core.logger.ZLogger;

/* loaded from: classes11.dex */
public abstract class BaseService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public DisplayManager f19478a;

    @Keep
    public Context mContext;

    @Keep
    public int notificationId = FeatureCodes.FACE_DUMOJI;
    public final DisplayManager.DisplayListener b = new DisplayManager.DisplayListener() { // from class: com.realsil.sdk.core.base.BaseService.1
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    };

    public Notification buildNotification(Context context) {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            II0xO0.oIX0oI();
            builder = oIX0oI.oIX0oI(getApplicationContext(), getChannelId());
        } else {
            builder = new Notification.Builder(getApplicationContext());
        }
        builder.setContentText("GuardService").setWhen(System.currentTimeMillis());
        return builder.build();
    }

    public String getChannelId() {
        return "rtk_channel_id";
    }

    public String getChannelName() {
        return "rtk_channel_name";
    }

    public Notification getNotification(String str, String str2) {
        NotificationCompat.Builder when = new NotificationCompat.Builder(this, getChannelId()).setContentText(str2).setContentTitle(str).setOngoing(true).setPriority(1).setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            when.setChannelId(getChannelId());
        }
        return when.build();
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public boolean isScreenOn() {
        Display[] displays;
        DisplayManager displayManager = this.f19478a;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return false;
        }
        for (Display display : displays) {
            if (display.getState() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isServiceRunningInForeground(Context context) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE)) {
            if (getClass().getName().equals(runningServiceInfo.service.getClassName()) && runningServiceInfo.foreground) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ZLogger.v("in onBind()");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        DisplayManager displayManager = (DisplayManager) getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        this.f19478a = displayManager;
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.b, null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel oIX0oI2 = Oxx0IOOO.oIX0oI(getChannelId(), getChannelName(), 0);
            oIX0oI2.setLightColor(-16776961);
            oIX0oI2.setLockscreenVisibility(0);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(oIX0oI2);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DisplayManager displayManager = this.f19478a;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.b);
        }
        stopForeground(true);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        ZLogger.v("in onRebind()");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ZLogger.d("Last client unbound from service");
        return true;
    }

    public void setNotificationId(int i) {
        this.notificationId = i;
    }

    public void showNotification(String str, String str2, ComponentName componentName) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        showNotification(str, str2, PendingIntent.getActivity(this, 0, intent, 0), -1, -1);
    }

    public void showNotification(String str, String str2, PendingIntent pendingIntent, int i, int i2) {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            II0xO0.oIX0oI();
            builder = oIX0oI.oIX0oI(getApplicationContext(), getChannelId());
        } else {
            builder = new Notification.Builder(getApplicationContext());
        }
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        if (i != -1) {
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), i));
        }
        if (i2 != -1) {
            builder.setSmallIcon(i2);
        }
        builder.setContentTitle(str).setContentText(str2).setWhen(System.currentTimeMillis());
        Notification build = builder.build();
        if (build != null) {
            build.flags = 34;
            startForeground(getNotificationId(), build);
        }
    }
}
