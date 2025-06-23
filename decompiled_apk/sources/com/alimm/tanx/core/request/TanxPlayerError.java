package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class TanxPlayerError extends TanxError {
    private int extra;
    private int what;

    public TanxPlayerError(String str) {
        super(str);
    }

    @Override // com.alimm.tanx.core.request.TanxError, java.lang.Throwable
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
