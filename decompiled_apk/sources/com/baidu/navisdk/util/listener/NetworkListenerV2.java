package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.navisdk.framework.message.bean.o;
import com.baidu.navisdk.framework.message.bean.p;
import com.baidu.navisdk.framework.message.bean.w;
import com.baidu.navisdk.network.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes8.dex */
public class NetworkListenerV2 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.network.a f9310a;
    private o b;
    private w c;
    private p d = new p();
    private f e = new a("NetworkListenerV2", null);

    /* loaded from: classes8.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            NetworkListenerV2.this.a(com.baidu.navisdk.framework.a.c().a());
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0304a {
        public b(NetworkListenerV2 networkListenerV2, int[] iArr) {
        }
    }

    public NetworkListenerV2() {
        a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a();
        c.a().a((g) this.e, false);
        c.a().c(this.e, new e(200, 0), 200L);
        if ("android.net.wifi.WIFI_STATE_CHANGED".equalsIgnoreCase(intent.getAction())) {
            this.c = new w(intent.getExtras().getInt("wifi_state", 4));
            com.baidu.navisdk.framework.message.a.a().a(this.c);
        }
    }

    private void a() {
        if (this.f9310a != null) {
            return;
        }
        this.f9310a = com.baidu.navisdk.framework.b.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            int[] iArr = {-1};
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NetworkListenerV2", "updateNetworkStatus --> activeNetInfo = " + activeNetworkInfo);
            }
            if (activeNetworkInfo != null) {
                if (!activeNetworkInfo.isConnected()) {
                    iArr[0] = 0;
                    a(0);
                    return;
                } else {
                    if (activeNetworkInfo.getType() == 1) {
                        com.baidu.navisdk.network.a aVar = this.f9310a;
                        if (aVar != null) {
                            aVar.a(new b(this, iArr));
                            return;
                        } else {
                            iArr[0] = 2;
                            a(2);
                            return;
                        }
                    }
                    iArr[0] = 1;
                    a(1);
                    return;
                }
            }
            iArr[0] = 0;
            a(0);
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
            if (gVar.c()) {
                gVar.a(e.getMessage(), e);
            }
        }
    }

    private void a(int i) {
        int i2 = z.f9254a;
        int i3 = z.b;
        int i4 = i == 0 ? 1 : 2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NetworkListenerV2", "cur network type is " + i + ", last network type is " + i2);
            LogUtil.e("NetworkListenerV2", "cur connectType type is " + i4 + ", last connectType type is " + i3);
        }
        z.f9254a = i;
        z.b = i4;
        if (i != i2) {
            if (i2 == 0) {
                this.d.f6833a = 0;
                com.baidu.navisdk.framework.message.a.a().a(this.d);
            } else if (i == 0) {
                this.d.f6833a = 1;
                com.baidu.navisdk.framework.message.a.a().a(this.d);
            }
            if (this.b == null) {
                this.b = new o(i);
            }
            this.b.f6832a = i;
            com.baidu.navisdk.framework.message.a.a().a(this.b);
        }
    }
}
