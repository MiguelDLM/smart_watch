package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.i;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class a implements PermissionCheck.c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6128a = "a";
    private static a e = null;
    private static int f = -100;
    private Context b;
    private f c;
    private int d;
    private CopyOnWriteArrayList<c> g = new CopyOnWriteArrayList<>();

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    private a() {
    }

    private void f() {
        f fVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        Context context = this.b;
        if (context != null && (fVar = this.c) != null) {
            context.registerReceiver(fVar, intentFilter);
        }
    }

    private void g() {
        Context context;
        f fVar = this.c;
        if (fVar != null && (context = this.b) != null) {
            context.unregisterReceiver(fVar);
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.g.add(cVar);
        }
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.g.remove(cVar);
        }
    }

    public boolean c() {
        if (this.b == null) {
            Context cachedContext = JNIInitializer.getCachedContext();
            this.b = cachedContext;
            if (cachedContext == null) {
                Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                return false;
            }
        }
        i.b(this.b);
        if (!b.c()) {
            PermissionCheck.setPrivacyMode(false);
        } else {
            PermissionCheck.setPrivacyMode(true);
        }
        i.c(this.b);
        com.baidu.mapsdkplatform.comapi.util.c.a().a(this.b);
        i.i();
        PermissionCheck.init(this.b);
        PermissionCheck.setPermissionCheckResultListener(this);
        PermissionCheck.permissionCheck();
        if (b.c()) {
            return true;
        }
        throw new BaiduMapSDKException("not agree privacyMode, please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
    }

    public void d() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            g();
            Iterator<c> it = this.g.iterator();
            while (it.hasNext()) {
                this.g.remove(it.next());
            }
            i.c();
        }
    }

    public Context e() {
        if (this.b == null) {
            this.b = JNIInitializer.getCachedContext();
        }
        return this.b;
    }

    public static a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public void b() {
        if (this.d == 0) {
            if (this.b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                this.b = cachedContext;
                if (cachedContext == null) {
                    Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return;
                }
            }
            this.c = new f();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.b);
        }
        this.d++;
    }

    public void a(Context context) {
        this.b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c
    public void a(PermissionCheck.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.f6199a == 0) {
            i.c = bVar.e;
            Iterator<c> it = this.g.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.a(i.c);
                }
            }
            i.a(bVar.b, bVar.c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
        }
        int i = bVar.f6199a;
        if (i == PermissionCheck.b || i == PermissionCheck.f6198a || i == PermissionCheck.c) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.util.c.a().a(bVar.f);
    }
}
