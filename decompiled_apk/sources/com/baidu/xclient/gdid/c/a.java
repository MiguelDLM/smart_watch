package com.baidu.xclient.gdid.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.xclient.gdid.e.d;
import com.google.android.exoplayer2.C;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f10226a = 60000;
    public static long b = 3600000;
    public static long c = 86400000;

    public static void a(Context context, long j) {
        if (j <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(b.f10227a);
            intent.setPackage(com.baidu.xclient.gdid.c.a().a(context));
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE);
            alarmManager.cancel(broadcast);
            alarmManager.set(1, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
