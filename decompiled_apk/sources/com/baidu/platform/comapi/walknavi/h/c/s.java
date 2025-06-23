package com.baidu.platform.comapi.walknavi.h.c;

import android.content.Context;
import com.baidu.R;
import com.baidu.platform.comapi.walknavi.h.c.c;

/* loaded from: classes8.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f9791a;

    public s(r rVar) {
        this.f9791a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f9791a.b.l;
        if (!com.baidu.platform.comapi.walknavi.e.a.g.g.d(context)) {
            context2 = this.f9791a.b.l;
            if (context2 != null) {
                r rVar = this.f9791a;
                c cVar = rVar.b;
                String str = rVar.f9790a;
                context3 = cVar.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.p.a.a.b(context3, R.string.wsdk_string_arnpc_dialog_npc_update), 4);
                return;
            }
            return;
        }
        r rVar2 = this.f9791a;
        rVar2.b.a(rVar2.f9790a, (c.InterfaceC0538c) null);
    }
}
