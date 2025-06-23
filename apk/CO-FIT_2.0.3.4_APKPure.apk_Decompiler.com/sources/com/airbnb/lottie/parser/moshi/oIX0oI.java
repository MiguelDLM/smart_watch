package com.airbnb.lottie.parser.moshi;

public final class oIX0oI {

    /* renamed from: I0Io  reason: collision with root package name */
    public static final int f1067I0Io = 3;

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public static final int f1068II0XooXoX = 8;

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final int f1069II0xO0 = 2;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public static final int f1070Oxx0IOOO = 7;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public static final int f1071X0o0xo = 5;

    /* renamed from: XO  reason: collision with root package name */
    public static final int f1072XO = 6;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final int f1073oIX0oI = 1;

    /* renamed from: oxoX  reason: collision with root package name */
    public static final int f1074oxoX = 4;

    public static String oIX0oI(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(iArr2[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = strArr[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
