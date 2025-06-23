package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.g;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class DownloadNotificationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26419a = "DownloadNotificationService";
    private static int b = -1;
    private static int c = -1;
    private static boolean d = true;
    private static boolean e = false;
    private static volatile long f = 0;
    private static volatile long g = 0;
    private static boolean h = false;
    private static long i = 900;
    private g j;
    private final SparseArray<Notification> k = new SparseArray<>(2);

    private void d() {
        if (this.j == null) {
            g gVar = new g("DownloaderNotifyThread");
            this.j = gVar;
            gVar.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
        c.a(this);
        com.ss.android.socialbase.downloader.g.a c2 = com.ss.android.socialbase.downloader.g.a.c();
        int a2 = c2.a("download_service_foreground", 0);
        if ((a2 == 1 || a2 == 3) && b == -1) {
            b = 0;
        }
        if ((a2 == 2 || a2 == 3) && c == -1) {
            c = 0;
        }
        e = c2.b("non_going_notification_foreground", false);
        h = c2.b("notify_too_fast", false);
        long a3 = c2.a("notification_time_window", 900L);
        i = a3;
        if (a3 < 0 || a3 > 1200) {
            i = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.j;
        if (gVar != null) {
            try {
                gVar.b();
            } catch (Throwable unused) {
            }
            this.j = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        a(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0026, code lost:
    
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.c == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.a(r7, r8)
            if (r0 == 0) goto L80
            com.ss.android.socialbase.downloader.downloader.d r0 = com.ss.android.socialbase.downloader.downloader.d.a()     // Catch: java.lang.Throwable -> L18
            int r0 = r0.a(r7)     // Catch: java.lang.Throwable -> L18
            r1 = 1
            if (r0 != r1) goto L1a
            boolean r0 = com.ss.android.socialbase.downloader.i.f.c()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            goto L1b
        L18:
            r0 = move-exception
            goto L7c
        L1a:
            r1 = 0
        L1b:
            if (r1 != 0) goto L22
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.b     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L22
            goto L28
        L22:
            if (r1 == 0) goto L95
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.c     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L95
        L28:
            com.ss.android.socialbase.downloader.downloader.d r0 = com.ss.android.socialbase.downloader.downloader.d.a()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.downloader.m r0 = r0.c(r7)     // Catch: java.lang.Throwable -> L18
            boolean r2 = r0.h()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L65
            boolean r2 = r0.b()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L65
            java.lang.String r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f26419a     // Catch: java.lang.Throwable -> L18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r3.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r7)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.c.a.c(r2, r3)     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L5f
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.c = r7     // Catch: java.lang.Throwable -> L18
            goto L61
        L5f:
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.b = r7     // Catch: java.lang.Throwable -> L18
        L61:
            r0.a(r7, r8)     // Catch: java.lang.Throwable -> L18
            goto L95
        L65:
            java.lang.String r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f26419a     // Catch: java.lang.Throwable -> L18
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            r2.<init>()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L18
            r2.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.c.a.c(r0, r1)     // Catch: java.lang.Throwable -> L18
            goto L95
        L7c:
            r0.printStackTrace()
            goto L95
        L80:
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.b
            if (r0 == r7) goto L88
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.c
            if (r0 != r7) goto L95
        L88:
            boolean r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.e
            if (r0 == 0) goto L95
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L95
            r5.b(r6, r7)
        L95:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La4
            long r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f     // Catch: java.lang.Throwable -> La4
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto La1
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f = r0     // Catch: java.lang.Throwable -> La4
        La1:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> La4
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.b(android.app.NotificationManager, int, android.app.Notification):void");
    }

    private void a(final Intent intent) {
        g gVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (gVar = this.j) == null) {
            return;
        }
        gVar.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                long j;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra != 0 && notification != null && notificationManager != null) {
                        if (intExtra2 == 4) {
                            if (!Downloader.getInstance(c.O()).isDownloading(intExtra)) {
                                return;
                            }
                            DownloadInfo downloadInfo = Downloader.getInstance(c.O()).getDownloadInfo(intExtra);
                            if (DownloadNotificationService.h) {
                                if (downloadInfo != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - DownloadNotificationService.g > DownloadNotificationService.i) {
                                    DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                    downloadInfo.setLastNotifyProgressTime();
                                    return;
                                }
                                return;
                            }
                            if (downloadInfo != null && downloadInfo.canNotifyProgress()) {
                                DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                downloadInfo.setLastNotifyProgressTime();
                                return;
                            }
                            return;
                        }
                        if (intExtra2 != -2 && intExtra2 != -3) {
                            if (DownloadNotificationService.h) {
                                DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                return;
                            } else {
                                DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                return;
                            }
                        }
                        if (DownloadNotificationService.h) {
                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                            return;
                        }
                        if (DownloadNotificationService.this.j != null) {
                            g gVar2 = DownloadNotificationService.this.j;
                            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                }
                            };
                            if (intExtra2 == -2) {
                                j = 50;
                            } else {
                                j = 200;
                            }
                            gVar2.a(runnable, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.b(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (f.a((Context) DownloadNotificationService.this, com.kuaishou.weapon.p0.g.b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(e.f26241a)) {
                                arrayList.add(e.f26241a);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final NotificationManager notificationManager, final int i2, Notification notification) {
        synchronized (this.k) {
            try {
                int indexOfKey = this.k.indexOfKey(i2);
                if (indexOfKey >= 0 && indexOfKey < this.k.size()) {
                    this.k.setValueAt(indexOfKey, notification);
                    return;
                }
                long currentTimeMillis = i - (System.currentTimeMillis() - f);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                g = currentTimeMillis2;
                f = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    b(notificationManager, i2, notification);
                } else if (this.j != null) {
                    synchronized (this.k) {
                        this.k.put(i2, notification);
                    }
                    this.j.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadNotificationService.this.a(notificationManager, i2);
                        }
                    }, currentTimeMillis);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.k) {
            notification = this.k.get(i2);
            this.k.remove(i2);
        }
        if (notification != null) {
            b(notificationManager, i2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NotificationManager notificationManager, int i2) {
        boolean z;
        a aVar;
        int a2;
        int i3 = b;
        if (i3 != i2 && c != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i3 == i2) {
            b = 0;
            z = false;
        } else {
            c = 0;
            z = true;
        }
        try {
            m c2 = d.a().c(i2);
            if (!c2.b()) {
                d = false;
                com.ss.android.socialbase.downloader.c.a.d(f26419a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
            }
            com.ss.android.socialbase.downloader.c.a.c(f26419a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
            c2.a(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (d) {
            try {
                SparseArray<a> b2 = b.a().b();
                if (b2 != null) {
                    for (int size = b2.size() - 1; size >= 0; size--) {
                        aVar = b2.valueAt(size);
                        if (aVar != null && (a2 = aVar.a()) != i2 && a2 != b && a2 != c && aVar.h()) {
                            if ((d.a().a(aVar.a()) == 1 && !f.c()) == z) {
                                break;
                            }
                        }
                    }
                }
                aVar = null;
                if (aVar != null) {
                    int a3 = aVar.a();
                    try {
                        notificationManager.cancel(a3);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (Downloader.getInstance(this).getStatus(a3) != 1) {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.c.a.c(f26419a, "doCancel, updateNotification id = " + a3);
                    aVar.a((BaseException) null, z2);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    private boolean a(int i2, Notification notification) {
        int i3;
        int i4;
        String channelId;
        if (!d || (i3 = b) == i2 || (i4 = c) == i2) {
            return false;
        }
        if (i3 != 0 && i4 != 0) {
            return false;
        }
        if (e && (notification.flags & 2) == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        channelId = notification.getChannelId();
        return !TextUtils.isEmpty(channelId);
    }
}
