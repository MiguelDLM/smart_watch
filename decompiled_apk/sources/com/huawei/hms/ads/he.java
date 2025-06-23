package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.ErrorType;

/* loaded from: classes10.dex */
public enum he implements hh {
    GENERIC("generic"),
    VIDEO("video");

    private static final boolean I = gw.Code(gw.l);
    private final String Z;

    /* renamed from: com.huawei.hms.ads.he$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[he.values().length];
            Code = iArr;
            try {
                iArr[he.GENERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[he.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    he(String str) {
        this.Z = str;
    }

    public static ErrorType Code(he heVar) {
        if (!I) {
            return null;
        }
        int i = AnonymousClass1.Code[heVar.ordinal()];
        if (i == 1) {
            return ErrorType.GENERIC;
        }
        if (i != 2) {
            return null;
        }
        return ErrorType.VIDEO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Z;
    }

    public static boolean Code() {
        return I;
    }
}
