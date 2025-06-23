package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class y implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.baidu.platform.comapi.wnplatform.o.a f9881a;
    final /* synthetic */ a b;

    public y(a aVar, com.baidu.platform.comapi.wnplatform.o.a aVar2) {
        this.b = aVar;
        this.f9881a = aVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        if (this.f9881a != null) {
            relativeLayout = this.b.k;
            relativeLayout.setVisibility(8);
            this.f9881a.w();
        }
    }
}
