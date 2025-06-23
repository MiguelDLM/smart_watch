package com.baidu.platform.comapi.walknavi.h.c;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9795a;

    public w(c cVar) {
        this.f9795a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.platform.comapi.walknavi.h.b bVar;
        com.baidu.platform.comapi.walknavi.h.b bVar2;
        bVar = this.f9795a.n;
        if (bVar != null) {
            bVar2 = this.f9795a.n;
            bVar2.w();
        }
    }
}
