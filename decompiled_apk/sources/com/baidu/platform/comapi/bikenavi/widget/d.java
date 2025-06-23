package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9562a;

    public d(a aVar) {
        this.f9562a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomScrollView customScrollView;
        CustomScrollView customScrollView2;
        customScrollView = this.f9562a.n;
        if (customScrollView.getStatus() != com.baidu.platform.comapi.wnplatform.o.b.BOTTOM) {
            customScrollView2 = this.f9562a.n;
            if (customScrollView2.getStatus() == com.baidu.platform.comapi.wnplatform.o.b.TOP) {
                this.f9562a.d(true);
                return;
            }
            return;
        }
        this.f9562a.c(true);
    }
}
