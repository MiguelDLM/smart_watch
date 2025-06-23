package com.jd.ad.sdk.jad_jt;

/* loaded from: classes10.dex */
public final /* synthetic */ class jad_fs {
    public static final /* synthetic */ int[] jad_an = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static /* synthetic */ int jad_an(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] jad_bo(int i) {
        int[] iArr = new int[i];
        System.arraycopy(jad_an, 0, iArr, 0, i);
        return iArr;
    }

    public static /* synthetic */ boolean jad_an(int i, int i2) {
        if (i != 0) {
            return i == i2;
        }
        throw null;
    }
}
