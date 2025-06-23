package com.baidu.navisdk.ui.routeguide.model;

/* loaded from: classes8.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private String f8981a;
    private boolean b;

    public w(String str, boolean z) {
        this.f8981a = str;
        this.b = z;
    }

    public String a() {
        return this.f8981a;
    }

    public boolean b() {
        return this.b;
    }

    public String toString() {
        return "RGRepeatBroadcastModel{speechIdStr='" + this.f8981a + "', isPlayEnd=" + this.b + '}';
    }

    public void a(boolean z) {
        this.b = z;
    }
}
