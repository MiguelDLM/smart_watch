package com.baidu.navisdk.module.longlink;

import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class JNILonglinkControl {
    private com.baidu.navisdk.module.longlink.b mResponseDispatcher;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static JNILonglinkControl f7191a = new JNILonglinkControl();
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f7192a;
        public final String b;

        public c(int i, String str) {
            this.f7192a = i;
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.f7192a != this.f7192a || !cVar.b.equals(this.b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f7192a + this.b.hashCode();
        }
    }

    public static JNILonglinkControl getInstance() {
        return b.f7191a;
    }

    private native boolean register(int i);

    private native boolean unRegister(int i);

    public native boolean cancel(int i);

    public void dispatchResponse(boolean z, int i, int i2, boolean z2, String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("JNILonglinkControl", "JNILonglinkControl.dispatchResponse, content=" + str);
        }
        this.mResponseDispatcher.a(z, i, i2, z2, str);
    }

    public native void initLonglinkServer();

    public native boolean queryCanStopLongServer();

    public boolean registerLongLink(c cVar, com.baidu.navisdk.module.longlink.a aVar) {
        boolean z;
        if (this.mResponseDispatcher.a(cVar.f7192a)) {
            z = register(cVar.f7192a);
        } else {
            z = true;
        }
        this.mResponseDispatcher.a(cVar, aVar);
        return z;
    }

    public native boolean sendData(int i, int i2, String str, boolean z, boolean z2);

    public native void unInitLonglinkServer();

    public boolean unRegisterLongLink(c cVar) {
        if (this.mResponseDispatcher.a(cVar)) {
            this.mResponseDispatcher.b(cVar);
            if (this.mResponseDispatcher.a(cVar.f7192a)) {
                return unRegister(cVar.f7192a);
            }
        }
        return false;
    }

    private JNILonglinkControl() {
        this.mResponseDispatcher = new com.baidu.navisdk.module.longlink.b();
    }
}
