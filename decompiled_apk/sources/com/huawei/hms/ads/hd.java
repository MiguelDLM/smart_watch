package com.huawei.hms.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import com.iab.omid.library.huawei.adsession.CreativeType;

/* loaded from: classes10.dex */
public enum hd implements hh {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);

    private static boolean C;
    private final String S;

    /* renamed from: com.huawei.hms.ads.hd$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hd.values().length];
            Code = iArr;
            try {
                iArr[hd.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hd.HTML_DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hd.NATIVE_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hd.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[hd.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C = false;
        C = gw.Code(gw.k);
    }

    hd(String str) {
        this.S = str;
    }

    public static CreativeType Code(hd hdVar) {
        if (!C) {
            return null;
        }
        int i = AnonymousClass1.Code[hdVar.ordinal()];
        if (i == 1) {
            return CreativeType.DEFINED_BY_JAVASCRIPT;
        }
        if (i == 2) {
            return CreativeType.HTML_DISPLAY;
        }
        if (i == 3) {
            return CreativeType.NATIVE_DISPLAY;
        }
        if (i == 4) {
            return CreativeType.VIDEO;
        }
        if (i != 5) {
            return null;
        }
        return CreativeType.AUDIO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }

    public static boolean Code() {
        return C;
    }
}
