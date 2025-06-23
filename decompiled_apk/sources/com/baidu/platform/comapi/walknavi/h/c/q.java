package com.baidu.platform.comapi.walknavi.h.c;

import android.content.Context;
import android.widget.Toast;
import com.baidu.platform.comapi.walknavi.h.c.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class q implements c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9789a;
    final /* synthetic */ c.InterfaceC0538c b;
    final /* synthetic */ c c;

    public q(c cVar, String str, c.InterfaceC0538c interfaceC0538c) {
        this.c = cVar;
        this.f9789a = str;
        this.b = interfaceC0538c;
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.c.a
    public void a(String str) {
        boolean z;
        Context context;
        z = this.c.U;
        if (z) {
            this.c.U = false;
            context = this.c.l;
            Toast.makeText(context, "模型更新成功，下次进入时即可生效", 0).show();
        } else if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            this.c.b(this.f9789a, str);
            c.InterfaceC0538c interfaceC0538c = this.b;
            if (interfaceC0538c != null) {
                interfaceC0538c.a();
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.c.a
    public void a(int i) {
        this.b.b();
    }
}
