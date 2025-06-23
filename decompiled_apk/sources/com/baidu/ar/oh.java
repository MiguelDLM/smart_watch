package com.baidu.ar;

/* loaded from: classes7.dex */
public class oh extends Exception {
    private static final long serialVersionUID = 3731842424390998726L;
    private final int Jk;

    public oh(int i) {
        this.Jk = i;
    }

    public int jy() {
        return this.Jk;
    }

    public oh(int i, String str) {
        super(str);
        this.Jk = i;
    }

    public oh(int i, Throwable th) {
        super(th);
        this.Jk = i;
    }
}
