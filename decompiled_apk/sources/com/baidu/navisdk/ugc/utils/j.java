package com.baidu.navisdk.ugc.utils;

/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f8342a;

    public j() {
        this(32);
    }

    public StringBuilder a(String str, int i) {
        if (com.baidu.navisdk.util.common.g.UGC.d()) {
            StringBuilder sb = this.f8342a;
            sb.append(str);
            sb.append("=");
            sb.append(String.valueOf(i));
            sb.append(", ");
            return sb;
        }
        return this.f8342a;
    }

    public String toString() {
        StringBuilder sb = this.f8342a;
        if (sb != null) {
            return sb.toString();
        }
        return "null";
    }

    public j(int i) {
        if (com.baidu.navisdk.util.common.g.UGC.d()) {
            this.f8342a = new StringBuilder(i);
        } else {
            this.f8342a = new StringBuilder(0);
        }
    }

    public StringBuilder a(String str, String str2) {
        if (com.baidu.navisdk.util.common.g.UGC.d()) {
            StringBuilder sb = this.f8342a;
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            sb.append(", ");
            return sb;
        }
        return this.f8342a;
    }

    public StringBuilder a(String str) {
        if (com.baidu.navisdk.util.common.g.UGC.d()) {
            StringBuilder sb = this.f8342a;
            sb.append(str);
            sb.append(", ");
            return sb;
        }
        return this.f8342a;
    }
}
