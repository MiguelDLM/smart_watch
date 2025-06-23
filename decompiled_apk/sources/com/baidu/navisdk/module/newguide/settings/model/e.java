package com.baidu.navisdk.module.newguide.settings.model;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f7278a;
    public String b;
    public boolean c = true;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass() && this.f7278a == ((e) obj).f7278a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f7278a;
    }

    public String toString() {
        return "SettingGroupTitleModel{type=" + this.f7278a + ", title='" + this.b + "', isSupportDrag=" + this.c + '}';
    }
}
