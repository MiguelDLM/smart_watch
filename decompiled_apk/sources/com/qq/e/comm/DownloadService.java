package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedList;

/* loaded from: classes11.dex */
public class DownloadService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private SVSD f19430a;
    private boolean b = false;
    private LinkedList<b> c = new LinkedList<>();

    /* loaded from: classes11.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.managers.a f19431a;

        /* renamed from: com.qq.e.comm.DownloadService$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0904a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SVSD f19432a;

            public RunnableC0904a(SVSD svsd) {
                this.f19432a = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19432a.onCreate();
                while (true) {
                    b bVar = (b) DownloadService.this.c.poll();
                    if (bVar == null) {
                        DownloadService.this.f19430a = this.f19432a;
                        return;
                    }
                    this.f19432a.onStartCommand(bVar.f19433a, bVar.b, bVar.c);
                }
            }
        }

        public a(com.qq.e.comm.managers.a aVar) {
            this.f19431a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SVSD aPKDownloadServiceDelegate = this.f19431a.c().getPOFactory().getAPKDownloadServiceDelegate(DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    GDTLogger.w("DownloadService初始化异常");
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0904a(aPKDownloadServiceDelegate));
                }
            } catch (Throwable th) {
                GDTLogger.w("DownloadService初始化异常", th);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f19433a;
        private final int b;
        private final int c;

        private b(Intent intent, int i, int i2) {
            this.f19433a = intent;
            this.b = i;
            this.c = i2;
        }

        public /* synthetic */ b(Intent intent, int i, int i2, a aVar) {
            this(intent, i, i2);
        }
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !a(true)) {
            return null;
        }
        return this.f19430a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (a(false)) {
            return this.f19430a.onStartCommand(intent, i, i2);
        }
        this.c.add(new b(intent, i, i2, null));
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd = this.f19430a;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f19430a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }

    private boolean a(boolean z) {
        if (this.f19430a != null) {
            return true;
        }
        com.qq.e.comm.managers.a b2 = com.qq.e.comm.managers.a.b();
        if (!b2.d()) {
            return false;
        }
        if (!z) {
            if (this.b) {
                return false;
            }
            this.b = true;
            com.qq.e.comm.managers.a.g.submit(new a(b2));
            return false;
        }
        try {
            SVSD aPKDownloadServiceDelegate = b2.c().getPOFactory().getAPKDownloadServiceDelegate(this);
            this.f19430a = aPKDownloadServiceDelegate;
            aPKDownloadServiceDelegate.onCreate();
            return true;
        } catch (Throwable th) {
            GDTLogger.w("DownloadService初始化异常", th);
            return false;
        }
    }
}
