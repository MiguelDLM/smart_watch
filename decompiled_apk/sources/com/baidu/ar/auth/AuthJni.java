package com.baidu.ar.auth;

import com.baidu.ar.fn;
import com.baidu.ar.kv;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.statistic.StatisticApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class AuthJni {
    private static volatile AuthJni kZ;
    private final List<Runnable> mReadyTasks = new ArrayList();
    private boolean la = false;

    private AuthJni() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj() {
        Iterator<Runnable> it = this.mReadyTasks.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.mReadyTasks.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        String name = Thread.currentThread().getName();
        HashMap hashMap = new HashMap();
        hashMap.put("event_param", name + "_" + str + "_" + str2);
        hashMap.put("feature_code", str);
        StatisticApi.onEvent("event_authjni_error", hashMap);
    }

    public static void init() {
        kZ = new AuthJni();
        fn.require("dumixar");
        fn.setLibReadyListener("dumixar", new ILibLoader.c() { // from class: com.baidu.ar.auth.AuthJni.1
            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onError() {
            }

            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onReady() {
                kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AuthJni.kZ != null) {
                            try {
                                AuthJni.kZ.nativeInit();
                                AuthJni.kZ.la = true;
                                AuthJni.kZ.cj();
                            } catch (Throwable th) {
                                th.printStackTrace();
                                AuthJni.d(AuthJni.kZ.getVersionStr(), th.getMessage());
                            }
                        }
                    }
                });
            }
        });
    }

    public static void release() {
        if (kZ != null) {
            kZ.mReadyTasks.clear();
            kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AuthJni.kZ.nativeDestroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    AuthJni unused = AuthJni.kZ = null;
                }
            });
        }
    }

    public static void setGrantedFeatures(final int[] iArr) {
        if (kZ == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.AuthJni.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AuthJni.kZ != null) {
                        AuthJni.kZ.nativeSetGrantedFeatures(iArr);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    if (AuthJni.kZ != null) {
                        AuthJni.kZ.nativePutGrantedFeatures(iArr);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        if (kZ.la) {
            kv.runOnUiThread(runnable);
        } else {
            kZ.mReadyTasks.add(runnable);
        }
    }

    public String getVersionStr() {
        try {
            return "ver-" + nativeGetVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            return "EXCEPTION-UNKNOWN";
        }
    }

    public native void nativeDestroy();

    public native int nativeGetVersion();

    public native void nativeInit();

    public native void nativePutGrantedFeatures(int[] iArr);

    public native void nativeSetGrantedFeatures(int[] iArr);

    public void sendAuthFailMessageFromNative(int i) {
        ARAuth.n(i);
    }
}
