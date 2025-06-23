package com.baidu.platform.comapi.wnplatform;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.wnplatform.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9902a;

    public d(c cVar) {
        this.f9902a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c.b bVar;
        c.b bVar2;
        c.b bVar3;
        int i = message.what;
        if (i == 0) {
            this.f9902a.b = true;
            return;
        }
        if (i == 1) {
            Boolean bool = (Boolean) message.obj;
            this.f9902a.b = false;
            bVar2 = this.f9902a.f;
            if (bVar2 != null && bool.booleanValue()) {
                bVar3 = this.f9902a.f;
                bVar3.a();
                return;
            }
            return;
        }
        if (i == 2) {
            this.f9902a.b = false;
            bVar = this.f9902a.f;
            bVar.b();
        }
    }
}
