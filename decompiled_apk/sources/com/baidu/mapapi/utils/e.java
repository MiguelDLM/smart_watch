package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b;

/* loaded from: classes7.dex */
class e extends b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f6017a;

    public e(d dVar) {
        this.f6017a = dVar;
    }

    @Override // com.baidu.mapframework.open.aidl.b
    public void a(IBinder iBinder) throws RemoteException {
        String str;
        IComOpenClient iComOpenClient;
        boolean z;
        str = b.c;
        Log.d(str, "onClientReady");
        iComOpenClient = b.e;
        if (iComOpenClient != null) {
            IComOpenClient unused = b.e = null;
        }
        IComOpenClient unused2 = b.e = IComOpenClient.a.a(iBinder);
        z = b.v;
        if (!z) {
            b.a(b.f6015a);
        }
        boolean unused3 = b.v = true;
    }
}
