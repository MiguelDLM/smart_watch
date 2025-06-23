package com.baidu.navisdk.util.statistic;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.vi.VDeviceAPI;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Handler f9363a = new HandlerC0505a(this, "ES");

    /* renamed from: com.baidu.navisdk.util.statistic.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0505a extends com.baidu.navisdk.util.worker.loop.a {

        /* renamed from: com.baidu.navisdk.util.statistic.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0506a extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f9364a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0506a(HandlerC0505a handlerC0505a, String str, String str2, int i) {
                super(str, str2);
                this.f9364a = i;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                try {
                    JNINaviManager.sInstance.initNaviStatistics(this.f9364a);
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }

        public HandlerC0505a(a aVar, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i;
            if (message.what == 5555) {
                LogUtil.e("Handler", " in case NetworkListener.MSG_TYPE_NET_WORK_CHANGE");
                int i2 = message.arg1;
                if (message.arg2 == 1 && i2 == 1) {
                    i = 2;
                } else {
                    i = 0;
                }
                com.baidu.navisdk.util.worker.c.a().c(new C0506a(this, "performNetworkTypeChange", null, i), new com.baidu.navisdk.util.worker.e(200, 0));
            }
        }
    }

    public void a() {
        com.baidu.navisdk.framework.interfaces.g d;
        NetworkListener.a(this.f9363a);
        if (VDeviceAPI.isWifiConnected() == 1 && (d = com.baidu.navisdk.framework.interfaces.c.p().d()) != null && d.e()) {
            JNINaviManager.sInstance.initNaviStatistics(2);
        }
    }
}
