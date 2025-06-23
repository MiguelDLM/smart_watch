package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.InteractionType;

/* loaded from: classes10.dex */
public enum hm implements hh {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");

    private static boolean Z;
    String I;

    /* renamed from: com.huawei.hms.ads.hm$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hm.values().length];
            Code = iArr;
            try {
                iArr[hm.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hm.INVITATION_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Z = false;
        Z = gw.Code("com.iab.omid.library.huawei.adsession.media.InteractionType");
    }

    hm(String str) {
        this.I = str;
    }

    public static InteractionType Code(hm hmVar) {
        if (!Z) {
            return null;
        }
        int i = AnonymousClass1.Code[hmVar.ordinal()];
        if (i == 1) {
            return InteractionType.CLICK;
        }
        if (i != 2) {
            return null;
        }
        return InteractionType.INVITATION_ACCEPTED;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.I;
    }

    public static boolean Code() {
        return Z;
    }
}
