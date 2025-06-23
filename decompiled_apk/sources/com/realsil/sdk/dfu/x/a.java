package com.realsil.sdk.dfu.x;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.DfuService;
import com.realsil.sdk.dfu.a;
import com.realsil.sdk.dfu.b;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.params.QcConfig;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f19648a;
    public com.realsil.sdk.dfu.x.b b;
    public com.realsil.sdk.dfu.a c;
    public final b.a e = new BinderC0924a();
    public final ServiceConnection f = new b();
    public BluetoothAdapter d = BluetoothAdapter.getDefaultAdapter();

    /* loaded from: classes11.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ZLogger.v("onServiceConnected: className=" + componentName.getClassName() + ", packageName=" + componentName.getPackageName());
            a.this.c = a.AbstractBinderC0910a.a(iBinder);
            if (a.this.c != null) {
                try {
                    if (a.this.c.b("DfuProxy", a.this.e)) {
                        if (a.this.b != null) {
                            a.this.b.a(true, a.this);
                        }
                    } else {
                        ZLogger.d("registerCallback failed, need to unbind");
                        a.this.d();
                    }
                    return;
                } catch (RemoteException e) {
                    ZLogger.e(e.toString());
                    a.this.d();
                    return;
                }
            }
            if (a.this.b != null) {
                a.this.b.a(false, a.this);
            }
            ZLogger.v("rebind DfuService...");
            a.this.c();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ZLogger.d("Proxy object disconnected with an extreme situations");
            try {
                if (a.this.c != null) {
                    a.this.c.a("DfuProxy", a.this.e);
                }
            } catch (RemoteException e) {
                ZLogger.e(e.toString());
            }
            a.this.c = null;
            if (a.this.b != null) {
                a.this.b.a(false, null);
                a.this.c();
            }
        }
    }

    public a(Context context, com.realsil.sdk.dfu.x.b bVar) {
        this.f19648a = context;
        this.b = bVar;
    }

    public void finalize() {
        this.b = null;
        b();
    }

    /* renamed from: com.realsil.sdk.dfu.x.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class BinderC0924a extends b.a {
        public BinderC0924a() {
        }

        @Override // com.realsil.sdk.dfu.b
        public void a(int i) {
            if (a.this.b != null) {
                a.this.b.onStateChanged(i, null);
            }
        }

        @Override // com.realsil.sdk.dfu.b
        public void b(int i) {
            if (a.this.b != null) {
                a.this.b.onError(i);
            }
        }

        @Override // com.realsil.sdk.dfu.b
        public void a(DfuProgressInfo dfuProgressInfo) {
            if (a.this.b != null) {
                a.this.b.onProgressChanged(dfuProgressInfo);
            }
        }
    }

    public void b() {
        this.b = null;
        a();
        d();
    }

    public final boolean c() {
        try {
            ZLogger.v("bindService DfuService ...");
            Intent intent = new Intent(this.f19648a, (Class<?>) DfuService.class);
            intent.setAction(com.realsil.sdk.dfu.a.class.getName());
            return this.f19648a.bindService(intent, this.f, 1);
        } catch (Exception e) {
            ZLogger.e("Unable to bind DfuService " + e.toString());
            return false;
        }
    }

    public final void d() {
        synchronized (this.f) {
            com.realsil.sdk.dfu.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a("DfuProxy", this.e);
                    this.c = null;
                    this.f19648a.unbindService(this.f);
                } catch (Exception e) {
                    ZLogger.w("Unable to unbind DfuService: " + e.toString());
                }
            }
        }
    }

    public int e() {
        com.realsil.sdk.dfu.a aVar = this.c;
        if (aVar == null) {
            ZLogger.w("Proxy not attached to service");
            return -1;
        }
        try {
            return aVar.a();
        } catch (RemoteException unused) {
            ZLogger.e("Stack:" + Log.getStackTraceString(new Throwable()));
            return -1;
        }
    }

    public static boolean a(Context context, com.realsil.sdk.dfu.x.b bVar) {
        if (context == null || bVar == null) {
            return false;
        }
        a aVar = new a(context, bVar);
        if (!aVar.a(context)) {
            ZLogger.w("please declare com.realsil.sdk.dfu.DfuService in your AndroidManifest.xml");
            return false;
        }
        return aVar.c();
    }

    public final boolean a(Context context) {
        return context.getPackageManager().queryIntentServices(new Intent(context, (Class<?>) DfuService.class), 65536).size() > 0;
    }

    public boolean a(DfuConfig dfuConfig) {
        return a(dfuConfig, (QcConfig) null);
    }

    public boolean a(DfuConfig dfuConfig, QcConfig qcConfig) {
        com.realsil.sdk.dfu.a aVar = this.c;
        if (aVar == null) {
            ZLogger.w("Proxy not attached to service");
            return false;
        }
        try {
            return aVar.a("DfuProxy", dfuConfig, qcConfig);
        } catch (RemoteException unused) {
            ZLogger.w("Stack:" + Log.getStackTraceString(new Throwable()));
            return false;
        }
    }

    public boolean a() {
        com.realsil.sdk.dfu.a aVar = this.c;
        if (aVar == null) {
            ZLogger.d("Proxy not attached to service");
            return false;
        }
        try {
            return aVar.c();
        } catch (RemoteException unused) {
            ZLogger.e("Stack:" + Log.getStackTraceString(new Throwable()));
            return false;
        }
    }

    public boolean a(boolean z) {
        if (this.c == null) {
            ZLogger.w("Proxy not attached to service");
            return false;
        }
        try {
            ZLogger.d("activeImage");
            return this.c.a(z);
        } catch (RemoteException unused) {
            ZLogger.e("Stack:" + Log.getStackTraceString(new Throwable()));
            return false;
        }
    }
}
