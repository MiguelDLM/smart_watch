package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

/* loaded from: classes7.dex */
public class f extends Service {
    public static boolean isServing = false;
    public static boolean isStartedServing = false;
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";

    /* renamed from: a, reason: collision with root package name */
    LLSInterface f5747a = null;
    LLSInterface b = null;
    LLSInterface c = null;

    public static float getFrameVersion() {
        return 9.523f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return mC;
    }

    public static void setServiceContext(Context context) {
        mC = context;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LLSInterface lLSInterface = this.c;
        if (lLSInterface != null) {
            return lLSInterface.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onCreate() {
        if (isServing) {
            Log.d("baidu_location_service", "baidu location service can not start again ...20190306..." + Process.myPid());
            return;
        }
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.b = new com.baidu.location.d.a();
        LLSInterface lLSInterface = this.f5747a;
        if (lLSInterface == null || lLSInterface.getVersion() < this.b.getVersion()) {
            this.c = this.b;
            this.f5747a = null;
        } else {
            this.c = this.f5747a;
            this.b = null;
        }
        isServing = true;
        this.c.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        LLSInterface lLSInterface = this.c;
        if (lLSInterface != null) {
            lLSInterface.onDestroy();
        }
        if (isStartedServing) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("command", 0);
                if (intExtra == 1) {
                    startForeground(intent.getIntExtra("id", 0), (Notification) intent.getParcelableExtra("notification"));
                    isStartedServing = true;
                } else if (intExtra == 2) {
                    stopForeground(intent.getBooleanExtra("removenotify", true));
                    isStartedServing = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LLSInterface lLSInterface = this.c;
        if (lLSInterface == null) {
            return 2;
        }
        return lLSInterface.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        LLSInterface lLSInterface = this.c;
        if (lLSInterface != null) {
            lLSInterface.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return false;
    }
}
