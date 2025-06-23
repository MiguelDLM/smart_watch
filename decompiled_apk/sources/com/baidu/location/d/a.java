package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.ai;
import com.baidu.location.b.aj;
import com.baidu.location.b.am;
import com.baidu.location.b.an;
import com.baidu.location.b.ap;
import com.baidu.location.b.c;
import com.baidu.location.b.r;
import com.baidu.location.b.x;
import com.baidu.location.c.e;
import com.baidu.location.c.h;
import com.baidu.location.e.o;
import com.baidu.location.f;
import com.google.android.exoplayer2.offline.DownloadService;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class a extends Service implements LLSInterface {

    /* renamed from: a, reason: collision with root package name */
    static HandlerC0129a f5716a;
    public static long c;
    private static long g;
    Messenger b = null;
    private Looper d = null;
    private HandlerThread e = null;
    private boolean f = true;
    private int h = 0;
    private boolean i = true;

    /* renamed from: com.baidu.location.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0129a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f5717a;

        public HandlerC0129a(Looper looper, a aVar) {
            super(looper);
            this.f5717a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f5717a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                int i = message.what;
                if (i == 11) {
                    aVar.a(message);
                } else if (i == 12) {
                    aVar.b(message);
                } else if (i == 15) {
                    aVar.c(message);
                } else if (i == 22) {
                    x.c().b(message);
                } else if (i == 41) {
                    x.c().i();
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 406) {
                    r.a().e();
                } else if (i == 705) {
                    c.a().a(message.getData().getBoolean(DownloadService.KEY_FOREGROUND));
                }
            }
            if (message.what == 1) {
                aVar.b();
            }
            if (message.what == 0) {
                aVar.a();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e.a().e();
        an.a().f();
        h.a().d();
        x.c().e();
        r.a().c();
        if (this.i) {
            am.d();
        }
        c.a().b();
        try {
            aj.a().d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = 4;
        if (this.f) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        c.a().c(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 9.52299976348877d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        String str;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.e.b.h = extras.getString("key");
            com.baidu.location.e.b.g = extras.getString(HttpConstants.SIGN);
            this.f = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
            str = extras.getString("auth_key");
            o.aY = extras.getString("proxyHost");
            o.aZ = extras.getInt("proxyPort");
            o.ba = extras.getString("username");
            o.bb = extras.getString("password");
        } else {
            str = null;
        }
        if (str != null) {
            com.baidu.location.a.a.a().a(f.getServiceContext(), str);
        }
        if (!TextUtils.isEmpty(o.aY) && o.aZ != -1) {
            LBSAuthManager.getInstance(f.getServiceContext()).setProxy(o.aY, o.aZ);
        }
        if (!TextUtils.isEmpty(o.ba) && !TextUtils.isEmpty(o.bb)) {
            LBSAuthManager.getInstance(f.getServiceContext()).setHttpProxyUsernameAndPassword(o.ba, o.bb);
        }
        com.baidu.location.a.a.a().a(f.getServiceContext());
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        ap.a().a(context);
        LBSAuthManager.getInstance(f.getServiceContext()).setPrivacyMode(true);
        try {
            o.aw = context.getPackageName();
        } catch (Exception unused) {
        }
        g = System.currentTimeMillis();
        HandlerThread a2 = ai.a();
        this.e = a2;
        if (a2 != null) {
            this.d = a2.getLooper();
        }
        f5716a = this.d == null ? new HandlerC0129a(Looper.getMainLooper(), this) : new HandlerC0129a(this.d, this);
        c = System.currentTimeMillis();
        this.b = new Messenger(f5716a);
        f5716a.sendEmptyMessage(0);
        this.h = 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f5716a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.i = false;
            b();
            Process.killProcess(Process.myPid());
        }
        this.h = 3;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this, new WeakReference(this)), 1000L);
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.baidu.location.e.b.a();
        com.baidu.location.b.h.a().a(f.getServiceContext());
        com.baidu.location.b.e.b().b(false);
        com.baidu.location.b.e.b().c();
        try {
            an.a().e();
        } catch (Exception unused) {
        }
        r.a().b();
        e.a().b();
        h.a().b();
        h.a().a(f.getServiceContext());
        x.c().d();
        this.h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        c.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        c.a().a(message);
    }
}
