package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class NetworkListener extends BroadcastReceiver {
    private static final List<Handler> d = new ArrayList();
    private static Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f9308a;
    private Context b;
    private f c = new a("NetworkListener", null);

    /* loaded from: classes8.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (NetworkListener.this.b == null) {
                return null;
            }
            NetworkListener networkListener = NetworkListener.this;
            networkListener.a(networkListener.b);
            return null;
        }
    }

    public NetworkListener() {
        this.f9308a = false;
        this.f9308a = false;
    }

    public static void b(Handler handler) {
        synchronized (e) {
            if (handler != null) {
                try {
                    List<Handler> list = d;
                    if (list.contains(handler)) {
                        list.remove(handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.b = context;
        c.a().a((g) this.c, false);
        c.a().c(this.c, new e(200, 0), 200L);
    }

    public static void a(Handler handler) {
        synchronized (e) {
            if (handler != null) {
                try {
                    List<Handler> list = d;
                    if (!list.contains(handler)) {
                        list.add(handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public NetworkListener(boolean z) {
        this.f9308a = false;
        this.f9308a = z;
    }

    private static void a(int i, int i2, int i3) {
        ArrayList<Handler> arrayList;
        Message obtain;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NetworkListener", "dispatchMessage arg1=" + i2 + "arg2=" + i3);
        }
        synchronized (e) {
            arrayList = new ArrayList(d);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (Handler handler : arrayList) {
            if (handler != null && (obtain = Message.obtain(handler, i, i2, i3, null)) != null) {
                obtain.sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r4 == true) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r0)     // Catch: java.lang.Exception -> L10
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch: java.lang.Exception -> L10
            if (r4 != 0) goto Lb
            return
        Lb:
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L10
            goto L11
        L10:
            r4 = 0
        L11:
            r0 = 0
            if (r4 == 0) goto L2b
            int r1 = r4.getType()
            boolean r4 = r4.isConnected()
            r2 = 1
            if (r1 == 0) goto L26
            if (r1 == r2) goto L22
            goto L26
        L22:
            if (r4 != r2) goto L26
            r1 = 1
            goto L27
        L26:
            r1 = 0
        L27:
            r0 = r1
            if (r4 != r2) goto L2b
            goto L2c
        L2b:
            r2 = 0
        L2c:
            boolean r4 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r4 == 0) goto L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "wifiState = "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r1 = ", connectState = "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.String r1 = "NetworkListener"
            com.baidu.navisdk.util.common.LogUtil.e(r1, r4)
        L4f:
            int r4 = com.baidu.navisdk.util.common.y.f9253a
            if (r0 != r4) goto L5a
            boolean r1 = r3.f9308a
            if (r1 != 0) goto L5a
            com.baidu.navisdk.util.common.y.b = r2
            return
        L5a:
            if (r0 != r4) goto L60
            int r4 = com.baidu.navisdk.util.common.y.b
            if (r2 == r4) goto L69
        L60:
            com.baidu.navisdk.util.common.y.f9253a = r0
            com.baidu.navisdk.util.common.y.b = r2
            r4 = 5555(0x15b3, float:7.784E-42)
            a(r4, r0, r2)
        L69:
            com.baidu.navisdk.util.common.y.f9253a = r0
            com.baidu.navisdk.util.common.y.b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.listener.NetworkListener.a(android.content.Context):void");
    }
}
