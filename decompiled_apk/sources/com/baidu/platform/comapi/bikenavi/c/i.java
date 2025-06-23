package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Intent;
import com.baidu.R;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9550a;

    public i(b bVar) {
        this.f9550a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity3 = this.f9550a.f;
            activity3.startActivity(intent);
        } catch (Exception unused) {
            activity = this.f9550a.f;
            activity2 = this.f9550a.f;
            com.baidu.platform.comapi.walknavi.h.d.a.a(activity, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity2, R.string.wsdk_string_rg_no_gps));
        }
    }
}
