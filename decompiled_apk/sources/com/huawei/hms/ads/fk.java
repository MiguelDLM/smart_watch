package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public class fk {
    private static final String Code = "fk";

    public static fj Code(int i, kk kkVar) {
        fb.V(Code, "create ad mediator: %s", Integer.valueOf(i));
        return (i == 2 || i == 3) ? new fm(kkVar) : new fl(kkVar);
    }
}
