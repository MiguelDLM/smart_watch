package me.devilsen.czxing.code;

/* loaded from: classes6.dex */
public class EncodeEngine {
    static {
        System.loadLibrary("czxing");
    }

    private native int nativeWriteCode(String str, int i, int i2, int i3, String str2, int i4, int i5, Object[] objArr);

    public int oIX0oI(String str, int i, int i2, int i3, BarcodeFormat barcodeFormat, int i4, int i5, Object[] objArr) {
        return nativeWriteCode(str, i, i2, i3, barcodeFormat.name(), i4, i5, objArr);
    }

    public native int writeCodeByte(String str, String str2, Object[] objArr);
}
