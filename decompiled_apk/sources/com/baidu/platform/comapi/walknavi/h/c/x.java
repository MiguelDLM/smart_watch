package com.baidu.platform.comapi.walknavi.h.c;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class x implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9796a;

    public x(c cVar) {
        this.f9796a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        com.baidu.platform.comapi.walknavi.h.b bVar2;
        bVar = this.f9796a.n;
        if (bVar != null) {
            bVar2 = this.f9796a.n;
            bVar2.w();
        }
    }
}
