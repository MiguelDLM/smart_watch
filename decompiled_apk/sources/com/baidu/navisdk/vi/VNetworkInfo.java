package com.baidu.navisdk.vi;

import android.net.NetworkInfo;

/* loaded from: classes8.dex */
public class VNetworkInfo {
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    public int state;
    public int type;
    public String typename;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9405a;

        static {
            int[] iArr = new int[NetworkInfo.State.values().length];
            f9405a = iArr;
            try {
                iArr[NetworkInfo.State.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9405a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9405a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9405a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9405a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public VNetworkInfo(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            this.state = 0;
            return;
        }
        this.typename = networkInfo.getTypeName();
        this.type = networkInfo.getType();
        int i = a.f9405a[networkInfo.getState().ordinal()];
        if (i != 1) {
            if (i != 2) {
                this.state = 0;
                return;
            } else {
                this.state = 1;
                return;
            }
        }
        this.state = 2;
    }
}
