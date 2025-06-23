package com.baidu.tts;

/* loaded from: classes8.dex */
public class x3 {
    public static final String c = "x3";

    /* renamed from: a, reason: collision with root package name */
    public z3 f10196a;
    public a b;

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f10197a = false;

        public a() {
        }
    }

    public x3(z3 z3Var) {
        this.b = null;
        this.f10196a = z3Var;
        this.b = new a();
    }

    public byte[] a(int i, int i2, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i3 = length + 4;
        byte[] bArr2 = new byte[length + 8];
        bArr2[0] = (byte) (i3 & 255);
        bArr2[1] = (byte) ((i3 >> 8) & 255);
        bArr2[2] = (byte) ((i3 >> 16) & 255);
        bArr2[3] = (byte) ((i3 >> 24) & 255);
        bArr2[4] = 1;
        bArr2[5] = (byte) i2;
        bArr2[6] = 0;
        bArr2[7] = (byte) i;
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        return bArr2;
    }
}
