package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.module.init.a;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class JNIIdssControl {
    public static final int TYPE_AI_SEARCH = 1;
    public static final int TYPE_COMMON = 2;
    public static final int TYPE_IDSS = 0;
    public static final int TYPE_PARK = 3;
    private boolean mInited;
    private final HashMap<Integer, IdssResponseCallback> mResponseCallbacks;

    /* loaded from: classes7.dex */
    public interface IdssResponseCallback {
        void onFail(int i);

        void onSuccess(int i, byte[] bArr);
    }

    /* loaded from: classes7.dex */
    public static class InstanceHolder {
        private static final JNIIdssControl INSTANCE = new JNIIdssControl();

        private InstanceHolder() {
        }
    }

    public static JNIIdssControl getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private native void init();

    private boolean initIfNeeded() {
        if (!a.a()) {
            return false;
        }
        if (!this.mInited) {
            init();
            this.mInited = true;
        }
        return true;
    }

    private native boolean register(int i);

    private native boolean unRegister(int i);

    public void dispatchResponse(int i, int i2, byte[] bArr) {
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e("JNIIdssControl", "JNIIdssControl.dispatchResponse, status=" + i2 + " length=" + bArr.length);
        }
        HashMap<Integer, IdssResponseCallback> hashMap = this.mResponseCallbacks;
        if (hashMap != null && hashMap.containsKey(Integer.valueOf(i))) {
            IdssResponseCallback idssResponseCallback = this.mResponseCallbacks.get(Integer.valueOf(i));
            if (i2 == 0) {
                if (idssResponseCallback != null) {
                    idssResponseCallback.onSuccess(i, bArr);
                }
            } else if (idssResponseCallback != null) {
                idssResponseCallback.onFail(i);
            }
        }
    }

    public void registerCallback(int i, IdssResponseCallback idssResponseCallback) {
        if (!initIfNeeded()) {
            return;
        }
        register(i);
        this.mResponseCallbacks.put(Integer.valueOf(i), idssResponseCallback);
    }

    public native boolean request(int i, Bundle bundle);

    public void unRegisterCallback(int i) {
        if (!initIfNeeded()) {
            return;
        }
        unRegister(i);
        this.mResponseCallbacks.remove(Integer.valueOf(i));
    }

    private JNIIdssControl() {
        initIfNeeded();
        this.mResponseCallbacks = new HashMap<>();
    }
}
