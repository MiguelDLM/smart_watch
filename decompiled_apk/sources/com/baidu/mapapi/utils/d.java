package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class d implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Thread thread;
        String str;
        String str2;
        com.baidu.mapframework.open.aidl.a aVar;
        com.baidu.mapframework.open.aidl.a aVar2;
        com.baidu.mapframework.open.aidl.a aVar3;
        Thread thread2;
        thread = b.x;
        if (thread != null) {
            thread2 = b.x;
            thread2.interrupt();
        }
        str = b.c;
        Log.d(str, "onServiceConnected " + componentName);
        try {
            aVar2 = b.d;
            if (aVar2 != null) {
                com.baidu.mapframework.open.aidl.a unused = b.d = null;
            }
            com.baidu.mapframework.open.aidl.a unused2 = b.d = a.AbstractBinderC0135a.a(iBinder);
            aVar3 = b.d;
            aVar3.a(new e(this));
        } catch (RemoteException e) {
            str2 = b.c;
            Log.d(str2, "getComOpenClient ", e);
            aVar = b.d;
            if (aVar != null) {
                com.baidu.mapframework.open.aidl.a unused3 = b.d = null;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        String str;
        com.baidu.mapframework.open.aidl.a aVar;
        str = b.c;
        Log.d(str, "onServiceDisconnected " + componentName);
        aVar = b.d;
        if (aVar != null) {
            com.baidu.mapframework.open.aidl.a unused = b.d = null;
            boolean unused2 = b.w = false;
        }
    }
}
