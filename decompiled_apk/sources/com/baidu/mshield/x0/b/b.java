package com.baidu.mshield.x0.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6403a;

    public static int a(Context context) {
        try {
            String a2 = new com.baidu.mshield.x0.j.a(context).a("plc33");
            if (!TextUtils.isEmpty(a2)) {
                return new JSONObject(a2).optJSONObject("5").optInt("t", 60);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 60;
    }

    public static void b(Context context) {
        int i;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x0.alarm.action");
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT >= 23) {
                i = 201326592;
            } else {
                i = C.BUFFER_FLAG_FIRST_SAMPLE;
            }
            alarmManager.cancel(PendingIntent.getBroadcast(context, 100, intent, i));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void c(Context context) {
        int k = new com.baidu.mshield.x0.j.a(context).k();
        if (k == 0) {
            k = 24;
        }
        a(context, "com.baidu.mshield.x0.detect.app.fr", k * 3600000, 1);
    }

    public static void a(Context context, long j) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x0.alarm.action");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                d.a(th);
            }
            alarmManager.set(1, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    public static void a(Context context, boolean z) {
        f6403a = z;
        a(context, new com.baidu.mshield.x0.j.a(context));
        c(context);
        f6403a = false;
    }

    public static void a(Context context, String str, long j, int i) {
        try {
            long currentTimeMillis = System.currentTimeMillis() + j;
            a aVar = new a();
            aVar.f6400a = str;
            aVar.c = currentTimeMillis;
            aVar.b = i;
            a a2 = com.baidu.mshield.x0.d.a.a(context).a(str);
            if (a2 != null) {
                long j2 = a2.c;
                long i2 = new com.baidu.mshield.x0.j.a(context).i();
                if (!f6403a && j2 >= i2) {
                    aVar.c = j2;
                }
            }
            com.baidu.mshield.x0.d.a.a(context).a(aVar);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, com.baidu.mshield.x0.j.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.mshield.x0.j.a(context);
        }
        a(context, "com.baidu.mshield.x0.timer.pp.action", aVar.a() * 60000, 0);
    }
}
