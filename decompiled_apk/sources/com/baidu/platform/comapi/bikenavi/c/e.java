package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9546a;

    public e(b bVar) {
        this.f9546a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9546a.a(true, R.string.wsdk_string_rg_nav_arrive_auto_exit);
    }
}
