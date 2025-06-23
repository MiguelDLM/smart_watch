package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationClient f5678a;

    public c(LocationClient locationClient) {
        this.f5678a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle d;
        this.f5678a.g = new Messenger(iBinder);
        if (this.f5678a.g == null) {
            return;
        }
        this.f5678a.e = true;
        z = this.f5678a.y;
        if (z) {
            this.f5678a.h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f5678a.i;
            d = this.f5678a.d();
            obtain.setData(d);
            this.f5678a.g.send(obtain);
            this.f5678a.e = true;
            if (this.f5678a.c != null) {
                this.f5678a.B.booleanValue();
                this.f5678a.h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f5678a.g = null;
        this.f5678a.e = false;
    }
}
