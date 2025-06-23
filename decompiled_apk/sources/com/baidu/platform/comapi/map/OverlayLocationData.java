package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

/* loaded from: classes8.dex */
public class OverlayLocationData {

    /* renamed from: a, reason: collision with root package name */
    private String f9628a;
    private String b;
    private Bitmap c;
    private int d;
    private int e;
    private String f;
    private float g;
    private float h;
    private int i;
    private int j;

    public float getArrowSize() {
        return this.h;
    }

    public String getGIFImgPath() {
        return this.f;
    }

    public Bitmap getImage() {
        return this.c;
    }

    public int getImgHeight() {
        return this.e;
    }

    public String getImgName() {
        return this.f9628a;
    }

    public String getImgType() {
        return this.b;
    }

    public int getImgWidth() {
        return this.d;
    }

    public float getMarkerSize() {
        return this.g;
    }

    public int isAnimation() {
        return this.j;
    }

    public int isRotation() {
        return this.i;
    }

    public void setAnimation(int i) {
        this.j = i;
    }

    public void setArrowSize(float f) {
        this.h = f;
    }

    public void setGIFImgPath(String str) {
        this.f = str;
    }

    public void setImage(Bitmap bitmap) {
        this.c = bitmap;
    }

    public void setImgHeight(int i) {
        this.e = i;
    }

    public void setImgName(String str) {
        this.f9628a = str;
    }

    public void setImgType(String str) {
        this.b = str;
    }

    public void setImgWidth(int i) {
        this.d = i;
    }

    public void setMarkerSize(float f) {
        this.g = f;
    }

    public void setRotation(int i) {
        this.i = i;
    }
}
