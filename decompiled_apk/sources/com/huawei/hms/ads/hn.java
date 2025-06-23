package com.huawei.hms.ads;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.iab.omid.library.huawei.adsession.media.PlayerState;

/* loaded from: classes10.dex */
public enum hn implements hh {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL(PrerollVideoResponse.NORMAL),
    EXPANDED(XXooOOI.oIX0oI.f4116Oxx0IOOO),
    FULLSCREEN("fullscreen");

    private static boolean C;
    private final String S;

    /* renamed from: com.huawei.hms.ads.hn$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hn.values().length];
            Code = iArr;
            try {
                iArr[hn.MINIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hn.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hn.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hn.EXPANDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[hn.FULLSCREEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C = false;
        C = gw.Code("com.iab.omid.library.huawei.adsession.media.PlayerState");
    }

    hn(String str) {
        this.S = str;
    }

    public static PlayerState Code(hn hnVar) {
        if (!C) {
            return null;
        }
        int i = AnonymousClass1.Code[hnVar.ordinal()];
        if (i == 1) {
            return PlayerState.MINIMIZED;
        }
        if (i == 2) {
            return PlayerState.COLLAPSED;
        }
        if (i == 3) {
            return PlayerState.NORMAL;
        }
        if (i == 4) {
            return PlayerState.EXPANDED;
        }
        if (i != 5) {
            return null;
        }
        return PlayerState.FULLSCREEN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }

    public static boolean Code() {
        return C;
    }
}
