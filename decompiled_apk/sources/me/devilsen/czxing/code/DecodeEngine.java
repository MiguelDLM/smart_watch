package me.devilsen.czxing.code;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class DecodeEngine {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f30853oIX0oI;

    static {
        System.loadLibrary("czxing");
    }

    public DecodeEngine(int[] iArr) {
        this.f30853oIX0oI = nativeCreateInstance(iArr);
    }

    private native long nativeCreateInstance(int[] iArr);

    private native CodeResult[] nativeDecodeBitmap(long j, Bitmap bitmap);

    private native CodeResult[] nativeDecodeByte(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6);

    private native void nativeDestroyInstance(long j);

    private native double nativeDetectBrightness(long j, byte[] bArr, int i, int i2);

    private native void nativeSetDetectModel(long j, String str, String str2, String str3, String str4);

    private native void nativeSetFormat(long j, int[] iArr);

    public void I0Io() {
        long j = this.f30853oIX0oI;
        if (j != 0) {
            nativeDestroyInstance(j);
            this.f30853oIX0oI = 0L;
        }
    }

    public CodeResult[] II0xO0(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        return nativeDecodeByte(this.f30853oIX0oI, bArr, i, i2, i3, i4, i5, i6);
    }

    public void X0o0xo(String str, String str2, String str3, String str4) {
        nativeSetDetectModel(this.f30853oIX0oI, str, str2, str3, str4);
    }

    public void XO(int[] iArr) {
        nativeSetFormat(this.f30853oIX0oI, iArr);
    }

    public void finalize() throws Throwable {
        try {
            I0Io();
        } finally {
            super.finalize();
        }
    }

    public CodeResult[] oIX0oI(Bitmap bitmap) {
        return nativeDecodeBitmap(this.f30853oIX0oI, bitmap);
    }

    public double oxoX(byte[] bArr, int i, int i2) {
        return nativeDetectBrightness(this.f30853oIX0oI, bArr, i, i2);
    }
}
