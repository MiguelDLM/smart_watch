package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: classes10.dex */
public class cl {
    private static volatile cw Code;
    private static final byte[] V = new byte[0];

    public static cw Code(Context context) {
        if (Code == null) {
            synchronized (V) {
                try {
                    if (Code == null) {
                        Code = ck.Z(context) ? cr.Code(context) : ct.Code(context);
                    }
                } finally {
                }
            }
        }
        return Code;
    }
}
