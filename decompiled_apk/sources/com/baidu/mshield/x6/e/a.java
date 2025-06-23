package com.baidu.mshield.x6.e;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C;

/* loaded from: classes7.dex */
public class a {
    public static void a(Context context) {
        int i;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x6.alarm.work.finger");
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT >= 23) {
                i = 201326592;
            } else {
                i = C.BUFFER_FLAG_FIRST_SAMPLE;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, i);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                f.a(th);
            }
            int p = new com.baidu.mshield.x6.a.b(context).p();
            com.baidu.mshield.b.c.a.b("finger alarm interval=" + p + " Min");
            alarmManager.set(1, System.currentTimeMillis() + (((long) p) * 60000), broadcast);
        } catch (Throwable th2) {
            f.a(th2);
        }
    }

    public static void b(Context context) {
        int i;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x6.alarm.work.zid");
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT >= 23) {
                i = 201326592;
            } else {
                i = C.BUFFER_FLAG_FIRST_SAMPLE;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, i);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                f.a(th);
            }
            com.baidu.mshield.b.c.a.b("zid alarm interval=" + com.baidu.mshield.x6.d.a.a(context) + " HOUR");
            alarmManager.set(1, System.currentTimeMillis() + (((long) com.baidu.mshield.x6.d.a.a(context)) * 3600000), broadcast);
        } catch (Throwable th2) {
            f.a(th2);
        }
    }

    public static void c(Context context) {
        int i;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x6.alarm.work.finger");
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT >= 23) {
                i = 201326592;
            } else {
                i = C.BUFFER_FLAG_FIRST_SAMPLE;
            }
            alarmManager.cancel(PendingIntent.getBroadcast(context, 100, intent, i));
            Intent intent2 = new Intent("com.baidu.mshield.x6.alarm.work.zid");
            intent2.setPackage(context.getPackageName());
            alarmManager.cancel(PendingIntent.getBroadcast(context, 101, intent2, i));
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }
}
