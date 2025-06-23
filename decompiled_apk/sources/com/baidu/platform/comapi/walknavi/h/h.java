package com.baidu.platform.comapi.walknavi.h;

import android.widget.LinearLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9806a;

    public h(b bVar) {
        this.f9806a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        linearLayout = this.f9806a.ai;
        linearLayout.setVisibility(8);
    }
}
