package com.baidu.ar;

/* loaded from: classes7.dex */
public enum fd {
    WORLD(0),
    RELATIVE(1);

    private int st;

    fd(int i) {
        this.st = i;
    }

    public static fd A(int i) {
        for (fd fdVar : values()) {
            if (fdVar.getTypeValue() == i) {
                return fdVar;
            }
        }
        return null;
    }

    public int getTypeValue() {
        return this.st;
    }
}
