package com.sma.smartv3.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class I0oOIX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f24227II0xO0 = "my_channel_id";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f24228oIX0oI = 1;

    public static void II0xO0(Context context, String title, String message) {
        ((NotificationManager) context.getSystemService("notification")).notify(1, new NotificationCompat.Builder(context, f24227II0xO0).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(title).setContentText(message).setPriority(0).build());
    }

    public static void oIX0oI(Context context) {
        Object systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel oIX0oI2 = androidx.media2.session.Oxx0IOOO.oIX0oI(f24227II0xO0, "My Channel", 3);
            oIX0oI2.setDescription("Channel Description");
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            ((NotificationManager) systemService).createNotificationChannel(oIX0oI2);
        }
    }
}
