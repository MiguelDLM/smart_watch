package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class c extends b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f6016a;

    public c(int i) {
        this.f6016a = i;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        str = b.c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.e = null;
        }
        IComOpenClient unused2 = b.e = IComOpenClient.a.a(iBinder);
        b.a(this.f6016a);
        boolean unused3 = b.v = true;
    }
}
