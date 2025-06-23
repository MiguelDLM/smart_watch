package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.cy;
import com.huawei.openalliance.ad.ipc.a;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes10.dex */
public abstract class c<SERVICE extends IInterface> implements a.InterfaceC0665a {
    private static final String B = "install_service_timeout_task";
    protected static final long Code = 3000;
    private static final String Z = "BaseAidlSer";
    protected com.huawei.openalliance.ad.ipc.a I;
    private SERVICE S;
    protected Context V;
    private final String C = B + hashCode();
    private boolean F = false;
    private final byte[] D = new byte[0];
    private Set<a> L = new CopyOnWriteArraySet();

    /* renamed from: a, reason: collision with root package name */
    private ServiceConnection f17403a = new ServiceConnection() { // from class: com.huawei.openalliance.ad.ipc.c.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                fb.Code(c.this.V(), "onServiceConnected comp name: %s pkgName: %s", componentName.getClassName(), componentName.getPackageName());
                if (!c.this.F().equalsIgnoreCase(componentName.getClassName())) {
                    c.this.Code("pps remote service name not match, disconnect service.");
                    c.this.Code((c) null);
                    return;
                }
                bf.Code(c.this.C);
                fb.V(c.this.V(), "PPS remote service connected: %d", Long.valueOf(System.currentTimeMillis()));
                c.this.Code((c) c.this.Code(iBinder));
                c.this.Code(componentName);
                if (c.this.S() && c.this.D()) {
                    fb.I(c.this.V(), "request is already timeout");
                    return;
                }
                IInterface a2 = c.this.a();
                if (a2 != null) {
                    ArrayList arrayList = new ArrayList(c.this.L);
                    c.this.L.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).Code((a) a2);
                    }
                }
            } catch (Throwable th) {
                fb.I(c.this.V(), "BaseASM Service, service error: %s", th.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            fb.V(c.this.V(), "PPS remote service disconnected");
            c.this.Code((c) null);
            c.this.C();
        }
    };

    /* loaded from: classes10.dex */
    public static abstract class a<SERVICE extends IInterface> {
        private com.huawei.openalliance.ad.ipc.a Code;

        public abstract void Code(SERVICE service);

        public abstract void Code(String str);

        public void finalize() {
            try {
                super.finalize();
                com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.Code == null || w.B(a.this.Code.Code())) {
                            return;
                        }
                        a.this.Code.I();
                    }
                });
            } catch (Throwable th) {
                fb.V(c.Z, "finalize err: %s", th.getClass().getSimpleName());
            }
        }

        public void Code(com.huawei.openalliance.ad.ipc.a aVar) {
            this.Code = aVar;
        }
    }

    public c(Context context) {
        this.V = context.getApplicationContext();
        this.I = new com.huawei.openalliance.ad.ipc.a(context, V(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        boolean z;
        synchronized (this.D) {
            z = this.F;
        }
        return z;
    }

    private boolean L() {
        try {
            fb.V(V(), "bindService " + System.currentTimeMillis());
            B();
            Intent intent = new Intent(I());
            String Z2 = Z();
            fb.V(V(), "bind service pkg: " + Z2);
            intent.setPackage(Z2);
            if (!ck.B(this.V) && com.huawei.openalliance.ad.utils.g.Code(Z2)) {
                String Z3 = com.huawei.openalliance.ad.utils.g.Z(this.V, Z2);
                boolean isEmpty = TextUtils.isEmpty(Z3);
                fb.V(V(), "is sign empty: %s", Boolean.valueOf(isEmpty));
                if (!isEmpty && !cy.Code(this.V, Z2, Z3)) {
                    return false;
                }
            }
            boolean bindService = this.V.bindService(intent, this.f17403a, 1);
            fb.V(V(), "bind service result: %s", Boolean.valueOf(bindService));
            if (!bindService) {
                Code("bind service failed");
            }
            return bindService;
        } catch (SecurityException unused) {
            fb.I(V(), "bindService SecurityException");
            Code("bindService SecurityException");
            return false;
        } catch (Exception e) {
            fb.I(V(), "bindService " + e.getClass().getSimpleName());
            Code("bindService " + e.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized SERVICE a() {
        return this.S;
    }

    public abstract void B();

    public void C() {
    }

    public abstract SERVICE Code(IBinder iBinder);

    public abstract void Code(ComponentName componentName);

    public abstract String F();

    public abstract String I();

    public boolean S() {
        return false;
    }

    public String V() {
        return "";
    }

    public abstract String Z();

    @Override // com.huawei.openalliance.ad.ipc.a.InterfaceC0665a
    public synchronized void Code() {
        this.V.unbindService(this.f17403a);
        this.S = null;
    }

    private void Code(long j) {
        bf.Code(this.C);
        Code(false);
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.1
            @Override // java.lang.Runnable
            public void run() {
                fb.V(c.this.V(), "bind timeout " + System.currentTimeMillis());
                c.this.Code(true);
                c.this.Code("service bind timeout");
            }
        }, this.C, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Code(SERVICE service) {
        this.S = service;
    }

    public void Code(a aVar, long j) {
        fb.Code(V(), "handleTask");
        aVar.Code(this.I);
        this.I.V();
        SERVICE a2 = a();
        if (a2 != null) {
            aVar.Code((a) a2);
            return;
        }
        this.L.add(aVar);
        if (L() && S()) {
            Code(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        try {
            ArrayList arrayList = new ArrayList(this.L);
            this.L.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).Code(str);
            }
        } catch (Throwable th) {
            try {
                fb.I(V(), "notifyServiceCallFail " + th.getClass().getSimpleName());
            } finally {
                this.L.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        synchronized (this.D) {
            this.F = z;
        }
    }
}
