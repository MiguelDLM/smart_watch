package com.baidu.navisdk.ugc.quickinput.tags;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f8231a;
    public int b;

    public b() {
        this.f8231a = null;
        this.b = -1;
    }

    public boolean a() {
        if (!TextUtils.isEmpty(this.f8231a) && this.b > 0) {
            return true;
        }
        return false;
    }

    public b(String str, int i) {
        this.f8231a = str;
        this.b = i;
    }
}
