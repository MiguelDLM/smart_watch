package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ay;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class b {
    private static final String B = "reserveappstatus";
    private static final String C = "com.huawei.hms.pps.action.APP_RESERVE_STATUS_CHANGED";
    private static final String Code = "AgReserveDownloadManager";
    private static final String D = "com.huawei.appmarket.RECV_THIRD_COMMON_MSG";
    private static final int F = 2;
    private static final String I = "com.huawei.appgallery.reserveappstatus";
    private static b L = null;
    private static final String S = "callerpackage";
    private static final byte[] V = new byte[0];
    private static final String Z = "reserveapp";

    /* renamed from: a, reason: collision with root package name */
    private a f17387a;
    private c b;
    private com.huawei.openalliance.ad.download.f c;
    private Context d;
    private Map<String, WeakHashMap<com.huawei.openalliance.ad.download.g, Object>> e = new ConcurrentHashMap();

    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fb.V(b.Code, "reserve broadcast.");
            try {
                SafeIntent safeIntent = new SafeIntent(intent);
                String action = safeIntent.getAction();
                if (b.I.equals(action)) {
                    b.this.Code(safeIntent);
                } else {
                    fb.I(b.Code, "inValid para %s.", action);
                }
            } catch (IllegalStateException e) {
                fb.I(b.Code, "reserve onReceive IllegalStateException: %s", e.getClass().getSimpleName());
            } catch (Exception e2) {
                fb.I(b.Code, "reserve onReceive Exception: %s", e2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0660b implements RemoteCallResultCallback<String> {
        private C0660b() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            fb.V(b.Code, "reserve app %s.", Integer.valueOf(callResult.getCode()));
        }
    }

    /* loaded from: classes10.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fb.V(b.Code, "silent reserve broadcast.");
            b.this.Code(context, intent);
        }
    }

    private b(Context context) {
        String str;
        this.d = context.getApplicationContext();
        try {
            Code();
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            fb.I(Code, str);
        } catch (Exception unused2) {
            str = "registerReceiver Exception";
            fb.I(Code, str);
        }
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (V) {
            try {
                if (L == null) {
                    L = new b(context);
                }
                bVar = L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public synchronized void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.e.get(str);
        if (weakHashMap != null && weakHashMap.size() > 0) {
            weakHashMap.remove(gVar);
            if (weakHashMap.size() <= 0) {
                this.e.remove(str);
            }
        }
    }

    private synchronized WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code(String str) {
        return this.e.get(str);
    }

    private void Code() {
        this.f17387a = new a();
        this.d.registerReceiver(this.f17387a, new IntentFilter(I), D, null);
        this.b = new c();
        this.d.registerReceiver(this.b, new IntentFilter(C), "com.huawei.permission.app.DOWNLOAD", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (C.equals(action) && context != null) {
                String stringExtra = safeIntent.getStringExtra(S);
                String packageName = context.getPackageName();
                if (!ay.Code(stringExtra, packageName)) {
                    fb.V(Code, "caller does not match, caller %s, currentPackage %s.", stringExtra, packageName);
                    return;
                } else if (safeIntent.getIntExtra(B, -1) == 0) {
                    fb.V(Code, "silent reserve failed no need to notify");
                    return;
                } else {
                    Code(safeIntent);
                    return;
                }
            }
            fb.I(Code, "reserve onReceive inValid para %s.", action);
        } catch (IllegalStateException e) {
            fb.I(Code, "silent reserve onReceive IllegalStateException: %s", e.getClass().getSimpleName());
        } catch (Exception e2) {
            fb.I(Code, "silent reserve onReceive Exception: %s", e2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent) {
        String stringExtra = intent.getStringExtra(Z);
        int intExtra = intent.getIntExtra(B, -1);
        fb.V(Code, "reserve status: %s", Integer.valueOf(intExtra));
        if (intExtra == 2) {
            intExtra = 1;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            fb.V(Code, "pkg is null");
        } else {
            Code(stringExtra, intExtra);
        }
    }

    public void Code(AppDownloadTask appDownloadTask) {
        com.huawei.openalliance.ad.download.app.c.Z(this.d, appDownloadTask, new C0660b(), String.class);
    }

    public void Code(com.huawei.openalliance.ad.download.f fVar) {
        this.c = fVar;
    }

    private void Code(String str, int i) {
        WeakHashMap<com.huawei.openalliance.ad.download.g, Object> Code2 = Code(str);
        if (Code2 != null && Code2.size() > 0) {
            for (com.huawei.openalliance.ad.download.g gVar : Code2.keySet()) {
                if (gVar != null) {
                    gVar.Code(str, i);
                }
            }
        }
        com.huawei.openalliance.ad.download.f fVar = this.c;
        if (fVar != null) {
            fVar.Code(str, i);
        }
    }

    public synchronized void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        try {
            WeakHashMap<com.huawei.openalliance.ad.download.g, Object> weakHashMap = this.e.get(str);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                this.e.put(str, weakHashMap);
            }
            weakHashMap.put(gVar, null);
        } catch (Throwable th) {
            throw th;
        }
    }
}
