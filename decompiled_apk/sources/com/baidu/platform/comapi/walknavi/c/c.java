package com.baidu.platform.comapi.walknavi.c;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9708a;

    public c(b bVar) {
        this.f9708a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        int i;
        a aVar3;
        int i2;
        a aVar4;
        int i3 = message.what;
        if (i3 == 1) {
            aVar = this.f9708a.e;
            if (aVar != null) {
                aVar2 = this.f9708a.e;
                aVar2.b();
                this.f9708a.e = null;
                return;
            }
            return;
        }
        if (i3 == 16 || i3 == 32) {
            b bVar = this.f9708a;
            i = bVar.f;
            bVar.f = message.what | i;
            aVar3 = this.f9708a.e;
            if (aVar3 != null) {
                i2 = this.f9708a.f;
                if (i2 == 48) {
                    aVar4 = this.f9708a.e;
                    aVar4.a();
                }
            }
        }
    }
}
