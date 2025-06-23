package com.baidu.platform.comapi.wnplatform.e.a;

import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f9904a = new StringBuilder();
    private boolean b = false;

    private void d() {
        if (this.b) {
            this.f9904a.append(",");
        }
    }

    private void e() {
        this.b = false;
    }

    private void f() {
        this.b = true;
    }

    public a a() {
        d();
        this.f9904a.append("{");
        e();
        return this;
    }

    public a b() {
        this.f9904a.append(ooOOo0oXI.f33074oOoXoXO);
        f();
        return this;
    }

    public String c() {
        return this.f9904a.toString();
    }

    public String toString() {
        return c();
    }

    public a b(String str) {
        d();
        this.f9904a.append(JSONObject.quote(str));
        f();
        return this;
    }

    public a a(String str) {
        d();
        this.f9904a.append(JSONObject.quote(str));
        this.f9904a.append(":");
        e();
        return this;
    }

    public a a(boolean z) {
        d();
        this.f9904a.append(z);
        f();
        return this;
    }

    public a a(int i) {
        d();
        this.f9904a.append(i);
        f();
        return this;
    }

    public a a(long j) {
        d();
        this.f9904a.append(j);
        f();
        return this;
    }

    public a a(double d) {
        d();
        this.f9904a.append(String.format("%f", Double.valueOf(d)));
        f();
        return this;
    }

    public a a(Object obj) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (obj instanceof Byte) {
                return a((int) number.byteValue());
            }
            if (obj instanceof Short) {
                return a((int) number.shortValue());
            }
            if (obj instanceof Integer) {
                return a(number.intValue());
            }
            if (obj instanceof Long) {
                return a(number.longValue());
            }
            if (obj instanceof Float) {
                return a(number.floatValue());
            }
            if (obj instanceof Double) {
                return a(number.doubleValue());
            }
        }
        return b(obj.toString());
    }
}
