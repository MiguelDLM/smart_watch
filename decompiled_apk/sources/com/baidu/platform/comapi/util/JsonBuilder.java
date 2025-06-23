package com.baidu.platform.comapi.util;

import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class JsonBuilder {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f9683a = new StringBuilder();
    private boolean b = false;

    private void a() {
        if (this.b) {
            this.f9683a.append(",");
        }
    }

    private void b() {
        this.b = false;
    }

    private void c() {
        this.b = true;
    }

    public JsonBuilder arrayValue() {
        a();
        this.f9683a.append("[");
        b();
        return this;
    }

    public JsonBuilder endArrayValue() {
        this.f9683a.append("]");
        c();
        return this;
    }

    public JsonBuilder endObject() {
        this.f9683a.append(ooOOo0oXI.f33074oOoXoXO);
        c();
        return this;
    }

    public String getJson() {
        return this.f9683a.toString();
    }

    public JsonBuilder key(String str) {
        a();
        this.f9683a.append(JSONObject.quote(str));
        this.f9683a.append(":");
        b();
        return this;
    }

    public JsonBuilder object() {
        a();
        this.f9683a.append("{");
        b();
        return this;
    }

    public JsonBuilder objectValue(String str) {
        a();
        this.f9683a.append(str);
        c();
        return this;
    }

    public JsonBuilder putObjectValue(String str, String str2) {
        if (str2 != null) {
            key(str).objectValue(str2);
        }
        return this;
    }

    public JsonBuilder putStringValue(String str, String str2) {
        if (str2 != null) {
            key(str).value(str2);
        }
        return this;
    }

    public void reset() {
        this.f9683a.setLength(0);
        this.b = false;
    }

    public String toString() {
        return getJson();
    }

    public JsonBuilder value(boolean z) {
        a();
        this.f9683a.append(z);
        c();
        return this;
    }

    public JsonBuilder valueDirect(String str) {
        a();
        this.f9683a.append(str);
        c();
        return this;
    }

    public JsonBuilder value(int i) {
        a();
        this.f9683a.append(i);
        c();
        return this;
    }

    public JsonBuilder value(long j) {
        a();
        this.f9683a.append(j);
        c();
        return this;
    }

    public JsonBuilder value(double d) {
        a();
        this.f9683a.append(String.format("%f", Double.valueOf(d)));
        c();
        return this;
    }

    public JsonBuilder value(String str) {
        a();
        this.f9683a.append(JSONObject.quote(str));
        c();
        return this;
    }

    public JsonBuilder value(Object obj) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (obj instanceof Byte) {
                return value((int) number.byteValue());
            }
            if (obj instanceof Short) {
                return value((int) number.shortValue());
            }
            if (obj instanceof Integer) {
                return value(number.intValue());
            }
            if (obj instanceof Long) {
                return value(number.longValue());
            }
            if (obj instanceof Float) {
                return value(number.floatValue());
            }
            if (obj instanceof Double) {
                return value(number.doubleValue());
            }
        }
        return value(obj.toString());
    }
}
