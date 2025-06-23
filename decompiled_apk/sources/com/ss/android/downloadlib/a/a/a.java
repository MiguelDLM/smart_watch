package com.ss.android.downloadlib.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.a.a.c;
import com.ss.android.downloadlib.addownload.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a {
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static volatile a g;

    /* renamed from: a, reason: collision with root package name */
    public c f25943a;
    private Context k;
    private boolean h = true;
    private boolean i = false;
    private volatile boolean j = false;
    private final List<Pair<b, d>> l = new ArrayList();
    public final List<InterfaceC1037a> b = new ArrayList();
    private final ServiceConnection m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.c) {
                try {
                    a.this.a(false);
                    a.this.f25943a = c.a.a(iBinder);
                    a.this.c();
                    Iterator<InterfaceC1037a> it = a.this.b.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.c) {
                try {
                    a.this.a(false);
                    a aVar = a.this;
                    aVar.f25943a = null;
                    Iterator<InterfaceC1037a> it = aVar.b.iterator();
                    while (it.hasNext()) {
                        it.next().b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };
    private String n = "";
    public final Object c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC1037a {
        void a();

        void b();
    }

    private a() {
    }

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                try {
                    if (g == null) {
                        g = new a();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public void b() {
        if (this.f25943a != null) {
            this.k.unbindService(this.m);
            this.f25943a = null;
        }
        this.b.clear();
        this.l.clear();
    }

    public void c() {
        for (Pair<b, d> pair : this.l) {
            try {
                this.f25943a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.l.clear();
    }

    public boolean d() {
        return this.j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(d)) {
            JSONObject j = k.j();
            String optString = j.optString("s");
            d = com.ss.android.socialbase.appdownloader.f.c.a(j.optString("q"), optString);
            e = com.ss.android.socialbase.appdownloader.f.c.a(j.optString(t.i), optString);
            f = com.ss.android.socialbase.appdownloader.f.c.a(j.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.i = z;
        if (context == null) {
            return true;
        }
        this.k = context.getApplicationContext();
        if (TextUtils.isEmpty(f)) {
            f = this.k.getPackageName();
        }
        if (this.f25943a != null || d()) {
            return true;
        }
        return this.k.bindService(a(context), this.m, 33);
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.c) {
            try {
                bVar.e = f;
                if (TextUtils.isEmpty(bVar.f)) {
                    bVar.f = this.n;
                }
                c cVar = this.f25943a;
                if (cVar != null) {
                    try {
                        cVar.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (d() || a(this.k, this.i)) {
                    this.l.add(Pair.create(bVar, dVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
