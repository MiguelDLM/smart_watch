package com.realsil.sdk.dfu.model;

/* loaded from: classes11.dex */
public class OtaModeInfo {

    /* renamed from: a, reason: collision with root package name */
    public int f19583a;
    public String b;

    public OtaModeInfo(int i) {
        this.f19583a = i;
    }

    public String getName() {
        return this.b;
    }

    public int getWorkmode() {
        return this.f19583a;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setWorkmode(int i) {
        this.f19583a = i;
    }

    public OtaModeInfo(int i, String str) {
        this.f19583a = i;
        this.b = str;
    }
}
