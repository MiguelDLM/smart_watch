package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.appintro.AppIntroBaseFragmentKt;

/* loaded from: classes7.dex */
public class TitleOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private int f5869a;
    private float d;
    private String e;
    private int f;
    private int g;
    private int b = ViewCompat.MEASURED_STATE_MASK;
    private int c = 48;
    private float h = 0.5f;
    private float i = 1.0f;

    public Bundle b() {
        Bundle bundle = new Bundle();
        int i = this.b;
        int i2 = (i >> 8) & 255;
        bundle.putInt("font_color", Color.argb(i >>> 24, i & 255, i2, (i >> 16) & 255));
        int i3 = this.f5869a;
        int i4 = (i3 >> 8) & 255;
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, Color.argb(i3 >>> 24, i3 & 255, i4, (i3 >> 16) & 255));
        bundle.putInt(ViewHierarchyConstants.TEXT_SIZE, this.c);
        bundle.putFloat("align_x", this.h);
        bundle.putFloat("align_y", this.i);
        bundle.putFloat("title_rotate", this.d);
        bundle.putInt("title_x_offset", this.g);
        bundle.putInt("title_y_offset", this.f);
        bundle.putString("text", this.e);
        return bundle;
    }

    public String getText() {
        return this.e;
    }

    public float getTitleAnchorX() {
        return this.h;
    }

    public float getTitleAnchorY() {
        return this.i;
    }

    public int getTitleBgColor() {
        return this.f5869a;
    }

    public int getTitleFontColor() {
        return this.b;
    }

    public int getTitleFontSize() {
        return this.c;
    }

    public float getTitleRotate() {
        return this.d;
    }

    public float getTitleXOffset() {
        return this.g;
    }

    public int getTitleYOffset() {
        return this.f;
    }

    public TitleOptions text(String str) {
        this.e = str;
        return this;
    }

    public TitleOptions titleAnchor(float f, float f2) {
        this.h = f;
        this.i = f2;
        return this;
    }

    public TitleOptions titleBgColor(int i) {
        this.f5869a = i;
        return this;
    }

    public TitleOptions titleFontColor(int i) {
        this.b = i;
        return this;
    }

    public TitleOptions titleFontSize(int i) {
        this.c = i;
        return this;
    }

    public TitleOptions titleOffset(int i, int i2) {
        this.g = i;
        this.f = i2;
        return this;
    }

    public TitleOptions titleRotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.d = f % 360.0f;
        return this;
    }
}
