package com.baidu.tts;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.Utility;
import java.util.Date;

/* loaded from: classes8.dex */
public class g2 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public Context f10095a;
    public String b;

    public g2(Context context, String str) {
        this.f10095a = context;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context = this.f10095a;
        String str = this.b;
        synchronized (f2.class) {
            if (Utility.isNetworkConnected(context)) {
                long lastUploadStatTime = Utility.getLastUploadStatTime(context);
                long j = SharedPreferencesUtils.getLong(context, "statistics_time", 0L);
                long j2 = SharedPreferencesUtils.getLong(context, "statistics_expires", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - lastUploadStatTime < 86400000) {
                    Date date = new Date(lastUploadStatTime);
                    Date date2 = new Date(currentTimeMillis);
                    LoggerProxy.d("StatHelper", "lastTime " + lastUploadStatTime + ", curTime " + System.currentTimeMillis());
                    LoggerProxy.d("StatHelper", "lastDate " + date + "\ncurDate " + date2 + " staExpires: " + j2);
                } else if (currentTimeMillis - j > j2) {
                    LoggerProxy.d("StatHelper", "updated " + f2.a(context, str));
                }
            }
        }
        this.f10095a = null;
    }
}
