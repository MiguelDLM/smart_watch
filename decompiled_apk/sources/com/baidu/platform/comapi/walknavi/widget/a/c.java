package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.baidu.platform.comapi.wnplatform.o.a f9859a;
    final /* synthetic */ a b;

    public c(a aVar, com.baidu.platform.comapi.wnplatform.o.a aVar2) {
        this.b = aVar;
        this.f9859a = aVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        z d = ((com.baidu.platform.comapi.walknavi.h.b) this.f9859a).d();
        if (d != null) {
            relativeLayout = this.b.k;
            relativeLayout.setVisibility(8);
            d.c();
            com.baidu.platform.comapi.wnplatform.o.a aVar = this.f9859a;
            if (aVar instanceof com.baidu.platform.comapi.walknavi.h.b) {
                ((com.baidu.platform.comapi.walknavi.h.b) aVar).e(0);
            }
        }
    }
}
