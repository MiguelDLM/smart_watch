package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes13.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26262a = "DownloadReceiver";

    private void a(final Context context, final String str) {
        if (!c.H()) {
            return;
        }
        c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    context.startService(intent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    private void b(final Context context, final String str) {
        c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    context.startService(intent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                    com.ss.android.socialbase.downloader.c.a.a(f26262a, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
                }
                a(context, action);
            } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                b(context, action);
            }
        }
    }
}
