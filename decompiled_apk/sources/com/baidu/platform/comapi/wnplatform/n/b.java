package com.baidu.platform.comapi.wnplatform.n;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9944a;

    public b(a aVar) {
        this.f9944a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.platform.comapi.wnplatform.c.b bVar;
        com.baidu.platform.comapi.wnplatform.c.b bVar2;
        if (message.what == 1) {
            WLocData wLocData = (WLocData) message.obj;
            bVar = this.f9944a.h;
            if (bVar != null) {
                bVar2 = this.f9944a.h;
                bVar2.a(wLocData);
            }
        }
    }
}
