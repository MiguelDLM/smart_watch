package com.realsil.sdk.dfu.model;

/* loaded from: classes11.dex */
public class FileTypeInfo {

    /* renamed from: a, reason: collision with root package name */
    public int f19581a;
    public String b;
    public boolean c;

    public FileTypeInfo(int i, String str) {
        this.f19581a = i;
        this.b = str;
    }

    public int getBitNumber() {
        return this.f19581a;
    }

    public String getName() {
        return this.b;
    }

    public boolean isSelected() {
        return this.c;
    }

    public void setBitNumber(int i) {
        this.f19581a = i;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setSelected(boolean z) {
        this.c = z;
    }
}
