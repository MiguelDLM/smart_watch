package com.huawei.hms.ads;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.iab.omid.library.huawei.adsession.media.Position;

/* loaded from: classes10.dex */
public enum ht implements hh {
    PREROLL(IAdInterListener.AdProdType.PRODUCT_PREROLL),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean B;
    private final String C;

    /* renamed from: com.huawei.hms.ads.ht$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[ht.values().length];
            Code = iArr;
            try {
                iArr[ht.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[ht.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[ht.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[ht.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = gw.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    ht(String str) {
        this.C = str;
    }

    public static Position Code(ht htVar) {
        if (!B) {
            return null;
        }
        int i = AnonymousClass1.Code[htVar.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return Position.POSTROLL;
            }
            if (i != 4) {
                return null;
            }
            return Position.STANDALONE;
        }
        return Position.PREROLL;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }

    public static boolean Code() {
        return B;
    }
}
