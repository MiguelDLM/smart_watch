package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.mutable.MutableInt;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: o00, reason: collision with root package name */
    public static final int f32761o00 = -1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final boolean[] f32763oIX0oI = new boolean[0];

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Boolean[] f32751II0xO0 = new Boolean[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public static final byte[] f32749I0Io = new byte[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Byte[] f32767oxoX = new Byte[0];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final char[] f32759X0o0xo = new char[0];

    /* renamed from: XO, reason: collision with root package name */
    public static final Character[] f32760XO = new Character[0];

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Class<?>[] f32756Oxx0IOOO = new Class[0];

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final double[] f32750II0XooXoX = new double[0];

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Double[] f32772xxIXOIIO = new Double[0];

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Field[] f32770xoIox = new Field[0];

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final float[] f32754OOXIXo = new float[0];

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Float[] f32765oOoXoXO = new Float[0];

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int[] f32766ooOOo0oXI = new int[0];

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final Integer[] f32768x0XOIxOo = new Integer[0];

    /* renamed from: oO, reason: collision with root package name */
    public static final long[] f32764oO = new long[0];

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final Long[] f32769x0xO0oo = new Long[0];

    /* renamed from: Oo, reason: collision with root package name */
    public static final Method[] f32755Oo = new Method[0];

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final Object[] f32753IXxxXO = new Object[0];

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final short[] f32757Oxx0xo = new short[0];

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final Short[] f32762oI0IIXIo = new Short[0];

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String[] f32758OxxIIOOXO = new String[0];

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final Throwable[] f32752IIXOooo = new Throwable[0];

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final Type[] f32771xoXoI = new Type[0];

    public static int I0(short[] sArr, short s, int i) {
        if (sArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < sArr.length) {
            if (s == sArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int[] I00O(int[] iArr, int i) {
        return (int[]) OIxOX(iArr, i);
    }

    @Deprecated
    public static byte[] I0Io(byte[] bArr, int i, byte b) {
        return (byte[]) oIX0oI(bArr, i, Byte.valueOf(b), Byte.TYPE);
    }

    public static void I0O00OI(float[] fArr, int i, int i2, int i3) {
        if (!X0xxXX0(fArr) && i < fArr.length && i2 < fArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, fArr.length - i), fArr.length - i2);
            while (i4 < min) {
                float f = fArr[i];
                fArr[i] = fArr[i2];
                fArr[i2] = f;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static void I0OO(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return;
        }
        int min = Math.min(cArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            char c = cArr[min];
            cArr[min] = cArr[max];
            cArr[max] = c;
            min--;
        }
    }

    public static Object I0X0x0oIo(Object obj, Class<?> cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, newInstance, 0, length);
            return newInstance;
        }
        return Array.newInstance(cls, 1);
    }

    public static int[] I0XIOxO(Integer[] numArr, int i) {
        int intValue;
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return f32766ooOOo0oXI;
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            if (num == null) {
                intValue = i;
            } else {
                intValue = num.intValue();
            }
            iArr[i2] = intValue;
        }
        return iArr;
    }

    public static int I0oOIX(byte[] bArr, byte b) {
        return xoxXI(bArr, b, 0);
    }

    public static boolean I0oOoX(double[] dArr, double d, double d2) {
        if (XIo0oOXIx(dArr, d, 0, d2) != -1) {
            return true;
        }
        return false;
    }

    public static boolean I0xX0(double[] dArr) {
        return !X0xII0I(dArr);
    }

    public static byte[] II0(Byte[] bArr, byte b) {
        byte byteValue;
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return f32749I0Io;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            Byte b2 = bArr[i];
            if (b2 == null) {
                byteValue = b;
            } else {
                byteValue = b2.byteValue();
            }
            bArr2[i] = byteValue;
        }
        return bArr2;
    }

    public static void II0OOXOx(boolean[] zArr, int i, int i2, int i3) {
        if (zArr != null && i < zArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= zArr.length) {
                i2 = zArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    oIxOXo(zArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    oIxOXo(zArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    oIxOXo(zArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static float[] II0XooXoX(float[] fArr, float f) {
        float[] fArr2 = (float[]) I0X0x0oIo(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f;
        return fArr2;
    }

    public static byte[] II0xO0(byte[] bArr, byte b) {
        byte[] bArr2 = (byte[]) I0X0x0oIo(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b;
        return bArr2;
    }

    public static boolean[] IIIxO(boolean[] zArr, boolean z) {
        int ooOx2 = ooOx(zArr, z);
        if (ooOx2 == -1) {
            return OI0(zArr);
        }
        return xXo(zArr, ooOx2);
    }

    public static int IIOIX(long[] jArr, long j, int i) {
        if (jArr == null || i < 0) {
            return -1;
        }
        if (i >= jArr.length) {
            i = jArr.length - 1;
        }
        while (i >= 0) {
            if (j == jArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static BitSet IIX0(double[] dArr, double d, int i, double d2) {
        int XIo0oOXIx2;
        BitSet bitSet = new BitSet();
        if (dArr == null) {
            return bitSet;
        }
        int i2 = i;
        while (i2 < dArr.length && (XIo0oOXIx2 = XIo0oOXIx(dArr, d, i2, d2)) != -1) {
            bitSet.set(XIo0oOXIx2);
            i2 = XIo0oOXIx2 + 1;
        }
        return bitSet;
    }

    public static int[] IIX0o(int[] iArr, int i) {
        if (iArr == null) {
            return xoIox(iArr, i);
        }
        return oI(0, iArr, i);
    }

    public static double[] IIXOooo(double[] dArr, double... dArr2) {
        if (dArr == null) {
            return Xx000oIo(dArr2);
        }
        if (dArr2 == null) {
            return Xx000oIo(dArr);
        }
        double[] dArr3 = new double[dArr.length + dArr2.length];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static void IIXOxIxOo(int[] iArr, int i, int i2, int i3) {
        if (!IO0XoXxO(iArr) && i < iArr.length && i2 < iArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, iArr.length - i), iArr.length - i2);
            while (i4 < min) {
                int i5 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i5;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static void IIoX0OoI(double[] dArr, int i) {
        if (dArr == null) {
            return;
        }
        oOIXoIXXI(dArr, 0, dArr.length, i);
    }

    public static int IIxOXoOo0(short[] sArr, short s) {
        return I0(sArr, s, 0);
    }

    public static int[] IO(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static boolean IO0XoXxO(int[] iArr) {
        if (XoI0Ixx0(iArr) == 0) {
            return true;
        }
        return false;
    }

    public static void IO0xX(boolean[] zArr, int i) {
        if (zArr == null) {
            return;
        }
        II0OOXOx(zArr, 0, zArr.length, i);
    }

    public static void IOI(Object[] objArr, int i, int i2) {
        if (objArr == null) {
            return;
        }
        int min = Math.min(objArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            Object obj = objArr[min];
            objArr[min] = objArr[max];
            objArr[max] = obj;
            min--;
        }
    }

    public static void IOOXOOOOo(byte[] bArr, int i, int i2, int i3) {
        if (bArr != null && i < bArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= bArr.length) {
                i2 = bArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    oxO(bArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    oxO(bArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    oxO(bArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static float[] IOOoXo0Ix(float[] fArr) {
        if (X0xxXX0(fArr)) {
            return f32754OOXIXo;
        }
        return fArr;
    }

    public static void IOXOxOII(int[] iArr) {
        if (iArr == null) {
            return;
        }
        oXxOXOX(iArr, 0, iArr.length);
    }

    public static void IOo0(byte[] bArr) {
        XxIOX(bArr, new Random());
    }

    public static boolean IOoo(boolean[] zArr) {
        if (XoI0Ixx0(zArr) == 0) {
            return true;
        }
        return false;
    }

    public static void IOooo0o(long[] jArr) {
        OX00o0X(jArr, new Random());
    }

    public static void IXI(char[] cArr, int i, int i2) {
        if (x0(cArr)) {
            return;
        }
        XOx(cArr, i, i2, 1);
    }

    public static void IXIIo(byte[] bArr, int i, int i2) {
        if (x0OxxIOxX(bArr)) {
            return;
        }
        oxO(bArr, i, i2, 1);
    }

    public static float[] IXIxx0(float[] fArr, float f) {
        int Ioxxx2 = Ioxxx(fArr, f);
        if (Ioxxx2 == -1) {
            return X00IoxXI(fArr);
        }
        return x0oox0(fArr, Ioxxx2);
    }

    public static float[] IXO(int i, float[] fArr, float... fArr2) {
        if (fArr == null) {
            return null;
        }
        if (X0xxXX0(fArr2)) {
            return X00IoxXI(fArr);
        }
        if (i >= 0 && i <= fArr.length) {
            float[] fArr3 = new float[fArr.length + fArr2.length];
            System.arraycopy(fArr2, 0, fArr3, i, fArr2.length);
            if (i > 0) {
                System.arraycopy(fArr, 0, fArr3, 0, i);
            }
            if (i < fArr.length) {
                System.arraycopy(fArr, i, fArr3, fArr2.length + i, fArr.length - i);
            }
            return fArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + fArr.length);
    }

    @Deprecated
    public static double[] IXX(double[] dArr, double d) {
        return (double[]) o00xOoIO(dArr, oXIO0o0XI(dArr, d));
    }

    public static int[] IXXIXx00I(int[] iArr, int i) {
        int XX0xXo2 = XX0xXo(iArr, i);
        if (XX0xXo2 == -1) {
            return IO(iArr);
        }
        return I00O(iArr, XX0xXo2);
    }

    public static void IXo(long[] jArr, int i, int i2) {
        if (oXxOI0oIx(jArr)) {
            return;
        }
        xx0O(jArr, i, i2, 1);
    }

    public static char[] IXoIo(char[] cArr, int i) {
        return (char[]) OIxOX(cArr, i);
    }

    public static short[] IXxOIOO(short[] sArr, short s) {
        return (short[]) o00xOoIO(sArr, XIXIxO(sArr, s));
    }

    @Deprecated
    public static boolean[] IXxxXO(boolean[] zArr, int i, boolean z) {
        return (boolean[]) oIX0oI(zArr, i, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static boolean Io(byte[] bArr, byte b) {
        if (I0oOIX(bArr, b) != -1) {
            return true;
        }
        return false;
    }

    public static BitSet IoIOOxIIo(long[] jArr, long j, int i) {
        int ox2;
        BitSet bitSet = new BitSet();
        if (jArr == null) {
            return bitSet;
        }
        while (i < jArr.length && (ox2 = ox(jArr, j, i)) != -1) {
            bitSet.set(ox2);
            i = ox2 + 1;
        }
        return bitSet;
    }

    public static byte[] IoOoX(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static int IoOoo(char[] cArr, char c, int i) {
        if (cArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < cArr.length) {
            if (c == cArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Deprecated
    public static long[] IoX(long[] jArr, long j) {
        return (long[]) o00xOoIO(jArr, xI0oxI00(jArr, j));
    }

    public static short[] IoXIXo(int i, short[] sArr, short... sArr2) {
        if (sArr == null) {
            return null;
        }
        if (XI(sArr2)) {
            return XOxIOxOx(sArr);
        }
        if (i >= 0 && i <= sArr.length) {
            short[] sArr3 = new short[sArr.length + sArr2.length];
            System.arraycopy(sArr2, 0, sArr3, i, sArr2.length);
            if (i > 0) {
                System.arraycopy(sArr, 0, sArr3, 0, i);
            }
            if (i < sArr.length) {
                System.arraycopy(sArr, i, sArr3, sArr2.length + i, sArr.length - i);
            }
            return sArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + sArr.length);
    }

    public static void IoXO0XoX(short[] sArr, int i, int i2) {
        if (sArr == null) {
            return;
        }
        int min = Math.min(sArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            short s = sArr[min];
            sArr[min] = sArr[max];
            sArr[max] = s;
            min--;
        }
    }

    public static void IoxOx(char[] cArr, int i, int i2, int i3) {
        if (cArr != null && i < cArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= cArr.length) {
                i2 = cArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    XOx(cArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    XOx(cArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    XOx(cArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static boolean[] IoxX(boolean[] zArr, int i, int i2) {
        if (zArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > zArr.length) {
            i2 = zArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32763oIX0oI;
        }
        boolean[] zArr2 = new boolean[i3];
        System.arraycopy(zArr, i, zArr2, 0, i3);
        return zArr2;
    }

    public static int Ioxxx(float[] fArr, float f) {
        return xxIO(fArr, f, 0);
    }

    public static Boolean[] Ix0(Boolean[] boolArr) {
        if (XOxxooXI(boolArr)) {
            return f32751II0xO0;
        }
        return boolArr;
    }

    public static long[] Ix00oIoI(int i, long[] jArr, long... jArr2) {
        if (jArr == null) {
            return null;
        }
        if (oXxOI0oIx(jArr2)) {
            return xII(jArr);
        }
        if (i >= 0 && i <= jArr.length) {
            long[] jArr3 = new long[jArr.length + jArr2.length];
            System.arraycopy(jArr2, 0, jArr3, i, jArr2.length);
            if (i > 0) {
                System.arraycopy(jArr, 0, jArr3, 0, i);
            }
            if (i < jArr.length) {
                System.arraycopy(jArr, i, jArr3, jArr2.length + i, jArr.length - i);
            }
            return jArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + jArr.length);
    }

    public static int[] Ix0x(int[] iArr, int... iArr2) {
        return (int[]) IxI(iArr, iArr2);
    }

    public static Object IxI(Object obj, int... iArr) {
        int i;
        int i2;
        int XoI0Ixx02 = XoI0Ixx0(obj);
        int[] IO2 = IO(iArr);
        Arrays.sort(IO2);
        if (OX(IO2)) {
            int length = IO2.length;
            int i3 = XoI0Ixx02;
            i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                i2 = IO2[length];
                if (i2 < 0 || i2 >= XoI0Ixx02) {
                    break;
                }
                if (i2 < i3) {
                    i++;
                    i3 = i2;
                }
            }
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + XoI0Ixx02);
        }
        i = 0;
        int i4 = XoI0Ixx02 - i;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i4);
        if (i < XoI0Ixx02) {
            int length2 = IO2.length - 1;
            while (length2 >= 0) {
                int i5 = IO2[length2];
                int i6 = XoI0Ixx02 - i5;
                if (i6 > 1) {
                    int i7 = i6 - 1;
                    i4 -= i7;
                    System.arraycopy(obj, i5 + 1, newInstance, i4, i7);
                }
                length2--;
                XoI0Ixx02 = i5;
            }
            if (XoI0Ixx02 > 0) {
                System.arraycopy(obj, 0, newInstance, 0, XoI0Ixx02);
            }
        }
        return newInstance;
    }

    public static char[] IxIX0I(int i, char[] cArr, char... cArr2) {
        if (cArr == null) {
            return null;
        }
        if (x0(cArr2)) {
            return oOXoIIIo(cArr);
        }
        if (i >= 0 && i <= cArr.length) {
            char[] cArr3 = new char[cArr.length + cArr2.length];
            System.arraycopy(cArr2, 0, cArr3, i, cArr2.length);
            if (i > 0) {
                System.arraycopy(cArr, 0, cArr3, 0, i);
            }
            if (i < cArr.length) {
                System.arraycopy(cArr, i, cArr3, cArr2.length + i, cArr.length - i);
            }
            return cArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + cArr.length);
    }

    public static int IxIo(boolean[] zArr, boolean z) {
        return x0oxIIIX(zArr, z, Integer.MAX_VALUE);
    }

    public static void IxO0Oxo(double[] dArr, int i, int i2) {
        if (dArr == null) {
            return;
        }
        int min = Math.min(dArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            double d = dArr[min];
            dArr[min] = dArr[max];
            dArr[max] = d;
            min--;
        }
    }

    public static Boolean[] IxOIO(boolean[] zArr) {
        Boolean bool;
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return f32751II0xO0;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            if (zArr[i]) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            boolArr[i] = bool;
        }
        return boolArr;
    }

    public static void IxOXOxO(int[] iArr, int i, int i2) {
        if (IO0XoXxO(iArr)) {
            return;
        }
        IIXOxIxOo(iArr, i, i2, 1);
    }

    public static boolean IxX00(short[] sArr, short[] sArr2) {
        if (XoI0Ixx0(sArr) == XoI0Ixx0(sArr2)) {
            return true;
        }
        return false;
    }

    public static BitSet O0(int[] iArr, int i) {
        return xx0X0(iArr, i, 0);
    }

    public static boolean O00(float[] fArr, float[] fArr2) {
        if (XoI0Ixx0(fArr) == XoI0Ixx0(fArr2)) {
            return true;
        }
        return false;
    }

    public static int O00XxXI(long[] jArr, long j) {
        return ox(jArr, j, 0);
    }

    public static int[] O0IoXXOx(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > iArr.length) {
            i2 = iArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32766ooOOo0oXI;
        }
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, i, iArr2, 0, i3);
        return iArr2;
    }

    @SafeVarargs
    public static <T> T[] O0IxXx(int i, T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        if (XOxxooXI(tArr2)) {
            return (T[]) x0o(tArr);
        }
        if (i >= 0 && i <= tArr.length) {
            T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
            System.arraycopy(tArr2, 0, tArr3, i, tArr2.length);
            if (i > 0) {
                System.arraycopy(tArr, 0, tArr3, 0, i);
            }
            if (i < tArr.length) {
                System.arraycopy(tArr, i, tArr3, tArr2.length + i, tArr.length - i);
            }
            return tArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + tArr.length);
    }

    public static double[] O0O0Io00X(double[] dArr, double d) {
        return (double[]) o00xOoIO(dArr, oXIO0o0XI(dArr, d));
    }

    public static Integer[] O0OOX0IIx(Integer[] numArr) {
        if (XOxxooXI(numArr)) {
            return f32768x0XOIxOo;
        }
        return numArr;
    }

    public static void O0OoXI(short[] sArr, int i, int i2, int i3) {
        if (!XI(sArr) && i < sArr.length && i2 < sArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i == i2) {
                return;
            }
            int min = Math.min(Math.min(i3, sArr.length - i), sArr.length - i2);
            while (i4 < min) {
                short s = sArr[i];
                sArr[i] = sArr[i2];
                sArr[i2] = s;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static BitSet O0X(double[] dArr, double d, int i) {
        int OO0x0xX2;
        BitSet bitSet = new BitSet();
        if (dArr == null) {
            return bitSet;
        }
        while (i < dArr.length && (OO0x0xX2 = OO0x0xX(dArr, d, i)) != -1) {
            bitSet.set(OO0x0xX2);
            i = OO0x0xX2 + 1;
        }
        return bitSet;
    }

    public static int O0Xx(Object obj) {
        return new org.apache.commons.lang3.builder.xxIXOIIO().Oxx0IOOO(obj).xXxxox0I();
    }

    @Deprecated
    public static byte[] O0o0(byte[] bArr, byte b) {
        return (byte[]) o00xOoIO(bArr, OX00O0xII(bArr, b));
    }

    public static float[] O0o000XOX(Float[] fArr, float f) {
        float floatValue;
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return f32754OOXIXo;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            Float f2 = fArr[i];
            if (f2 == null) {
                floatValue = f;
            } else {
                floatValue = f2.floatValue();
            }
            fArr2[i] = floatValue;
        }
        return fArr2;
    }

    public static short[] O0x(short[] sArr) {
        if (XI(sArr)) {
            return f32757Oxx0xo;
        }
        return sArr;
    }

    public static double[] O0xO0(double[] dArr, double d) {
        int xoIxX2 = xoIxX(dArr, d);
        if (xoIxX2 == -1) {
            return Xx000oIo(dArr);
        }
        return OXIOoo0X0(dArr, xoIxX2);
    }

    public static <T> T[] O0xOxO(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return (T[]) x0o(tArr2);
        }
        if (tArr2 == null) {
            return (T[]) x0o(tArr);
        }
        Class<?> componentType = tArr.getClass().getComponentType();
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(componentType, tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        try {
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        } catch (ArrayStoreException e) {
            Class<?> componentType2 = tArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e);
            }
            throw e;
        }
    }

    public static boolean O0xxXxI(long[] jArr, long[] jArr2) {
        if (XoI0Ixx0(jArr) == XoI0Ixx0(jArr2)) {
            return true;
        }
        return false;
    }

    public static boolean[] OI0(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static int[] OI0IXox(int[] iArr, int... iArr2) {
        if (!IO0XoXxO(iArr) && !IO0XoXxO(iArr2)) {
            HashMap hashMap = new HashMap(iArr2.length);
            for (int i : iArr2) {
                Integer valueOf = Integer.valueOf(i);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Integer.valueOf(i3));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Integer.valueOf(i3));
                    }
                    bitSet.set(i2);
                }
            }
            return (int[]) o00xOoIO(iArr, bitSet);
        }
        return IO(iArr);
    }

    public static void OIII0O(boolean[] zArr, Random random) {
        for (int length = zArr.length; length > 1; length--) {
            oIxOXo(zArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static float[] OIIXOxo(float[] fArr, float f) {
        return (float[]) o00xOoIO(fArr, xOoOIoI(fArr, f));
    }

    public static BitSet OIOoIIOIx(boolean[] zArr, boolean z) {
        return x0OIX00oO(zArr, z, 0);
    }

    public static char[] OIoxIx(char[] cArr, int... iArr) {
        return (char[]) IxI(cArr, iArr);
    }

    public static boolean OIx00oxx(byte[] bArr, byte[] bArr2) {
        if (XoI0Ixx0(bArr) == XoI0Ixx0(bArr2)) {
            return true;
        }
        return false;
    }

    public static void OIx0xoOo(int[] iArr, int i) {
        if (iArr == null) {
            return;
        }
        XXO0(iArr, 0, iArr.length, i);
    }

    @Deprecated
    public static char[] OIxI0O(char[] cArr, char c) {
        return (char[]) o00xOoIO(cArr, xOOOX(cArr, c));
    }

    public static void OIxOIX0II(float[] fArr) {
        o0oIxXOx(fArr, new Random());
    }

    public static Object OIxOX(Object obj, int i) {
        int XoI0Ixx02 = XoI0Ixx0(obj);
        if (i >= 0 && i < XoI0Ixx02) {
            int i2 = XoI0Ixx02 - 1;
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i2);
            System.arraycopy(obj, 0, newInstance, 0, i);
            if (i < i2) {
                System.arraycopy(obj, i + 1, newInstance, i, (XoI0Ixx02 - i) - 1);
            }
            return newInstance;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + XoI0Ixx02);
    }

    public static Object[] OIxx0I0(Object[] objArr) {
        if (XOxxooXI(objArr)) {
            return f32753IXxxXO;
        }
        return objArr;
    }

    public static int OO(char[] cArr, char c) {
        return IoOoo(cArr, c, 0);
    }

    public static boolean OO0(boolean[] zArr) {
        return !IOoo(zArr);
    }

    public static int OO0x0xX(double[] dArr, double d, int i) {
        if (X0xII0I(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < dArr.length) {
            if (d == dArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int OOIXx0x(double[] dArr, double d, int i) {
        if (X0xII0I(dArr) || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        while (i >= 0) {
            if (d == dArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean OOOI(long[] jArr) {
        if (jArr != null && jArr.length >= 2) {
            long j = jArr[0];
            int length = jArr.length;
            int i = 1;
            while (i < length) {
                long j2 = jArr[i];
                if (IOo0.II0xO0.I0Io(j, j2) > 0) {
                    return false;
                }
                i++;
                j = j2;
            }
        }
        return true;
    }

    public static void OOOox(short[] sArr) {
        if (sArr == null) {
            return;
        }
        IoXO0XoX(sArr, 0, sArr.length);
    }

    @Deprecated
    public static int[] OOXIXo(int[] iArr, int i, int i2) {
        return (int[]) oIX0oI(iArr, i, Integer.valueOf(i2), Integer.TYPE);
    }

    public static int OOXIxO0(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (obj == null) {
            while (i < objArr.length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static short[] OOoOoO0o(short[] sArr, int i, int i2) {
        if (sArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > sArr.length) {
            i2 = sArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32757Oxx0xo;
        }
        short[] sArr2 = new short[i3];
        System.arraycopy(sArr, i, sArr2, 0, i3);
        return sArr2;
    }

    public static int OOxOI(char[] cArr, char c) {
        return XO00XOO(cArr, c, Integer.MAX_VALUE);
    }

    public static long[] OOxOOxIO(long[] jArr, int... iArr) {
        return (long[]) IxI(jArr, iArr);
    }

    public static boolean OX(int[] iArr) {
        return !IO0XoXxO(iArr);
    }

    public static BitSet OX00O0xII(byte[] bArr, byte b) {
        return xX0IIXIx0(bArr, b, 0);
    }

    public static void OX00o0X(long[] jArr, Random random) {
        for (int length = jArr.length; length > 1; length--) {
            xx0O(jArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static double[] OXIOoo0X0(double[] dArr, int i) {
        return (double[]) OIxOX(dArr, i);
    }

    public static void OXOo(double[] dArr, int i, int i2, int i3) {
        if (!X0xII0I(dArr) && i < dArr.length && i2 < dArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, dArr.length - i), dArr.length - i2);
            while (i4 < min) {
                double d = dArr[i];
                dArr[i] = dArr[i2];
                dArr[i2] = d;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static int OXXoIoXI(double[] dArr, double d) {
        return OOIXx0x(dArr, d, Integer.MAX_VALUE);
    }

    public static float[] OXooXo(float[] fArr, int... iArr) {
        return (float[]) IxI(fArr, iArr);
    }

    public static void OXxx0OO(Object[] objArr, int i) {
        if (objArr == null) {
            return;
        }
        Xx(objArr, 0, objArr.length, i);
    }

    public static short[] Oo(short[] sArr, short s) {
        short[] sArr2 = (short[]) I0X0x0oIo(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s;
        return sArr2;
    }

    public static void Oo0IXI0(double[] dArr, int i, int i2) {
        if (X0xII0I(dArr)) {
            return;
        }
        OXOo(dArr, i, i2, 1);
    }

    public static Float[] Oo0xX(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return f32765oOoXoXO;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static void OoI0OO(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        IOI(objArr, 0, objArr.length);
    }

    @Deprecated
    public static boolean[] OoIXo(boolean[] zArr, boolean z) {
        return (boolean[]) o00xOoIO(zArr, OIOoIIOIx(zArr, z));
    }

    public static BitSet OoO(short[] sArr, short s, int i) {
        int I02;
        BitSet bitSet = new BitSet();
        if (sArr == null) {
            return bitSet;
        }
        while (i < sArr.length && (I02 = I0(sArr, s, i)) != -1) {
            bitSet.set(I02);
            i = I02 + 1;
        }
        return bitSet;
    }

    public static long[] OoOoXO0(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > jArr.length) {
            i2 = jArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32764oO;
        }
        long[] jArr2 = new long[i3];
        System.arraycopy(jArr, i, jArr2, 0, i3);
        return jArr2;
    }

    public static boolean OooI(Object obj, Object obj2) {
        if (XoI0Ixx0(obj) == XoI0Ixx0(obj2)) {
            return true;
        }
        return false;
    }

    public static Short[] OooO0XOx(Short[] shArr) {
        if (XOxxooXI(shArr)) {
            return f32762oI0IIXIo;
        }
        return shArr;
    }

    public static float[] Oox(float[] fArr, float... fArr2) {
        if (!X0xxXX0(fArr) && !X0xxXX0(fArr2)) {
            HashMap hashMap = new HashMap(fArr2.length);
            for (float f : fArr2) {
                Float valueOf = Float.valueOf(f);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < fArr.length; i++) {
                float f2 = fArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Float.valueOf(f2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Float.valueOf(f2));
                    }
                    bitSet.set(i);
                }
            }
            return (float[]) o00xOoIO(fArr, bitSet);
        }
        return X00IoxXI(fArr);
    }

    public static void OoxOxII(Object[] objArr, Random random) {
        for (int length = objArr.length; length > 1; length--) {
            Ox(objArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static Character[] OoxxX(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return f32760XO;
        }
        Character[] chArr = new Character[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    public static void Ox(Object[] objArr, int i, int i2, int i3) {
        if (!XOxxooXI(objArr) && i < objArr.length && i2 < objArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, objArr.length - i), objArr.length - i2);
            while (i4 < min) {
                Object obj = objArr[i];
                objArr[i] = objArr[i2];
                objArr[i2] = obj;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static void Ox00XOXoo(char[] cArr) {
        XOOO0O(cArr, new Random());
    }

    public static BitSet Ox0O(float[] fArr, float f, int i) {
        int xxIO2;
        BitSet bitSet = new BitSet();
        if (fArr == null) {
            return bitSet;
        }
        while (i < fArr.length && (xxIO2 = xxIO(fArr, f, i)) != -1) {
            bitSet.set(xxIO2);
            i = xxIO2 + 1;
        }
        return bitSet;
    }

    public static <T> T[] Ox0XO(T[] tArr, int i, int i2) {
        if (tArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        int i3 = i2 - i;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (i3 <= 0) {
            return (T[]) ((Object[]) Array.newInstance(componentType, 0));
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(componentType, i3));
        System.arraycopy(tArr, i, tArr2, 0, i3);
        return tArr2;
    }

    public static long[] OxI(long[] jArr, long... jArr2) {
        if (jArr == null) {
            return xII(jArr2);
        }
        if (jArr2 == null) {
            return xII(jArr);
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static void OxIxx0(byte[] bArr, int i) {
        if (bArr == null) {
            return;
        }
        IOOXOOOOo(bArr, 0, bArr.length, i);
    }

    public static boolean OxO(short[] sArr) {
        if (sArr != null && sArr.length >= 2) {
            short s = sArr[0];
            int length = sArr.length;
            int i = 1;
            while (i < length) {
                short s2 = sArr[i];
                if (IOo0.II0xO0.oxoX(s, s2) > 0) {
                    return false;
                }
                i++;
                s = s2;
            }
        }
        return true;
    }

    public static boolean OxXXx0X(int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            int i = iArr[0];
            int length = iArr.length;
            int i2 = 1;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (IOo0.II0xO0.II0xO0(i, i3) > 0) {
                    return false;
                }
                i2++;
                i = i3;
            }
        }
        return true;
    }

    public static long[] Oxo00O(long[] jArr) {
        if (oXxOI0oIx(jArr)) {
            return f32764oO;
        }
        return jArr;
    }

    public static boolean Oxx(float[] fArr) {
        return !X0xxXX0(fArr);
    }

    @Deprecated
    public static double[] Oxx0IOOO(double[] dArr, int i, double d) {
        return (double[]) oIX0oI(dArr, i, Double.valueOf(d), Double.TYPE);
    }

    public static boolean[] Oxx0xo(boolean[] zArr, boolean z) {
        boolean[] zArr2 = (boolean[]) I0X0x0oIo(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z;
        return zArr2;
    }

    public static char[] OxxIIOOXO(char[] cArr, char... cArr2) {
        if (cArr == null) {
            return oOXoIIIo(cArr2);
        }
        if (cArr2 == null) {
            return oOXoIIIo(cArr);
        }
        char[] cArr3 = new char[cArr.length + cArr2.length];
        System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
        System.arraycopy(cArr2, 0, cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static void Oxxo(short[] sArr, Random random) {
        for (int length = sArr.length; length > 1; length--) {
            O0OoXI(sArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static void X0(char[] cArr) {
        if (cArr == null) {
            return;
        }
        I0OO(cArr, 0, cArr.length);
    }

    public static float[] X00IoxXI(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static long[] X00IxOx(long[] jArr, long... jArr2) {
        if (!oXxOI0oIx(jArr) && !oXxOI0oIx(jArr2)) {
            HashMap hashMap = new HashMap(jArr2.length);
            for (long j : jArr2) {
                Long valueOf = Long.valueOf(j);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < jArr.length; i++) {
                long j2 = jArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Long.valueOf(j2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Long.valueOf(j2));
                    }
                    bitSet.set(i);
                }
            }
            return (long[]) o00xOoIO(jArr, bitSet);
        }
        return xII(jArr);
    }

    public static int X00xOoXI(byte[] bArr, byte b, int i) {
        if (bArr == null || i < 0) {
            return -1;
        }
        if (i >= bArr.length) {
            i = bArr.length - 1;
        }
        while (i >= 0) {
            if (b == bArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static short[] X0IIOO(short[] sArr, short... sArr2) {
        if (sArr == null) {
            return XOxIOxOx(sArr2);
        }
        if (sArr2 == null) {
            return XOxIOxOx(sArr);
        }
        short[] sArr3 = new short[sArr.length + sArr2.length];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static int[] X0IOOI(int[] iArr) {
        if (IO0XoXxO(iArr)) {
            return f32766ooOOo0oXI;
        }
        return iArr;
    }

    public static <T> boolean X0O0I0(T[] tArr, Comparator<T> comparator) {
        if (comparator != null) {
            if (tArr != null && tArr.length >= 2) {
                T t = tArr[0];
                int length = tArr.length;
                int i = 1;
                while (i < length) {
                    T t2 = tArr[i];
                    if (comparator.compare(t, t2) > 0) {
                        return false;
                    }
                    i++;
                    t = t2;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Comparator should not be null.");
    }

    public static void X0OXX(short[] sArr, int i) {
        if (sArr == null) {
            return;
        }
        Xx0(sArr, 0, sArr.length, i);
    }

    @Deprecated
    public static char[] X0o0xo(char[] cArr, int i, char c) {
        return (char[]) oIX0oI(cArr, i, Character.valueOf(c), Character.TYPE);
    }

    public static boolean[] X0oX(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return f32763oIX0oI;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static int X0ooXIooI(Object[] objArr, Object obj, int i) {
        if (objArr == null || i < 0) {
            return -1;
        }
        if (i >= objArr.length) {
            i = objArr.length - 1;
        }
        if (obj == null) {
            while (i >= 0) {
                if (objArr[i] == null) {
                    return i;
                }
                i--;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i >= 0) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static char[] X0x(char[] cArr, char... cArr2) {
        if (!x0(cArr) && !x0(cArr2)) {
            HashMap hashMap = new HashMap(cArr2.length);
            for (char c : cArr2) {
                Character valueOf = Character.valueOf(c);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < cArr.length; i++) {
                char c2 = cArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Character.valueOf(c2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Character.valueOf(c2));
                    }
                    bitSet.set(i);
                }
            }
            return (char[]) o00xOoIO(cArr, bitSet);
        }
        return oOXoIIIo(cArr);
    }

    public static boolean X0xII0I(double[] dArr) {
        if (XoI0Ixx0(dArr) == 0) {
            return true;
        }
        return false;
    }

    public static byte[] X0xOO(byte[] bArr, byte b) {
        return (byte[]) o00xOoIO(bArr, OX00O0xII(bArr, b));
    }

    public static boolean X0xxXX0(float[] fArr) {
        if (XoI0Ixx0(fArr) == 0) {
            return true;
        }
        return false;
    }

    public static boolean XI(short[] sArr) {
        if (XoI0Ixx0(sArr) == 0) {
            return true;
        }
        return false;
    }

    public static boolean[] XI0IXoo(boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return OI0(zArr2);
        }
        if (zArr2 == null) {
            return OI0(zArr);
        }
        boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
        System.arraycopy(zArr, 0, zArr3, 0, zArr.length);
        System.arraycopy(zArr2, 0, zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static int XI0oooXX(Object[] objArr, Object obj) {
        return OOXIxO0(objArr, obj, 0);
    }

    public static <T> T[] XIOOI(T[] tArr, int... iArr) {
        return (T[]) ((Object[]) IxI(tArr, iArr));
    }

    public static BitSet XIXIX(char[] cArr, char c, int i) {
        int IoOoo2;
        BitSet bitSet = new BitSet();
        if (cArr == null) {
            return bitSet;
        }
        while (i < cArr.length && (IoOoo2 = IoOoo(cArr, c, i)) != -1) {
            bitSet.set(IoOoo2);
            i = IoOoo2 + 1;
        }
        return bitSet;
    }

    public static BitSet XIXIxO(short[] sArr, short s) {
        return OoO(sArr, s, 0);
    }

    public static String XIo(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        return new org.apache.commons.lang3.builder.x0XOIxOo(obj, ToStringStyle.SIMPLE_STYLE).Oxx0IOOO(obj).toString();
    }

    public static int XIo0oOXIx(double[] dArr, double d, int i, double d2) {
        if (X0xII0I(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i < dArr.length) {
            double d5 = dArr[i];
            if (d5 >= d3 && d5 <= d4) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> T[] XIxO(T[] tArr, Object obj) {
        int XI0oooXX2 = XI0oooXX(tArr, obj);
        if (XI0oooXX2 == -1) {
            return (T[]) x0o(tArr);
        }
        return (T[]) ooO0oXxI(tArr, XI0oooXX2);
    }

    public static byte[] XIxXXX0x0(byte[] bArr, byte b) {
        if (bArr == null) {
            return II0xO0(bArr, b);
        }
        return XXoOx0(0, bArr, b);
    }

    public static double[] XO(double[] dArr, double d) {
        double[] dArr2 = (double[]) I0X0x0oIo(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d;
        return dArr2;
    }

    public static void XO0(float[] fArr, int i, int i2) {
        if (X0xxXX0(fArr)) {
            return;
        }
        I0O00OI(fArr, i, i2, 1);
    }

    public static int XO00XOO(char[] cArr, char c, int i) {
        if (cArr == null || i < 0) {
            return -1;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        while (i >= 0) {
            if (c == cArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static double[] XO0OX(double[] dArr, double... dArr2) {
        if (!X0xII0I(dArr) && !X0xII0I(dArr2)) {
            HashMap hashMap = new HashMap(dArr2.length);
            for (double d : dArr2) {
                Double valueOf = Double.valueOf(d);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < dArr.length; i++) {
                double d2 = dArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Double.valueOf(d2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Double.valueOf(d2));
                    }
                    bitSet.set(i);
                }
            }
            return (double[]) o00xOoIO(dArr, bitSet);
        }
        return Xx000oIo(dArr);
    }

    public static boolean XO0o(boolean[] zArr, boolean[] zArr2) {
        if (XoI0Ixx0(zArr) == XoI0Ixx0(zArr2)) {
            return true;
        }
        return false;
    }

    public static void XOOO0O(char[] cArr, Random random) {
        for (int length = cArr.length; length > 1; length--) {
            XOx(cArr, length - 1, random.nextInt(length), 1);
        }
    }

    @Deprecated
    public static int[] XOo0(int[] iArr, int i) {
        return (int[]) o00xOoIO(iArr, O0(iArr, i));
    }

    public static void XOx(char[] cArr, int i, int i2, int i3) {
        if (!x0(cArr) && i < cArr.length && i2 < cArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, cArr.length - i), cArr.length - i2);
            while (i4 < min) {
                char c = cArr[i];
                cArr[i] = cArr[i2];
                cArr[i2] = c;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static short[] XOxIOxOx(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static byte[] XOxoX(byte[] bArr) {
        if (x0OxxIOxX(bArr)) {
            return f32749I0Io;
        }
        return bArr;
    }

    public static boolean XOxxooXI(Object[] objArr) {
        if (XoI0Ixx0(objArr) == 0) {
            return true;
        }
        return false;
    }

    public static boolean XX(double[] dArr, double d) {
        if (xoIxX(dArr, d) != -1) {
            return true;
        }
        return false;
    }

    public static boolean XX0(boolean[] zArr, boolean z) {
        if (ooOx(zArr, z) != -1) {
            return true;
        }
        return false;
    }

    public static int XX0xXo(int[] iArr, int i) {
        return o0xxxXXxX(iArr, i, 0);
    }

    public static void XXIoX0(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return;
        }
        int min = Math.min(jArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            long j = jArr[min];
            jArr[min] = jArr[max];
            jArr[max] = j;
            min--;
        }
    }

    public static void XXO0(int[] iArr, int i, int i2, int i3) {
        if (iArr != null && i < iArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= iArr.length) {
                i2 = iArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    IIXOxIxOo(iArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    IIXOxIxOo(iArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    IIXOxIxOo(iArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static boolean XXXI(char[] cArr) {
        return !x0(cArr);
    }

    public static char[] XXoO0oX(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > cArr.length) {
            i2 = cArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32759X0o0xo;
        }
        char[] cArr2 = new char[i3];
        System.arraycopy(cArr, i, cArr2, 0, i3);
        return cArr2;
    }

    public static byte[] XXoOx0(int i, byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return null;
        }
        if (x0OxxIOxX(bArr2)) {
            return IoOoX(bArr);
        }
        if (i >= 0 && i <= bArr.length) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr2, 0, bArr3, i, bArr2.length);
            if (i > 0) {
                System.arraycopy(bArr, 0, bArr3, 0, i);
            }
            if (i < bArr.length) {
                System.arraycopy(bArr, i, bArr3, bArr2.length + i, bArr.length - i);
            }
            return bArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + bArr.length);
    }

    public static void XXooOOI(boolean[] zArr) {
        OIII0O(zArr, new Random());
    }

    public static void XXx0OXXXo(char[] cArr, int i) {
        if (cArr == null) {
            return;
        }
        IoxOx(cArr, 0, cArr.length, i);
    }

    public static int Xo(int[] iArr, int i, int i2) {
        if (iArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= iArr.length) {
            i2 = iArr.length - 1;
        }
        while (i2 >= 0) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static <T> T Xo0(T[] tArr, int i, T t) {
        if (xXoOI00O(tArr, i)) {
            return tArr[i];
        }
        return t;
    }

    public static int XoI0Ixx0(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static Short[] XoIoOXOIx(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return f32762oI0IIXIo;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    public static boolean XoIxOXIXo(short[] sArr) {
        return !XI(sArr);
    }

    public static char[] XoOOOXox(Character[] chArr, char c) {
        char charValue;
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return f32759X0o0xo;
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            Character ch = chArr[i];
            if (ch == null) {
                charValue = c;
            } else {
                charValue = ch.charValue();
            }
            cArr[i] = charValue;
        }
        return cArr;
    }

    public static void XoOOx0IX(float[] fArr) {
        if (fArr == null) {
            return;
        }
        xx00oOoI(fArr, 0, fArr.length);
    }

    public static int XoOxI0ox(Object[] objArr, Object obj) {
        return X0ooXIooI(objArr, obj, Integer.MAX_VALUE);
    }

    public static boolean XoX(int[] iArr, int i) {
        if (XX0xXo(iArr, i) != -1) {
            return true;
        }
        return false;
    }

    public static int XooIO0oo0(double[] dArr, double d, double d2) {
        return xIx0XO(dArr, d, Integer.MAX_VALUE, d2);
    }

    public static void Xx(Object[] objArr, int i, int i2, int i3) {
        if (objArr != null && i < objArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= objArr.length) {
                i2 = objArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    Ox(objArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    Ox(objArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    Ox(objArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static void Xx0(short[] sArr, int i, int i2, int i3) {
        if (sArr != null && i < sArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= sArr.length) {
                i2 = sArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    O0OoXI(sArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    O0OoXI(sArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    O0OoXI(sArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static double[] Xx000oIo(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static float[] Xx0oX(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return f32754OOXIXo;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static <T> T[] XxI(T[] tArr, T t) {
        return (T[]) ((Object[]) o00xOoIO(tArr, oxIIX0o(tArr, t)));
    }

    public static char[] XxIIOXIXx(char[] cArr, char c) {
        return (char[]) o00xOoIO(cArr, xOOOX(cArr, c));
    }

    public static void XxIOX(byte[] bArr, Random random) {
        for (int length = bArr.length; length > 1; length--) {
            oxO(bArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static Class<?>[] XxIo(Class<?>[] clsArr) {
        if (XOxxooXI(clsArr)) {
            return f32756Oxx0IOOO;
        }
        return clsArr;
    }

    public static boolean[] XxOOoxOO(Boolean[] boolArr, boolean z) {
        boolean booleanValue;
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return f32763oIX0oI;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            Boolean bool = boolArr[i];
            if (bool == null) {
                booleanValue = z;
            } else {
                booleanValue = bool.booleanValue();
            }
            zArr[i] = booleanValue;
        }
        return zArr;
    }

    public static double[] XxX0x0xxx(double[] dArr, double d) {
        if (dArr == null) {
            return XO(dArr, d);
        }
        return oOoIIO0(0, dArr, d);
    }

    public static String[] XxXX(String[] strArr) {
        if (XOxxooXI(strArr)) {
            return f32758OxxIIOOXO;
        }
        return strArr;
    }

    public static byte[] Xxx0oXX(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > bArr.length) {
            i2 = bArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32749I0Io;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }

    public static boolean o0(char[] cArr, char c) {
        if (OO(cArr, c) != -1) {
            return true;
        }
        return false;
    }

    public static int[] o00(int[] iArr, int... iArr2) {
        if (iArr == null) {
            return IO(iArr2);
        }
        if (iArr2 == null) {
            return IO(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static Object o00xOoIO(Object obj, BitSet bitSet) {
        if (obj == null) {
            return null;
        }
        int XoI0Ixx02 = XoI0Ixx0(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), XoI0Ixx02 - bitSet.cardinality());
        int i = 0;
        int i2 = 0;
        while (true) {
            int nextSetBit = bitSet.nextSetBit(i);
            if (nextSetBit == -1) {
                break;
            }
            int i3 = nextSetBit - i;
            if (i3 > 0) {
                System.arraycopy(obj, i, newInstance, i2, i3);
                i2 += i3;
            }
            i = bitSet.nextClearBit(nextSetBit);
        }
        int i4 = XoI0Ixx02 - i;
        if (i4 > 0) {
            System.arraycopy(obj, i, newInstance, i2, i4);
        }
        return newInstance;
    }

    public static <T> boolean o0IXXIx(T[] tArr) {
        return !XOxxooXI(tArr);
    }

    public static short[] o0OO0(short[] sArr, int i) {
        return (short[]) OIxOX(sArr, i);
    }

    public static boolean[] o0Oo(boolean[] zArr) {
        if (IOoo(zArr)) {
            return f32763oIX0oI;
        }
        return zArr;
    }

    public static String[] o0Oox0xox(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return f32758OxxIIOOXO;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            strArr[i] = objArr[i].toString();
        }
        return strArr;
    }

    public static int o0Xo(byte[] bArr, byte b) {
        return X00xOoXI(bArr, b, Integer.MAX_VALUE);
    }

    public static BitSet o0oIxOo(Object[] objArr, Object obj, int i) {
        int OOXIxO02;
        BitSet bitSet = new BitSet();
        if (objArr == null) {
            return bitSet;
        }
        while (i < objArr.length && (OOXIxO02 = OOXIxO0(objArr, obj, i)) != -1) {
            bitSet.set(OOXIxO02);
            i = OOXIxO02 + 1;
        }
        return bitSet;
    }

    public static void o0oIxXOx(float[] fArr, Random random) {
        for (int length = fArr.length; length > 1; length--) {
            I0O00OI(fArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static <T extends Comparable<? super T>> boolean o0oxo0oI(T[] tArr) {
        return X0O0I0(tArr, new Comparator() { // from class: org.apache.commons.lang3.I0Io
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        });
    }

    public static void o0xIIX0(double[] dArr, Random random) {
        for (int length = dArr.length; length > 1; length--) {
            OXOo(dArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static void o0xIoII(long[] jArr) {
        if (jArr == null) {
            return;
        }
        XXIoX0(jArr, 0, jArr.length);
    }

    public static void o0xOIoxo(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        int min = Math.min(bArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            byte b = bArr[min];
            bArr[min] = bArr[max];
            bArr[max] = b;
            min--;
        }
    }

    public static int o0xxxXXxX(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < iArr.length) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int[] oI(int i, int[] iArr, int... iArr2) {
        if (iArr == null) {
            return null;
        }
        if (IO0XoXxO(iArr2)) {
            return IO(iArr);
        }
        if (i >= 0 && i <= iArr.length) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, i, iArr2.length);
            if (i > 0) {
                System.arraycopy(iArr, 0, iArr3, 0, i);
            }
            if (i < iArr.length) {
                System.arraycopy(iArr, i, iArr3, iArr2.length + i, iArr.length - i);
            }
            return iArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + iArr.length);
    }

    @Deprecated
    public static <T> T[] oI0(T[] tArr, T t) {
        return (T[]) ((Object[]) o00xOoIO(tArr, oxIIX0o(tArr, t)));
    }

    public static void oI00o(float[] fArr, int i) {
        if (fArr == null) {
            return;
        }
        oxOIoIx(fArr, 0, fArr.length, i);
    }

    public static byte[] oI0IIXIo(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return IoOoX(bArr2);
        }
        if (bArr2 == null) {
            return IoOoX(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int[] oI0X0(int[] iArr, int i) {
        return (int[]) o00xOoIO(iArr, O0(iArr, i));
    }

    public static short[] oII(Short[] shArr, short s) {
        short shortValue;
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return f32757Oxx0xo;
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            Short sh = shArr[i];
            if (sh == null) {
                shortValue = s;
            } else {
                shortValue = sh.shortValue();
            }
            sArr[i] = shortValue;
        }
        return sArr;
    }

    @Deprecated
    public static boolean oIIxXoo(Object obj, Object obj2) {
        return new org.apache.commons.lang3.builder.X0o0xo().Oxx0IOOO(obj, obj2).o00();
    }

    public static float[] oIX0o(float[] fArr, int i, int i2) {
        if (fArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > fArr.length) {
            i2 = fArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32754OOXIXo;
        }
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, i3);
        return fArr2;
    }

    public static Object oIX0oI(Object obj, int i, Object obj2, Class<?> cls) {
        if (obj == null) {
            if (i == 0) {
                Object newInstance = Array.newInstance(cls, 1);
                Array.set(newInstance, 0, obj2);
                return newInstance;
            }
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: 0");
        }
        int length = Array.getLength(obj);
        if (i <= length && i >= 0) {
            Object newInstance2 = Array.newInstance(cls, length + 1);
            System.arraycopy(obj, 0, newInstance2, 0, i);
            Array.set(newInstance2, i, obj2);
            if (i < length) {
                System.arraycopy(obj, i, newInstance2, i + 1, length - i);
            }
            return newInstance2;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
    }

    public static long[] oIXoXx0(long[] jArr, long j) {
        return (long[]) o00xOoIO(jArr, xI0oxI00(jArr, j));
    }

    public static byte[] oIoIXxIO(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return f32749I0Io;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public static void oIoxI0xx(boolean[] zArr, int i, int i2) {
        if (IOoo(zArr)) {
            return;
        }
        oIxOXo(zArr, i, i2, 1);
    }

    public static void oIxOXo(boolean[] zArr, int i, int i2, int i3) {
        if (!IOoo(zArr) && i < zArr.length && i2 < zArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, zArr.length - i), zArr.length - i2);
            while (i4 < min) {
                boolean z = zArr[i];
                zArr[i] = zArr[i2];
                zArr[i2] = z;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static short[] oIxXXOI(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return f32757Oxx0xo;
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    public static Map<Object, Object> oIxxIo(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap((int) (objArr.length * 1.5d));
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                hashMap.put(entry.getKey(), entry.getValue());
            } else if (obj instanceof Object[]) {
                Object[] objArr2 = (Object[]) obj;
                if (objArr2.length >= 2) {
                    hashMap.put(objArr2[0], objArr2[1]);
                } else {
                    throw new IllegalArgumentException("Array element " + i + ", '" + obj + "', has a length less than 2");
                }
            } else {
                throw new IllegalArgumentException("Array element " + i + ", '" + obj + "', is neither of type Map.Entry nor an Array");
            }
        }
        return hashMap;
    }

    public static <T> T[] oO(T[] tArr, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t != null) {
            cls = t.getClass();
        } else {
            throw new IllegalArgumentException("Arguments cannot both be null");
        }
        T[] tArr2 = (T[]) ((Object[]) I0X0x0oIo(tArr, cls));
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    public static void oO0(short[] sArr, int i, int i2) {
        if (XI(sArr)) {
            return;
        }
        O0OoXI(sArr, i, i2, 1);
    }

    public static long[] oO0IXx(long[] jArr, int i) {
        return (long[]) OIxOX(jArr, i);
    }

    public static void oO0OX0(double[] dArr) {
        o0xIIX0(dArr, new Random());
    }

    public static void oOIXoIXXI(double[] dArr, int i, int i2, int i3) {
        if (dArr != null && i < dArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= dArr.length) {
                i2 = dArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    OXOo(dArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    OXOo(dArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    OXOo(dArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static boolean[] oOIx(boolean[] zArr, boolean... zArr2) {
        if (!IOoo(zArr) && !IOoo(zArr2)) {
            HashMap hashMap = new HashMap(2);
            for (boolean z : zArr2) {
                Boolean valueOf = Boolean.valueOf(z);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < zArr.length; i++) {
                boolean z2 = zArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Boolean.valueOf(z2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Boolean.valueOf(z2));
                    }
                    bitSet.set(i);
                }
            }
            return (boolean[]) o00xOoIO(zArr, bitSet);
        }
        return OI0(zArr);
    }

    public static char[] oOXoIIIo(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static BitSet oOo(double[] dArr, double d, double d2) {
        return IIX0(dArr, d, 0, d2);
    }

    public static String[] oOo0o(Object[] objArr, String str) {
        String obj;
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return f32758OxxIIOOXO;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj2 = objArr[i];
            if (obj2 == null) {
                obj = str;
            } else {
                obj = obj2.toString();
            }
            strArr[i] = obj;
        }
        return strArr;
    }

    public static double[] oOoIIO0(int i, double[] dArr, double... dArr2) {
        if (dArr == null) {
            return null;
        }
        if (X0xII0I(dArr2)) {
            return Xx000oIo(dArr);
        }
        if (i >= 0 && i <= dArr.length) {
            double[] dArr3 = new double[dArr.length + dArr2.length];
            System.arraycopy(dArr2, 0, dArr3, i, dArr2.length);
            if (i > 0) {
                System.arraycopy(dArr, 0, dArr3, 0, i);
            }
            if (i < dArr.length) {
                System.arraycopy(dArr, i, dArr3, dArr2.length + i, dArr.length - i);
            }
            return dArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + dArr.length);
    }

    @Deprecated
    public static long[] oOoXoXO(long[] jArr, int i, long j) {
        return (long[]) oIX0oI(jArr, i, Long.valueOf(j), Long.TYPE);
    }

    public static Long[] oOxxXI(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return f32769x0xO0oo;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static <T> T oX(T[] tArr, int i) {
        return (T) Xo0(tArr, i, null);
    }

    public static int oX000x(short[] sArr, short s) {
        return xIOXX(sArr, s, Integer.MAX_VALUE);
    }

    public static boolean oX0I0O(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return obj.getClass().getName().equals(obj2.getClass().getName());
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static Double[] oX0O(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return f32772xxIXOIIO;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static boolean oX0ooo0I0(double[] dArr) {
        if (dArr != null && dArr.length >= 2) {
            double d = dArr[0];
            int length = dArr.length;
            int i = 1;
            while (i < length) {
                double d2 = dArr[i];
                if (Double.compare(d, d2) > 0) {
                    return false;
                }
                i++;
                d = d2;
            }
        }
        return true;
    }

    public static BitSet oXIO0o0XI(double[] dArr, double d) {
        return O0X(dArr, d, 0);
    }

    @SafeVarargs
    public static <T> T[] oXIoIo(T[] tArr, T... tArr2) {
        if (!XOxxooXI(tArr) && !XOxxooXI(tArr2)) {
            HashMap hashMap = new HashMap(tArr2.length);
            for (T t : tArr2) {
                MutableInt mutableInt = (MutableInt) hashMap.get(t);
                if (mutableInt == null) {
                    hashMap.put(t, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < tArr.length; i++) {
                T t2 = tArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(t2);
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(t2);
                    }
                    bitSet.set(i);
                }
            }
            return (T[]) ((Object[]) o00xOoIO(tArr, bitSet));
        }
        return (T[]) x0o(tArr);
    }

    public static boolean oXIoO(long[] jArr) {
        return !oXxOI0oIx(jArr);
    }

    public static int oXO0oOx0(long[] jArr, long j) {
        return IIOIX(jArr, j, Integer.MAX_VALUE);
    }

    public static boolean oXX0IoI(byte[] bArr) {
        return !x0OxxIOxX(bArr);
    }

    public static double[] oXoXxOo(double[] dArr, int... iArr) {
        return (double[]) IxI(dArr, iArr);
    }

    public static boolean oXxOI0oIx(long[] jArr) {
        if (XoI0Ixx0(jArr) == 0) {
            return true;
        }
        return false;
    }

    public static void oXxOXOX(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return;
        }
        int min = Math.min(iArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            int i3 = iArr[min];
            iArr[min] = iArr[max];
            iArr[max] = i3;
            min--;
        }
    }

    public static int oXxx000(float[] fArr, float f) {
        return xOOxI(fArr, f, Integer.MAX_VALUE);
    }

    public static boolean[] oo(boolean[] zArr, boolean z) {
        if (zArr == null) {
            return Oxx0xo(zArr, z);
        }
        return xxOXOOoIX(0, zArr, z);
    }

    public static boolean oo00(float[] fArr) {
        if (fArr != null && fArr.length >= 2) {
            float f = fArr[0];
            int length = fArr.length;
            int i = 1;
            while (i < length) {
                float f2 = fArr[i];
                if (Float.compare(f, f2) > 0) {
                    return false;
                }
                i++;
                f = f2;
            }
        }
        return true;
    }

    public static Float[] oo0oIXo(Float[] fArr) {
        if (XOxxooXI(fArr)) {
            return f32765oOoXoXO;
        }
        return fArr;
    }

    public static short[] oo0xXOI0I(short[] sArr, short s) {
        if (sArr == null) {
            return Oo(sArr, s);
        }
        return IoXIXo(0, sArr, s);
    }

    public static <T> T[] ooO0oXxI(T[] tArr, int i) {
        return (T[]) ((Object[]) OIxOX(tArr, i));
    }

    public static long[] ooOOo0oXI(long[] jArr, long j) {
        long[] jArr2 = (long[]) I0X0x0oIo(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j;
        return jArr2;
    }

    public static int ooOx(boolean[] zArr, boolean z) {
        return xoO0xx0(zArr, z, 0);
    }

    public static long[] ooXIXxIX(long[] jArr, long j) {
        if (jArr == null) {
            return ooOOo0oXI(jArr, j);
        }
        return Ix00oIoI(0, jArr, j);
    }

    public static short[] oox000IX(short[] sArr, int... iArr) {
        return (short[]) IxI(sArr, iArr);
    }

    public static int ox(long[] jArr, long j, int i) {
        if (jArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < jArr.length) {
            if (j == jArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void ox0(Object[] objArr) {
        OoxOxII(objArr, new Random());
    }

    public static boolean[] ox0I(boolean[] zArr, int... iArr) {
        return (boolean[]) IxI(zArr, iArr);
    }

    public static BitSet oxIIX0o(Object[] objArr, Object obj) {
        return o0oIxOo(objArr, obj, 0);
    }

    public static Double[] oxIO0IIo(Double[] dArr) {
        if (XOxxooXI(dArr)) {
            return f32772xxIXOIIO;
        }
        return dArr;
    }

    public static void oxO(byte[] bArr, int i, int i2, int i3) {
        if (!x0OxxIOxX(bArr) && i < bArr.length && i2 < bArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, bArr.length - i), bArr.length - i2);
            while (i4 < min) {
                byte b = bArr[i];
                bArr[i] = bArr[i2];
                bArr[i2] = b;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static void oxOIoIx(float[] fArr, int i, int i2, int i3) {
        if (fArr != null && i < fArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= fArr.length) {
                i2 = fArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    I0O00OI(fArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    I0O00OI(fArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    I0O00OI(fArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static boolean oxOXxoXII(Object[] objArr, Object[] objArr2) {
        if (XoI0Ixx0(objArr) == XoI0Ixx0(objArr2)) {
            return true;
        }
        return false;
    }

    public static int[] oxXIOXO(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return f32766ooOOo0oXI;
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static boolean oxXx0IX(long[] jArr, long j) {
        if (O00XxXI(jArr, j) != -1) {
            return true;
        }
        return false;
    }

    public static char[] oxoX(char[] cArr, char c) {
        char[] cArr2 = (char[]) I0X0x0oIo(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c;
        return cArr2;
    }

    public static boolean oxxXoxO(float[] fArr, float f) {
        if (Ioxxx(fArr, f) != -1) {
            return true;
        }
        return false;
    }

    public static boolean x0(char[] cArr) {
        if (XoI0Ixx0(cArr) == 0) {
            return true;
        }
        return false;
    }

    public static boolean x00IOx(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            byte b = bArr[0];
            int length = bArr.length;
            int i = 1;
            while (i < length) {
                byte b2 = bArr[i];
                if (IOo0.II0xO0.oIX0oI(b, b2) > 0) {
                    return false;
                }
                i++;
                b = b2;
            }
        }
        return true;
    }

    @Deprecated
    public static float[] x00X0xoXO(float[] fArr, float f) {
        return (float[]) o00xOoIO(fArr, xOoOIoI(fArr, f));
    }

    public static char[] x0Io0(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return f32759X0o0xo;
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    public static long[] x0OI(Long[] lArr, long j) {
        long longValue;
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return f32764oO;
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            Long l = lArr[i];
            if (l == null) {
                longValue = j;
            } else {
                longValue = l.longValue();
            }
            jArr[i] = longValue;
        }
        return jArr;
    }

    public static BitSet x0OIX00oO(boolean[] zArr, boolean z, int i) {
        int xoO0xx02;
        BitSet bitSet = new BitSet();
        if (zArr == null) {
            return bitSet;
        }
        while (i < zArr.length && (xoO0xx02 = xoO0xx0(zArr, z, i)) != -1) {
            bitSet.set(xoO0xx02);
            i = xoO0xx02 + 1;
        }
        return bitSet;
    }

    public static byte[] x0OOI(byte[] bArr, int i) {
        return (byte[]) OIxOX(bArr, i);
    }

    public static boolean x0OxxIOxX(byte[] bArr) {
        if (XoI0Ixx0(bArr) == 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static <T> T[] x0XOIxOo(T[] tArr, int i, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t != null) {
            cls = t.getClass();
        } else {
            throw new IllegalArgumentException("Array and element cannot both be null");
        }
        return (T[]) ((Object[]) oIX0oI(tArr, i, t, cls));
    }

    public static <T> T[] x0o(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    public static float[] x0oox0(float[] fArr, int i) {
        return (float[]) OIxOX(fArr, i);
    }

    public static int x0oxIIIX(boolean[] zArr, boolean z, int i) {
        if (IOoo(zArr) || i < 0) {
            return -1;
        }
        if (i >= zArr.length) {
            i = zArr.length - 1;
        }
        while (i >= 0) {
            if (z == zArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static int x0xO(double[] dArr, double d, double d2) {
        return XIo0oOXIx(dArr, d, 0, d2);
    }

    @Deprecated
    public static short[] x0xO0oo(short[] sArr, int i, short s) {
        return (short[]) oIX0oI(sArr, i, Short.valueOf(s), Short.TYPE);
    }

    public static void x0xOIoO(long[] jArr, int i) {
        if (jArr == null) {
            return;
        }
        xoxo(jArr, 0, jArr.length, i);
    }

    public static <T> T[] xI(T[] tArr, T t) {
        if (tArr == null) {
            return (T[]) oO(tArr, t);
        }
        return (T[]) O0IxXx(0, tArr, t);
    }

    public static void xI0OXooO(int[] iArr, Random random) {
        for (int length = iArr.length; length > 1; length--) {
            IIXOxIxOo(iArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static double[] xI0Ooxx0x(Double[] dArr, double d) {
        double doubleValue;
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return f32750II0XooXoX;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            Double d2 = dArr[i];
            if (d2 == null) {
                doubleValue = d;
            } else {
                doubleValue = d2.doubleValue();
            }
            dArr2[i] = doubleValue;
        }
        return dArr2;
    }

    public static BitSet xI0oxI00(long[] jArr, long j) {
        return IoIOOxIIo(jArr, j, 0);
    }

    public static long[] xII(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static long[] xIIoO(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return f32764oO;
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static int xIOXX(short[] sArr, short s, int i) {
        if (sArr == null || i < 0) {
            return -1;
        }
        if (i >= sArr.length) {
            i = sArr.length - 1;
        }
        while (i >= 0) {
            if (s == sArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static char[] xIXIOX(char[] cArr) {
        if (x0(cArr)) {
            return f32759X0o0xo;
        }
        return cArr;
    }

    public static byte[] xIXOoI(byte[] bArr, int... iArr) {
        return (byte[]) IxI(bArr, iArr);
    }

    public static boolean xIXX(char[] cArr, char[] cArr2) {
        if (XoI0Ixx0(cArr) == XoI0Ixx0(cArr2)) {
            return true;
        }
        return false;
    }

    public static void xIXoO0Xx(boolean[] zArr, int i, int i2) {
        if (zArr == null) {
            return;
        }
        int min = Math.min(zArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            boolean z = zArr[min];
            zArr[min] = zArr[max];
            zArr[max] = z;
            min--;
        }
    }

    @Deprecated
    public static short[] xIoXXXIXo(short[] sArr, short s) {
        return (short[]) o00xOoIO(sArr, XIXIxO(sArr, s));
    }

    public static int xIx(int[] iArr, int i) {
        return Xo(iArr, i, Integer.MAX_VALUE);
    }

    public static int xIx0XO(double[] dArr, double d, int i, double d2) {
        if (X0xII0I(dArr) || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i >= 0) {
            double d5 = dArr[i];
            if (d5 >= d3 && d5 <= d4) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static Character[] xIxooxXX(Character[] chArr) {
        if (XOxxooXI(chArr)) {
            return f32760XO;
        }
        return chArr;
    }

    public static double[] xOI0(double[] dArr, int i, int i2) {
        if (dArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > dArr.length) {
            i2 = dArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f32750II0XooXoX;
        }
        double[] dArr2 = new double[i3];
        System.arraycopy(dArr, i, dArr2, 0, i3);
        return dArr2;
    }

    public static <T> T[] xOIO(T... tArr) {
        return tArr;
    }

    public static Object xOIx00(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> XX02 = ClassUtils.XX0(obj.getClass().getComponentType());
        if (Integer.TYPE.equals(XX02)) {
            return oxXIOXO((Integer[]) obj);
        }
        if (Long.TYPE.equals(XX02)) {
            return xIIoO((Long[]) obj);
        }
        if (Short.TYPE.equals(XX02)) {
            return oIxXXOI((Short[]) obj);
        }
        if (Double.TYPE.equals(XX02)) {
            return xxOoXO((Double[]) obj);
        }
        if (Float.TYPE.equals(XX02)) {
            return Xx0oX((Float[]) obj);
        }
        return obj;
    }

    public static BitSet xOOOX(char[] cArr, char c) {
        return XIXIX(cArr, c, 0);
    }

    public static int xOOxI(float[] fArr, float f, int i) {
        if (X0xxXX0(fArr) || i < 0) {
            return -1;
        }
        if (i >= fArr.length) {
            i = fArr.length - 1;
        }
        while (i >= 0) {
            if (f == fArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean xOOxIO(int[] iArr, int[] iArr2) {
        if (XoI0Ixx0(iArr) == XoI0Ixx0(iArr2)) {
            return true;
        }
        return false;
    }

    public static short[] xOoIIIoXI(short[] sArr, short... sArr2) {
        if (!XI(sArr) && !XI(sArr2)) {
            HashMap hashMap = new HashMap(sArr2.length);
            for (short s : sArr2) {
                Short valueOf = Short.valueOf(s);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < sArr.length; i++) {
                short s2 = sArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Short.valueOf(s2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Short.valueOf(s2));
                    }
                    bitSet.set(i);
                }
            }
            return (short[]) o00xOoIO(sArr, bitSet);
        }
        return XOxIOxOx(sArr);
    }

    public static BitSet xOoOIoI(float[] fArr, float f) {
        return Ox0O(fArr, f, 0);
    }

    public static void xOx(int[] iArr) {
        xI0OXooO(iArr, new Random());
    }

    public static void xOxOoo(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        o0xOIoxo(bArr, 0, bArr.length);
    }

    public static void xOxxXO(double[] dArr) {
        if (dArr == null) {
            return;
        }
        IxO0Oxo(dArr, 0, dArr.length);
    }

    public static boolean xX(char[] cArr) {
        if (cArr != null && cArr.length >= 2) {
            char c = cArr[0];
            int length = cArr.length;
            int i = 1;
            while (i < length) {
                char c2 = cArr[i];
                if (xoIox.oIX0oI(c, c2) > 0) {
                    return false;
                }
                i++;
                c = c2;
            }
        }
        return true;
    }

    public static BitSet xX0IIXIx0(byte[] bArr, byte b, int i) {
        int xoxXI2;
        BitSet bitSet = new BitSet();
        if (bArr == null) {
            return bitSet;
        }
        while (i < bArr.length && (xoxXI2 = xoxXI(bArr, b, i)) != -1) {
            bitSet.set(xoxXI2);
            i = xoxXI2 + 1;
        }
        return bitSet;
    }

    public static boolean[] xX0ox(boolean[] zArr, boolean z) {
        return (boolean[]) o00xOoIO(zArr, OIOoIIOIx(zArr, z));
    }

    public static void xXIX0Xo(short[] sArr) {
        Oxxo(sArr, new Random());
    }

    public static String xXO0oXX(Object obj) {
        return XIo(obj, "{}");
    }

    public static boolean xXOx(short[] sArr, short s) {
        if (IIxOXoOo0(sArr, s) != -1) {
            return true;
        }
        return false;
    }

    public static void xXXxoI(Object[] objArr, int i, int i2) {
        if (XOxxooXI(objArr)) {
            return;
        }
        Ox(objArr, i, i2, 1);
    }

    public static boolean[] xXo(boolean[] zArr, int i) {
        return (boolean[]) OIxOX(zArr, i);
    }

    public static <T> boolean xXoOI00O(T[] tArr, int i) {
        if (i >= 0 && XoI0Ixx0(tArr) > i) {
            return true;
        }
        return false;
    }

    public static float[] xXxxox0I(float[] fArr, float f) {
        if (fArr == null) {
            return II0XooXoX(fArr, f);
        }
        return IXO(0, fArr, f);
    }

    public static double[] xo(double[] dArr) {
        if (X0xII0I(dArr)) {
            return f32750II0XooXoX;
        }
        return dArr;
    }

    public static boolean xo0x(Object[] objArr, Object obj) {
        if (XI0oooXX(objArr, obj) != -1) {
            return true;
        }
        return false;
    }

    public static byte[] xoIXOxX(byte[] bArr, byte b) {
        int I0oOIX2 = I0oOIX(bArr, b);
        if (I0oOIX2 == -1) {
            return IoOoX(bArr);
        }
        return x0OOI(bArr, I0oOIX2);
    }

    public static int[] xoIox(int[] iArr, int i) {
        int[] iArr2 = (int[]) I0X0x0oIo(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i;
        return iArr2;
    }

    public static int xoIxX(double[] dArr, double d) {
        return OO0x0xX(dArr, d, 0);
    }

    public static int xoO0xx0(boolean[] zArr, boolean z, int i) {
        if (IOoo(zArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < zArr.length) {
            if (z == zArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Long[] xoX(Long[] lArr) {
        if (XOxxooXI(lArr)) {
            return f32769x0xO0oo;
        }
        return lArr;
    }

    public static float[] xoXoI(float[] fArr, float... fArr2) {
        if (fArr == null) {
            return X00IoxXI(fArr2);
        }
        if (fArr2 == null) {
            return X00IoxXI(fArr);
        }
        float[] fArr3 = new float[fArr.length + fArr2.length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static char[] xooxxX(char[] cArr, char c) {
        int OO2 = OO(cArr, c);
        if (OO2 == -1) {
            return oOXoIIIo(cArr);
        }
        return IXoIo(cArr, OO2);
    }

    public static Byte[] xox(Byte[] bArr) {
        if (XOxxooXI(bArr)) {
            return f32767oxoX;
        }
        return bArr;
    }

    public static int xoxXI(byte[] bArr, byte b, int i) {
        if (bArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < bArr.length) {
            if (b == bArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void xoxo(long[] jArr, int i, int i2, int i3) {
        if (jArr != null && i < jArr.length - 1 && i2 > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i2 >= jArr.length) {
                i2 = jArr.length;
            }
            int i4 = i2 - i;
            if (i4 <= 1) {
                return;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            while (i4 > 1 && i5 > 0) {
                int i6 = i4 - i5;
                if (i5 > i6) {
                    xx0O(jArr, i, (i4 + i) - i6, i6);
                    int i7 = i5;
                    i5 -= i6;
                    i4 = i7;
                } else if (i5 < i6) {
                    xx0O(jArr, i, i + i6, i5);
                    i += i5;
                    i4 = i6;
                } else {
                    xx0O(jArr, i, i6 + i, i5);
                    return;
                }
            }
        }
    }

    public static void xx(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        xIXoO0Xx(zArr, 0, zArr.length);
    }

    public static <T> T[] xx0(T[] tArr, Class<T[]> cls) {
        if (cls != null) {
            if (tArr == null) {
                return cls.cast(Array.newInstance(cls.getComponentType(), 0));
            }
            return tArr;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public static void xx00oOoI(float[] fArr, int i, int i2) {
        if (fArr == null) {
            return;
        }
        int min = Math.min(fArr.length, i2) - 1;
        for (int max = Math.max(i, 0); min > max; max++) {
            float f = fArr[min];
            fArr[min] = fArr[max];
            fArr[max] = f;
            min--;
        }
    }

    public static void xx0O(long[] jArr, int i, int i2, int i3) {
        if (!oXxOI0oIx(jArr) && i < jArr.length && i2 < jArr.length) {
            int i4 = 0;
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(Math.min(i3, jArr.length - i), jArr.length - i2);
            while (i4 < min) {
                long j = jArr[i];
                jArr[i] = jArr[i2];
                jArr[i2] = j;
                i4++;
                i++;
                i2++;
            }
        }
    }

    public static BitSet xx0X0(int[] iArr, int i, int i2) {
        int o0xxxXXxX2;
        BitSet bitSet = new BitSet();
        if (iArr == null) {
            return bitSet;
        }
        while (i2 < iArr.length && (o0xxxXXxX2 = o0xxxXXxX(iArr, i, i2)) != -1) {
            bitSet.set(o0xxxXXxX2);
            i2 = o0xxxXXxX2 + 1;
        }
        return bitSet;
    }

    public static long[] xx0o0O(long[] jArr, long j) {
        int O00XxXI2 = O00XxXI(jArr, j);
        if (O00XxXI2 == -1) {
            return xII(jArr);
        }
        return oO0IXx(jArr, O00XxXI2);
    }

    public static int xxIO(float[] fArr, float f, int i) {
        if (X0xxXX0(fArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < fArr.length) {
            if (f == fArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Deprecated
    public static float[] xxIXOIIO(float[] fArr, int i, float f) {
        return (float[]) oIX0oI(fArr, i, Float.valueOf(f), Float.TYPE);
    }

    public static boolean[] xxOXOOoIX(int i, boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return null;
        }
        if (IOoo(zArr2)) {
            return OI0(zArr);
        }
        if (i >= 0 && i <= zArr.length) {
            boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
            System.arraycopy(zArr2, 0, zArr3, i, zArr2.length);
            if (i > 0) {
                System.arraycopy(zArr, 0, zArr3, 0, i);
            }
            if (i < zArr.length) {
                System.arraycopy(zArr, i, zArr3, zArr2.length + i, zArr.length - i);
            }
            return zArr3;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + zArr.length);
    }

    public static double[] xxOoXO(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return f32750II0XooXoX;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static char[] xxX(char[] cArr, char c) {
        if (cArr == null) {
            return oxoX(cArr, c);
        }
        return IxIX0I(0, cArr, c);
    }

    public static byte[] xxXXXxIxo(byte[] bArr, byte... bArr2) {
        if (!x0OxxIOxX(bArr) && !x0OxxIOxX(bArr2)) {
            HashMap hashMap = new HashMap(bArr2.length);
            for (byte b : bArr2) {
                Byte valueOf = Byte.valueOf(b);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < bArr.length; i++) {
                byte b2 = bArr[i];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Byte.valueOf(b2));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Byte.valueOf(b2));
                    }
                    bitSet.set(i);
                }
            }
            return (byte[]) o00xOoIO(bArr, bitSet);
        }
        return IoOoX(bArr);
    }

    public static Integer[] xxoXO(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return f32768x0XOIxOo;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Byte[] xxx(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return f32767oxoX;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static boolean xxx00(boolean[] zArr) {
        if (zArr != null && zArr.length >= 2) {
            boolean z = zArr[0];
            int length = zArr.length;
            int i = 1;
            while (i < length) {
                boolean z2 = zArr[i];
                if (XO.I0Io(z, z2) > 0) {
                    return false;
                }
                i++;
                z = z2;
            }
        }
        return true;
    }

    public static boolean xxxI(double[] dArr, double[] dArr2) {
        if (XoI0Ixx0(dArr) == XoI0Ixx0(dArr2)) {
            return true;
        }
        return false;
    }

    public static short[] xxxoo0XI(short[] sArr, short s) {
        int IIxOXoOo02 = IIxOXoOo0(sArr, s);
        if (IIxOXoOo02 == -1) {
            return XOxIOxOx(sArr);
        }
        return o0OO0(sArr, IIxOXoOo02);
    }
}
