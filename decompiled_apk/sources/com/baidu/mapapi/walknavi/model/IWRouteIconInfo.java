package com.baidu.mapapi.walknavi.model;

import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public class IWRouteIconInfo {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f6035a;
    private String b;

    public IWRouteIconInfo(Drawable drawable, String str) {
        this.f6035a = drawable;
        this.b = str;
    }

    public Drawable getIconDrawable() {
        return this.f6035a;
    }

    public String getIconName() {
        return this.b;
    }

    public void setIconDrawable(Drawable drawable) {
        this.f6035a = drawable;
    }

    public void setIconName(String str) {
        this.b = str;
    }
}
