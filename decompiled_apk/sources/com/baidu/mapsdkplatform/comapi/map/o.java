package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f6189a;

    public o(n nVar) {
        this.f6189a = nVar;
    }

    @Override // android.os.Handler
    @SuppressLint({"HandlerLeak"})
    public void handleMessage(Message message) {
        n nVar;
        s sVar;
        super.handleMessage(message);
        nVar = n.c;
        if (nVar != null) {
            sVar = this.f6189a.d;
            sVar.a(message);
        }
    }
}
