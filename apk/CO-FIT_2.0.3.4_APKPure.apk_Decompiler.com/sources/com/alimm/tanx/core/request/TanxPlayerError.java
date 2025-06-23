package com.alimm.tanx.core.request;

public class TanxPlayerError extends TanxError {
    private int extra;
    private int what;

    public TanxPlayerError(String str) {
        super(str);
    }

    public String toString() {
        return "TanxPlayerError : what->" + this.what + "  extra -> " + this.extra + "  message-> " + getMessage();
    }

    public TanxPlayerError(String str, String str2) {
        super(str, str2);
    }

    public TanxPlayerError(String str, int i, int i2) {
        this(str);
        this.what = i;
        this.extra = i2;
    }
}
