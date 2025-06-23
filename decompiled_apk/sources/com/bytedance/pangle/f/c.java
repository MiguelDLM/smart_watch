package com.bytedance.pangle.f;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d;

/* loaded from: classes8.dex */
public final class c extends ZeusPluginStateListener {

    /* renamed from: a, reason: collision with root package name */
    final int f10552a;
    private final d b;

    public c(d dVar, int i) {
        this.b = dVar;
        this.f10552a = i;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public final void onStateChangeOnCurThread(String str, int i, Object... objArr) {
        if (i == 5 || i == 7 || i == 6) {
            String str2 = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.b.a(str, i, str2);
        }
    }
}
