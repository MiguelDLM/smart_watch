package com.baidu.platform.comapi.walknavi.h;

import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9817a;

    public s(b bVar) {
        this.f9817a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9817a.a(true, R.string.wsdk_string_rg_nav_arrive_auto_exit);
    }
}
