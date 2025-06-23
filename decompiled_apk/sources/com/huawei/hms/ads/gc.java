package com.huawei.hms.ads;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.media2.session.II0XooXoX;
import androidx.media2.session.Oxx0IOOO;

/* loaded from: classes10.dex */
public abstract class gc {
    private static final String I = "BaseNotification";
    private static final String Z = "hwpps";
    protected Context Code;
    NotificationManager V;

    public gc(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = (NotificationManager) applicationContext.getSystemService("notification");
    }

    private String F() {
        return "hwpps";
    }

    private Notification.Builder V() {
        Notification.Builder builder = new Notification.Builder(this.Code);
        builder.setContentTitle(Z());
        builder.setContentText(C());
        builder.setWhen(System.currentTimeMillis());
        builder.setShowWhen(true);
        builder.setContentIntent(S());
        builder.setAutoCancel(true);
        ApplicationInfo applicationInfo = this.Code.getApplicationInfo();
        if (applicationInfo != null) {
            builder.setSmallIcon(applicationInfo.icon);
        }
        return builder;
    }

    public String B() {
        return I;
    }

    public abstract String C();

    public abstract int Code();

    public abstract void Code(Notification.Builder builder);

    public void I() {
        Notification.Builder V = V();
        Code(V);
        if (Build.VERSION.SDK_INT >= 26) {
            II0XooXoX.oIX0oI();
            NotificationChannel oIX0oI2 = Oxx0IOOO.oIX0oI(F(), B(), 3);
            oIX0oI2.setShowBadge(false);
            oIX0oI2.enableLights(false);
            V.setChannelId(F());
            this.V.createNotificationChannel(oIX0oI2);
        }
        this.V.notify(Code(), V.build());
    }

    public abstract PendingIntent S();

    public abstract String Z();
}
