package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.appintro.AppIntroBaseFragmentKt;
import vi.com.gdi.bgl.android.java.EnvDrawText;

/* loaded from: classes7.dex */
public final class Text extends Overlay {
    private static final String l = "Text";

    /* renamed from: a, reason: collision with root package name */
    String f5863a;
    LatLng b;
    int c;
    int d;
    int e;
    Typeface f;
    int g;
    int h;
    float i;
    int j;
    boolean k = true;

    public Text() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.text;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.b != null) {
            bundle.putString("text", this.f5863a);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.b);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            int i = this.d;
            bundle.putInt("font_color", Color.argb(i >>> 24, i & 255, (i >> 8) & 255, (i >> 16) & 255));
            int i2 = this.c;
            bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, Color.argb(i2 >>> 24, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255));
            bundle.putInt(ViewHierarchyConstants.TEXT_SIZE, this.e);
            Typeface typeface = this.f;
            if (typeface != null) {
                EnvDrawText.registFontCache(typeface.hashCode(), this.f);
                bundle.putInt("type_face", this.f.hashCode());
            }
            int i3 = this.g;
            bundle.putFloat("align_x", i3 != 1 ? i3 != 2 ? 0.5f : 1.0f : 0.0f);
            int i4 = this.h;
            bundle.putFloat("align_y", i4 != 8 ? i4 != 16 ? 0.5f : 1.0f : 0.0f);
            bundle.putFloat("rotate", this.i);
            bundle.putInt("update", this.j);
            bundle.putInt("isClickable", this.k ? 1 : 0);
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add a text overlay, you must provide text and the position info.");
    }

    public float getAlignX() {
        return this.g;
    }

    public float getAlignY() {
        return this.h;
    }

    public int getBgColor() {
        return this.c;
    }

    public int getFontColor() {
        return this.d;
    }

    public int getFontSize() {
        return this.e;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public float getRotate() {
        return this.i;
    }

    public String getText() {
        return this.f5863a;
    }

    public Typeface getTypeface() {
        return this.f;
    }

    public boolean isClickable() {
        return this.k;
    }

    public void setAlign(int i, int i2) {
        this.g = i;
        this.h = i2;
        this.j = 1;
        this.listener.c(this);
    }

    public void setBgColor(int i) {
        this.c = i;
        this.j = 1;
        this.listener.c(this);
    }

    public void setClickable(boolean z) {
        this.k = z;
        this.listener.c(this);
    }

    public void setFontColor(int i) {
        this.d = i;
        this.j = 1;
        this.listener.c(this);
    }

    public void setFontSize(int i) {
        this.e = i;
        this.j = 1;
        this.listener.c(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.b = latLng;
            this.j = 1;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public void setRotate(float f) {
        this.i = f;
        this.j = 1;
        this.listener.c(this);
    }

    public void setText(String str) {
        if (str != null && !str.equals("")) {
            this.f5863a = str;
            this.j = 1;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
    }

    public void setTypeface(Typeface typeface) {
        this.f = typeface;
        this.j = 1;
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a() {
        Typeface typeface = this.f;
        if (typeface != null) {
            EnvDrawText.removeFontCache(typeface.hashCode());
        }
        return super.a();
    }
}
