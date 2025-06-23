package com.baidu.navisdk.module.pronavi.message.model;

import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f7457a;
    private int b;
    private String c;
    private Drawable d;
    private boolean e;
    private String f;

    public a(int i, String str, Drawable drawable, Drawable drawable2) {
        this.e = false;
        this.b = i;
        this.c = str;
        this.f7457a = drawable;
        this.d = drawable2;
    }

    public String toString() {
        return "GuidePanelModel{turnImage=" + this.f7457a + ", remainDist=" + this.b + ", routeName='" + this.c + "', nextTurnImage=" + this.d + ", isFuzz=" + this.e + ", fuzzText='" + this.f + "'}";
    }

    public a(String str) {
        this.b = -1;
        this.e = true;
        this.f = str;
    }
}
