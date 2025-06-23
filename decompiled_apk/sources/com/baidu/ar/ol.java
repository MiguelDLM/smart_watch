package com.baidu.ar;

/* loaded from: classes7.dex */
public class ol extends oh {
    private static final long serialVersionUID = 6908339749836826785L;
    private final int limit;

    public ol() {
        this(Integer.MAX_VALUE);
    }

    public int getLimit() {
        return this.limit;
    }

    public ol(int i) {
        super(1009);
        this.limit = i;
    }

    public ol(String str) {
        this(str, Integer.MAX_VALUE);
    }

    public ol(String str, int i) {
        super(1009, str);
        this.limit = i;
    }
}
