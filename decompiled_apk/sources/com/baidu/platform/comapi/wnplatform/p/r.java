package com.baidu.platform.comapi.wnplatform.p;

import android.content.SharedPreferences;

/* loaded from: classes8.dex */
public class r extends com.baidu.platform.comapi.walknavi.a {
    private SharedPreferences.Editor b = null;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f9967a = com.baidu.platform.comapi.wnplatform.p.b.a.a().getSharedPreferences("walknavi_preference", 0);

    public String a(String str, String str2) {
        return this.f9967a.getString(str, str2);
    }

    public boolean b(String str, boolean z) {
        SharedPreferences.Editor edit = this.f9967a.edit();
        this.b = edit;
        edit.putBoolean(str, z);
        return this.b.commit();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    public boolean a(String str, boolean z) {
        return this.f9967a.getBoolean(str, z);
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor edit = this.f9967a.edit();
        this.b = edit;
        edit.putString(str, str2);
        return this.b.commit();
    }
}
