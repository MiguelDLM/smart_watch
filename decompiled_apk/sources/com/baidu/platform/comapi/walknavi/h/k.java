package com.baidu.platform.comapi.walknavi.h;

import android.app.Activity;
import android.content.Intent;
import com.baidu.R;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class k implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9809a;

    public k(b bVar) {
        this.f9809a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.f9809a.l;
            activity4.startActivity(intent);
        } catch (Exception unused) {
            activity = this.f9809a.l;
            if (activity != null) {
                activity2 = this.f9809a.l;
                activity3 = this.f9809a.l;
                com.baidu.platform.comapi.walknavi.h.d.a.a(activity2, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity3, R.string.wsdk_string_rg_no_gps));
            }
        }
    }
}
