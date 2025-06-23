package com.baidu.platform.comapi.walknavi.h;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9821a;

    public w(b bVar) {
        this.f9821a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.f9821a.l;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_AR_HINT_HAS_SHOW", true);
        }
    }
}
