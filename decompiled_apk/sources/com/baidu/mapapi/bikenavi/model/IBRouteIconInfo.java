package com.baidu.mapapi.bikenavi.model;

import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public class IBRouteIconInfo {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f5772a;
    private String b;

    public IBRouteIconInfo(Drawable drawable, String str) {
        this.f5772a = drawable;
        this.b = str;
    }

    public Drawable getIconDrawable() {
        return this.f5772a;
    }

    public String getIconName() {
        return this.b;
    }

    public void setIconDrawable(Drawable drawable) {
        this.f5772a = drawable;
    }

    public void setIconName(String str) {
        this.b = str;
    }
}
