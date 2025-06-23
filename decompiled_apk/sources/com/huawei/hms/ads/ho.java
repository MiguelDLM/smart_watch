package com.huawei.hms.ads;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.iab.omid.library.huawei.adsession.media.Position;

/* loaded from: classes10.dex */
public enum ho implements hh {
    PREROLL(IAdInterListener.AdProdType.PRODUCT_PREROLL),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean B;
    private final String C;

    /* renamed from: com.huawei.hms.ads.ho$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[ho.values().length];
            Code = iArr;
            try {
                iArr[ho.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[ho.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[ho.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[ho.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = gw.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    ho(String str) {
        this.C = str;
    }

    public static Position Code(ho hoVar) {
        if (!B) {
            return null;
        }
        int i = AnonymousClass1.Code[hoVar.ordinal()];
        if (i == 1 || i == 2) {
            return Position.PREROLL;
        }
        if (i == 3) {
            return Position.POSTROLL;
        }
        if (i != 4) {
            return null;
        }
        return Position.STANDALONE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }

    public static boolean Code() {
        return B;
    }
}
