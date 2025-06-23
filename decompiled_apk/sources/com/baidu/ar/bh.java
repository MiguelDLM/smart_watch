package com.baidu.ar;

/* loaded from: classes7.dex */
public class bh extends n {
    private String kd;
    private String ke;
    private Object kf;
    private a kg;

    /* loaded from: classes7.dex */
    public enum a {
        INT,
        FLOAT,
        FLOAT_ARRAY,
        STRING
    }

    private void b(Object obj) {
        a aVar;
        if ((obj instanceof Float) || (obj instanceof Double)) {
            aVar = a.FLOAT;
        } else if (obj instanceof String) {
            aVar = a.STRING;
        } else if (obj instanceof Integer) {
            aVar = a.INT;
        } else if (!(obj instanceof float[])) {
            return;
        } else {
            aVar = a.FLOAT_ARRAY;
        }
        this.kg = aVar;
    }

    public void L(String str) {
        this.ke = str;
    }

    public void a(Object obj) {
        this.kf = obj;
        b(obj);
    }

    public String bI() {
        return this.ke;
    }

    public Object bJ() {
        return this.kf;
    }

    public a bK() {
        return this.kg;
    }

    public String getFilterName() {
        return this.kd;
    }

    public void setFilterName(String str) {
        this.kd = str;
    }
}
