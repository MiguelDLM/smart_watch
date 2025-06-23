package com.baidu.platform.comapi.walknavi.h.c;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9793a;

    public u(c cVar) {
        this.f9793a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.f9793a.N;
        if (imageView != null) {
            imageView2 = this.f9793a.N;
            imageView2.performClick();
        }
    }
}
