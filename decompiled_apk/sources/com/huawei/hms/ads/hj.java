package com.huawei.hms.ads;

import com.facebook.internal.AnalyticsEvents;
import com.iab.omid.library.huawei.adsession.Owner;

/* loaded from: classes10.dex */
public enum hj implements hh {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");

    private static boolean Z;
    private final String B;

    /* renamed from: com.huawei.hms.ads.hj$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hj.values().length];
            Code = iArr;
            try {
                iArr[hj.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hj.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hj.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Z = false;
        Z = gw.Code(gw.o);
    }

    hj(String str) {
        this.B = str;
    }

    public static Owner Code(hj hjVar) {
        if (!Z) {
            return null;
        }
        int i = AnonymousClass1.Code[hjVar.ordinal()];
        if (i == 1) {
            return Owner.NATIVE;
        }
        if (i == 2) {
            return Owner.JAVASCRIPT;
        }
        if (i != 3) {
            return null;
        }
        return Owner.NONE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.B;
    }

    public static boolean Code() {
        return Z;
    }
}
