package com.baidu.platform.comapi.walknavi.h.c;

import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9785a;

    public m(c cVar) {
        this.f9785a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean e;
        z = this.f9785a.ad;
        if (z) {
            this.f9785a.ad = false;
            String a2 = com.baidu.platform.comapi.walknavi.b.a().O().a("walknavi_current_npc_token", "");
            if (!TextUtils.isEmpty(a2)) {
                e = this.f9785a.e(a2);
                if (e) {
                    this.f9785a.a(a2, new n(this));
                    return;
                }
            }
        } else if (!TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.e.e.c().a())) {
            this.f9785a.l();
            return;
        }
        com.baidu.platform.comapi.walknavi.e.e.c().a("");
        this.f9785a.b(true);
        com.baidu.platform.comapi.walknavi.b.a().K().a(0, 0);
        this.f9785a.u();
    }
}
