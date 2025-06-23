package com.baidu.navisdk.module.newguide.settings.shortcut.beans;

import androidx.annotation.DrawableRes;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f7279a;
    public String b;

    @DrawableRes
    public int c;
    public int d;
    public int e;
    public C0256a f;
    public boolean g;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.shortcut.beans.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0256a {
    }

    public a() {
        this.f7279a = 0;
        this.d = -1;
        this.e = 0;
        this.g = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass() && this.f7279a == ((a) obj).f7279a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f7279a;
    }

    public String toString() {
        return "RGShortcutFunData{id=" + this.f7279a + ", title='" + this.b + "', drawableRes=" + this.c + ", tipType=" + this.e + ", tip=" + this.f + ", position=" + this.d + ", isAdded=" + this.g + '}';
    }

    public a(int i) {
        this.d = -1;
        this.e = 0;
        this.g = false;
        this.f7279a = i;
    }
}
