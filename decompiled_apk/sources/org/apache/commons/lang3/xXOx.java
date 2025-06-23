package org.apache.commons.lang3;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class xXOx {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f32946I0Io = "";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Pattern f32947II0XooXoX = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32948II0xO0 = " ";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f32949Oxx0IOOO = 8192;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f32950X0o0xo = "\r";

    /* renamed from: XO, reason: collision with root package name */
    public static final int f32951XO = -1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f32952oIX0oI = 256;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f32953oxoX = "\n";

    public static boolean I0(CharSequence charSequence) {
        if (XIXIX(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String[] I00O(String str, String str2, int i, boolean z) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return oxoX.f32758OxxIIOOXO;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i4 = 0;
            z4 = false;
            z5 = false;
            i5 = 0;
            int i6 = 1;
            while (i4 < length) {
                if (Character.isWhitespace(str.charAt(i4))) {
                    if (z4 || z) {
                        int i7 = i6 + 1;
                        if (i6 == i) {
                            i4 = length;
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        arrayList.add(str.substring(i5, i4));
                        i6 = i7;
                        z4 = false;
                    }
                    i5 = i4 + 1;
                    i4 = i5;
                } else {
                    i4++;
                    z4 = true;
                    z5 = false;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i2 = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                int i8 = 1;
                while (i2 < length) {
                    if (str.charAt(i2) == charAt) {
                        if (z2 || z) {
                            int i9 = i8 + 1;
                            if (i8 == i) {
                                i2 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i3, i2));
                            i8 = i9;
                            z2 = false;
                        }
                        i3 = i2 + 1;
                        i2 = i3;
                    } else {
                        i2++;
                        z2 = true;
                        z3 = false;
                    }
                }
            } else {
                i2 = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                int i10 = 1;
                while (i2 < length) {
                    if (str2.indexOf(str.charAt(i2)) >= 0) {
                        if (z2 || z) {
                            int i11 = i10 + 1;
                            if (i10 == i) {
                                i2 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i3, i2));
                            i10 = i11;
                            z2 = false;
                        }
                        i3 = i2 + 1;
                        i2 = i3;
                    } else {
                        i2++;
                        z2 = true;
                        z3 = false;
                    }
                }
            }
            i4 = i2;
            z4 = z2;
            z5 = z3;
            i5 = i3;
        }
        if (z4 || (z && z5)) {
            arrayList.add(str.substring(i5, i4));
        }
        return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
    }

    public static String I0Io(String str, String str2, int i) {
        return oxoX(str, str2, 0, i);
    }

    @Deprecated
    public static double I0X0x0oIo(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            double d = O00(charSequence, charSequence2)[0];
            if (d == XIXIX.OOXIXo.f3760XO) {
                return XIXIX.OOXIXo.f3760XO;
            }
            double length = (((d / charSequence.length()) + (d / charSequence2.length())) + ((d - r0[1]) / d)) / 3.0d;
            if (length >= 0.7d) {
                length += Math.min(0.1d, 1.0d / r0[3]) * r0[2] * (1.0d - length);
            }
            return Math.round(length * 100.0d) / 100.0d;
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public static int I0oOIX(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return II0XooXoX.I0Io(charSequence, charSequence2, 0);
        }
        return -1;
    }

    public static byte[] I0oOoX(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return oxoX.f32749I0Io;
        }
        return str.getBytes(OOXIXo.I0Io(str2));
    }

    public static int I0xX0(CharSequence charSequence, CharSequence... charSequenceArr) {
        int X0o0xo2;
        int i = -1;
        if (charSequence != null && charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (X0o0xo2 = II0XooXoX.X0o0xo(charSequence, charSequence2, charSequence.length())) > i) {
                    i = X0o0xo2;
                }
            }
        }
        return i;
    }

    public static String II0XooXoX(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return XO(str, charSequence, true, charSequenceArr);
    }

    public static String II0xO0(String str, int i, int i2) {
        return oxoX(str, "...", i, i2);
    }

    public static String IIIxO(String str, char c) {
        if (!XIXIX(str) && c != 0) {
            return c + str + c;
        }
        return str;
    }

    public static String IIOIX(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        String str2;
        String str3;
        int length;
        if (i < 0) {
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            hashSet.retainAll(new HashSet(Arrays.asList(strArr2)));
            if (hashSet.size() > 0) {
                throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
            }
        }
        if (!XIXIX(str) && !oxoX.XOxxooXI(strArr) && !oxoX.XOxxooXI(strArr2) && (!oxoX.o0IXXIx(strArr) || i != -1)) {
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 == length3) {
                boolean[] zArr = new boolean[length2];
                int i2 = -1;
                int i3 = -1;
                for (int i4 = 0; i4 < length2; i4++) {
                    if (!zArr[i4] && !XIXIX(strArr[i4]) && strArr2[i4] != null) {
                        int indexOf = str.indexOf(strArr[i4]);
                        if (indexOf == -1) {
                            zArr[i4] = true;
                        } else if (i2 == -1 || indexOf < i2) {
                            i3 = i4;
                            i2 = indexOf;
                        }
                    }
                }
                if (i2 == -1) {
                    return str;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    if (strArr[i6] != null && (str3 = strArr2[i6]) != null && (length = str3.length() - strArr[i6].length()) > 0) {
                        i5 += length * 3;
                    }
                }
                StringBuilder sb = new StringBuilder(str.length() + Math.min(i5, str.length() / 5));
                int i7 = 0;
                while (i2 != -1) {
                    while (i7 < i2) {
                        sb.append(str.charAt(i7));
                        i7++;
                    }
                    sb.append(strArr2[i3]);
                    i7 = strArr[i3].length() + i2;
                    i2 = -1;
                    i3 = -1;
                    for (int i8 = 0; i8 < length2; i8++) {
                        if (!zArr[i8] && (str2 = strArr[i8]) != null && !str2.isEmpty() && strArr2[i8] != null) {
                            int indexOf2 = str.indexOf(strArr[i8], i7);
                            if (indexOf2 == -1) {
                                zArr[i8] = true;
                            } else if (i2 == -1 || indexOf2 < i2) {
                                i3 = i8;
                                i2 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i7 < length4) {
                    sb.append(str.charAt(i7));
                    i7++;
                }
                String sb2 = sb.toString();
                if (!z) {
                    return sb2;
                }
                return IIOIX(sb2, strArr, strArr2, z, i - 1);
            }
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        return str;
    }

    public static boolean IIX0(CharSequence charSequence) {
        return !xOOOX(charSequence);
    }

    public static int IIX0o(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (XIXIX(charSequence) || XIXIX(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int I0Io2 = II0XooXoX.I0Io(charSequence, charSequence2, i);
            if (I0Io2 != -1) {
                i2++;
                i = I0Io2 + charSequence2.length();
            } else {
                return i2;
            }
        }
    }

    public static boolean IIXOooo(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return xoXoI(charSequence, II0XooXoX.II0XooXoX(charSequence2));
    }

    public static boolean IIxOXoOo0(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean IO(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!XIXIX(charSequence) && !oxoX.XOxxooXI(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (Xx000oIo(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String IO0XoXxO(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        Object obj = objArr[i];
        if (obj != null) {
            O0xxXxI2.append(obj);
        }
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(str);
                Object obj2 = objArr[i];
                if (obj2 != null) {
                    O0xxXxI2.append(obj2);
                }
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static String IOOoXo0Ix(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(str.length() - i);
    }

    public static int IOoo(CharSequence charSequence, int i) {
        if (XIXIX(charSequence)) {
            return -1;
        }
        return II0XooXoX.oxoX(charSequence, i, charSequence.length());
    }

    public static String IXIxx0(String str, char c) {
        if (!XIXIX(str) && c != 0 && str.length() != 1 && str.charAt(0) == c && str.charAt(str.length() - 1) == c) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static String IXO(double[] dArr, char c, int i, int i2) {
        if (dArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append(dArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append(dArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static String IXX(String str, int i) {
        if (XIXIX(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(i);
        if (lastIndexOf != -1 && lastIndexOf != str.length() - 1) {
            return str.substring(lastIndexOf + 1);
        }
        return "";
    }

    public static String IXXIXx00I(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2) && str.length() != 1 && oO0IXx(str, str2) && Xx000oIo(str, str2)) {
            int indexOf = str.indexOf(str2);
            int lastIndexOf = str.lastIndexOf(str2);
            int length = str2.length();
            if (indexOf != -1 && lastIndexOf != -1) {
                return str.substring(indexOf + length, lastIndexOf);
            }
            return str;
        }
        return str;
    }

    public static String[] IXoIo(String str, String str2) {
        return I00O(str, str2, -1, true);
    }

    public static String IXxOIOO(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static int IXxxXO(String str, String str2) {
        return Oxx0xo(str, str2, true);
    }

    public static boolean Io(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        return II0XooXoX.XO(charSequence, true, 0, charSequence2, 0, charSequence.length());
    }

    public static String IoIOOxIIo(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return o0oIxOo(iterable.iterator(), str);
    }

    public static String IoOoX(String str) {
        if (XIXIX(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str;
        }
        return new String(cArr, 0, i);
    }

    public static int IoOoo(CharSequence charSequence, char... cArr) {
        if (!XIXIX(charSequence) && !oxoX.x0(cArr)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt && (i3 >= i || i4 >= i2 || !Character.isHighSurrogate(charAt) || cArr[i4 + 1] == charSequence.charAt(i3 + 1))) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public static String IoX(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2)) {
            int lastIndexOf = str.lastIndexOf(str2);
            if (lastIndexOf == -1) {
                return str;
            }
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String IoXIXo(int[] iArr, char c, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append(iArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append(iArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static int Ioxxx(CharSequence... charSequenceArr) {
        if (oxoX.XoI0Ixx0(charSequenceArr) <= 1) {
            return -1;
        }
        int length = charSequenceArr.length;
        int i = Integer.MAX_VALUE;
        boolean z = true;
        int i2 = 0;
        boolean z2 = false;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence == null) {
                i = 0;
                z2 = true;
            } else {
                i = Math.min(charSequence.length(), i);
                i2 = Math.max(charSequence.length(), i2);
                z = false;
            }
        }
        if (z || (i2 == 0 && !z2)) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            char charAt = charSequenceArr[0].charAt(i4);
            int i5 = 1;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (charSequenceArr[i5].charAt(i4) != charAt) {
                    i3 = i4;
                    break;
                }
                i5++;
            }
            if (i3 != -1) {
                break;
            }
        }
        if (i3 == -1 && i != i2) {
            return i;
        }
        return i3;
    }

    public static String Ix0(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (XIXIX(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return Oxo00O(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String Ix00oIoI(float[] fArr, char c, int i, int i2) {
        if (fArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append(fArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append(fArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static String Ix0x(String str, String str2) {
        int OIx00oxx2 = OIx00oxx(str);
        if (OIx00oxx2 == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != OIx00oxx2 && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (i != OIx00oxx2 && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String IxI(String str, String str2) {
        if (XIXIX(str)) {
            return str;
        }
        return OXooXo(Ix0x(str, str2), str2);
    }

    public static String IxIX0I(char[] cArr, char c, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append(cArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append(cArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static String IxIo(String str, String str2, String str3) {
        return xIx0XO(str, str2, str3, 1);
    }

    public static int IxX00(CharSequence charSequence, CharSequence charSequence2, int i) {
        return XO0o(charSequence, charSequence2, i, false);
    }

    public static boolean O0(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int[] O00(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int max = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i = 0;
        for (int i2 = 0; i2 < charSequence3.length(); i2++) {
            char charAt = charSequence3.charAt(i2);
            int max2 = Math.max(i2 - max, 0);
            int min = Math.min(i2 + max + 1, charSequence4.length());
            while (true) {
                if (max2 >= min) {
                    break;
                }
                if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                    iArr[i2] = max2;
                    zArr[max2] = true;
                    i++;
                    break;
                }
                max2++;
            }
        }
        char[] cArr = new char[i];
        char[] cArr2 = new char[i];
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence3.length(); i4++) {
            if (iArr[i4] != -1) {
                cArr[i3] = charSequence3.charAt(i4);
                i3++;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < charSequence4.length(); i6++) {
            if (zArr[i6]) {
                cArr2[i5] = charSequence4.charAt(i6);
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            if (cArr[i8] != cArr2[i8]) {
                i7++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < charSequence3.length() && charSequence.charAt(i10) == charSequence2.charAt(i10); i10++) {
            i9++;
        }
        return new int[]{i, i7 / 2, i9, charSequence4.length()};
    }

    public static boolean O00XxXI(CharSequence... charSequenceArr) {
        if (oxoX.XOxxooXI(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (xOoOIoI(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static String O0IxXx(int[] iArr, char c) {
        if (iArr == null) {
            return null;
        }
        return IoXIXo(iArr, c, 0, iArr.length);
    }

    public static String O0O0Io00X(byte[] bArr, Charset charset) {
        return new String(bArr, OOXIXo.II0xO0(charset));
    }

    public static String[] O0OOX0IIx(String str) {
        return xoX(str, false);
    }

    public static boolean O0X(CharSequence... charSequenceArr) {
        return !OX00O0xII(charSequenceArr);
    }

    public static int O0Xx(CharSequence charSequence, int i, int i2) {
        if (XIXIX(charSequence)) {
            return -1;
        }
        return II0XooXoX.II0xO0(charSequence, i, i2);
    }

    public static String O0o0(String str, int i) {
        if (XIXIX(str)) {
            return str;
        }
        int indexOf = str.indexOf(i);
        if (indexOf == -1) {
            return "";
        }
        return str.substring(indexOf + 1);
    }

    public static String[] O0x(String str, String str2, int i) {
        return o0Oo(str, str2, i, true);
    }

    public static String O0xO0(String str) {
        int OIx00oxx2 = OIx00oxx(str);
        if (OIx00oxx2 == 0) {
            return str;
        }
        int codePointAt = str.codePointAt(0);
        int lowerCase = Character.toLowerCase(codePointAt);
        if (codePointAt == lowerCase) {
            return str;
        }
        int[] iArr = new int[OIx00oxx2];
        iArr[0] = lowerCase;
        int charCount = Character.charCount(codePointAt);
        int i = 1;
        while (charCount < OIx00oxx2) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public static boolean O0xOxO(CharSequence charSequence, String str) {
        if (charSequence != null && str != null) {
            return X0IIOO(charSequence, str.toCharArray());
        }
        return true;
    }

    public static StringBuilder O0xxXxI(int i) {
        return new StringBuilder(i * 16);
    }

    public static boolean OI0(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (oxoX.o0IXXIx(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (Io(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String OIIXOxo(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.ROOT);
    }

    public static String OIOoIIOIx(byte[] bArr, char c) {
        if (bArr == null) {
            return null;
        }
        return x0OIX00oO(bArr, c, 0, bArr.length);
    }

    public static String[] OIoxIx(String... strArr) {
        return oXoXxOo(strArr, null);
    }

    public static int OIx00oxx(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String OIxI0O(String str, String str2) {
        int indexOf;
        if (XIXIX(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String[] OIxOX(String str) {
        return I00O(str, null, -1, true);
    }

    public static String[] OIxx0I0(String str) {
        return xoX(str, true);
    }

    public static int OO(CharSequence charSequence, String str) {
        if (!XIXIX(charSequence) && !XIXIX(str)) {
            return IoOoo(charSequence, str.toCharArray());
        }
        return -1;
    }

    public static String OO0(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return OooI(str, i, String.valueOf(c));
        }
        return XO00XOO(c, length).concat(str);
    }

    public static int OO0x0xX(CharSequence charSequence, char... cArr) {
        if (!XIXIX(charSequence) && !oxoX.x0(cArr)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt && (i3 >= i || i4 >= i2 || !Character.isHighSurrogate(charAt) || cArr[i4 + 1] == charSequence.charAt(i3 + 1))) {
                    }
                }
                return i3;
            }
        }
        return -1;
    }

    public static String OOIXx0x(String str, String str2, String str3) {
        return xIx0XO(str, str2, str3, -1);
    }

    @Deprecated
    public static String OOOI(String str, String str2) {
        return xII.oIX0oI(str, str2);
    }

    public static String OOXIXo(String str, int i, char c) {
        if (str != null && i > 0) {
            int length = str.length();
            int i2 = i - length;
            if (i2 <= 0) {
                return str;
            }
            return Oxo00O(OO0(str, length + (i2 / 2), c), i, c);
        }
        return str;
    }

    public static boolean OOXIxO0(CharSequence charSequence) {
        if (XIXIX(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String OOxOI(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2) && xXo(str, str2)) {
            return str.substring(str2.length());
        }
        return str;
    }

    public static String OOxOOxIO(String str) {
        if (str == null) {
            return "";
        }
        return IxI(str, null);
    }

    public static int OX(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            if (i > charSequence.length() - charSequence2.length()) {
                i = charSequence.length() - charSequence2.length();
            }
            if (i < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i;
            }
            while (i >= 0) {
                if (II0XooXoX.XO(charSequence, true, i, charSequence2, 0, charSequence2.length())) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static boolean OX00O0xII(CharSequence... charSequenceArr) {
        if (oxoX.XOxxooXI(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (XIXIX(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static String[] OXIOoo0X0(String str, String str2, int i) {
        return I00O(str, str2, i, true);
    }

    public static String OXXoIoXI(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i != 1 && length != 0) {
            if (length == 1 && i <= 8192) {
                return XO00XOO(str.charAt(0), i);
            }
            int i2 = length * i;
            if (length != 1) {
                if (length != 2) {
                    StringBuilder sb = new StringBuilder(i2);
                    for (int i3 = 0; i3 < i; i3++) {
                        sb.append(str);
                    }
                    return sb.toString();
                }
                char charAt = str.charAt(0);
                char charAt2 = str.charAt(1);
                char[] cArr = new char[i2];
                for (int i4 = (i * 2) - 2; i4 >= 0; i4 -= 2) {
                    cArr[i4] = charAt;
                    cArr[i4 + 1] = charAt2;
                }
                return new String(cArr);
            }
            return XO00XOO(str.charAt(0), i);
        }
        return str;
    }

    public static String OXooXo(String str, String str2) {
        int OIx00oxx2 = OIx00oxx(str);
        if (OIx00oxx2 == 0) {
            return str;
        }
        if (str2 == null) {
            while (OIx00oxx2 != 0 && Character.isWhitespace(str.charAt(OIx00oxx2 - 1))) {
                OIx00oxx2--;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (OIx00oxx2 != 0 && str2.indexOf(str.charAt(OIx00oxx2 - 1)) != -1) {
                OIx00oxx2--;
            }
        }
        return str.substring(0, OIx00oxx2);
    }

    public static int Oo(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            if (!z) {
                return 1;
            }
            return -1;
        }
        if (str2 == null) {
            if (z) {
                return 1;
            }
            return -1;
        }
        return str.compareTo(str2);
    }

    public static String[] OoIXo(String str, String str2, String str3) {
        int indexOf;
        int i;
        int indexOf2;
        if (str == null || XIXIX(str2) || XIXIX(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return oxoX.f32758OxxIIOOXO;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < length - length2 && (indexOf = str.indexOf(str2, i2)) >= 0 && (indexOf2 = str.indexOf(str3, (i = indexOf + length3))) >= 0) {
            arrayList.add(str.substring(i, indexOf2));
            i2 = indexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
    }

    public static String OoO(List<?> list, String str, int i, int i2) {
        if (list == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        return o0oIxOo(list.subList(i, i2).iterator(), str);
    }

    public static String OooI(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (XIXIX(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return OO0(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String[] OooO0XOx(String str, String str2, int i) {
        return o0Oo(str, str2, i, false);
    }

    public static boolean Ox0O(CharSequence charSequence) {
        if (XIXIX(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean OxI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            for (int i = 0; i <= length2; i++) {
                if (II0XooXoX.XO(charSequence, true, i, charSequence2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public static String OxO(String str, String str2) {
        return X0ooXIooI(str, str2, "");
    }

    public static String OxXXx0X(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2)) {
            return xIx0XO(str, str2, "", -1);
        }
        return str;
    }

    public static String Oxo00O(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return Ix0(str, i, String.valueOf(c));
        }
        return str.concat(XO00XOO(c, length));
    }

    public static int Oxx(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return OX(charSequence, charSequence2, charSequence.length());
        }
        return -1;
    }

    public static String Oxx0IOOO(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return XO(str, charSequence, false, charSequenceArr);
    }

    public static int Oxx0xo(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            if (!z) {
                return 1;
            }
            return -1;
        }
        if (str2 == null) {
            if (z) {
                return 1;
            }
            return -1;
        }
        return str.compareToIgnoreCase(str2);
    }

    public static boolean OxxIIOOXO(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null || II0XooXoX.I0Io(charSequence, charSequence2, 0) < 0) {
            return false;
        }
        return true;
    }

    public static boolean X00IoxXI(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence != null && charSequence2 != null) {
            if (charSequence2.length() > charSequence.length()) {
                return false;
            }
            return II0XooXoX.XO(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
        }
        if (charSequence != charSequence2) {
            return false;
        }
        return true;
    }

    public static String X00xOoXI(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2) && str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return str;
    }

    public static boolean X0IIOO(CharSequence charSequence, char... cArr) {
        if (charSequence != null && cArr != null) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                            return false;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static String X0IOOI(String str, int i) {
        return Oxo00O(str, i, TokenParser.SP);
    }

    public static String X0O0I0(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2) && xII(str, str2)) {
            return str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static String X0o0xo(String str, String str2, int i) {
        if (!OX00O0xII(str, str2) && i < str.length() && i >= str2.length() + 2) {
            int length = i - str2.length();
            int i2 = length / 2;
            return str.substring(0, (length % 2) + i2) + str2 + str.substring(str.length() - i2);
        }
        return str;
    }

    @Deprecated
    public static String X0ooXIooI(String str, String str2, String str3) {
        return xII.II0XooXoX(str, str2, str3);
    }

    public static String X0x(String str, char c) {
        boolean z;
        if (!XIXIX(str) && c != 0) {
            boolean z2 = false;
            if (str.charAt(0) != c) {
                z = true;
            } else {
                z = false;
            }
            if (str.charAt(str.length() - 1) != c) {
                z2 = true;
            }
            if (!z && !z2) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + 2);
            if (z) {
                sb.append(c);
            }
            sb.append(str);
            if (z2) {
                sb.append(c);
            }
            return sb.toString();
        }
        return str;
    }

    public static String X0xII0I(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        Object obj = objArr[i];
        if (obj != null) {
            O0xxXxI2.append(obj);
        }
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                Object obj2 = objArr[i];
                if (obj2 != null) {
                    O0xxXxI2.append(obj2);
                }
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static String X0xOO(String str) {
        if (XIXIX(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!Character.isUpperCase(codePointAt) && !Character.isTitleCase(codePointAt)) {
                if (Character.isLowerCase(codePointAt)) {
                    codePointAt = Character.toUpperCase(codePointAt);
                }
            } else {
                codePointAt = Character.toLowerCase(codePointAt);
            }
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static String X0xxXX0(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return IO0XoXxO(objArr, str, 0, objArr.length);
    }

    public static String XI(String str, Object... objArr) {
        if (objArr != null) {
            String oo0xXOI0I2 = oo0xXOI0I(str);
            StringBuilder sb = new StringBuilder();
            Iterator it = Arrays.asList(objArr).iterator();
            while (it.hasNext()) {
                sb.append(Objects.toString(it.next(), ""));
                if (it.hasNext()) {
                    sb.append(oo0xXOI0I2);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Object varargs must not be null");
    }

    public static boolean XI0IXoo(CharSequence charSequence, String str) {
        if (charSequence != null && str != null) {
            return XIxXXX0x0(charSequence, str.toCharArray());
        }
        return false;
    }

    public static boolean XI0oooXX(CharSequence charSequence) {
        if (XIXIX(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isUpperCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String XIOOI(String str) {
        if (str == null) {
            return null;
        }
        String IxI2 = IxI(str, null);
        if (IxI2.isEmpty()) {
            return null;
        }
        return IxI2;
    }

    public static boolean XIXIX(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static String XIXIxO(List<?> list, char c, int i, int i2) {
        if (list == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        return oxIIX0o(list.subList(i, i2).iterator(), c);
    }

    public static int XIo0oOXIx(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i = 0;
        if (charSequence != null && charSequence2 != null) {
            while (i < charSequence.length() && i < charSequence2.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
                i++;
            }
            if (i >= charSequence2.length() && i >= charSequence.length()) {
                return -1;
            }
        }
        return i;
    }

    public static String XIxO(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static boolean XIxXXX0x0(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        if (cArr.length == 0 || OO0x0xX(charSequence, cArr) != -1) {
            return false;
        }
        return true;
    }

    public static String XO(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str != null && !XIXIX(charSequence) && !X00IoxXI(str, charSequence, z)) {
            if (oxoX.o0IXXIx(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (X00IoxXI(str, charSequence2, z)) {
                        return str;
                    }
                }
            }
            return str + charSequence.toString();
        }
        return str;
    }

    public static String XO00XOO(char c, int i) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            cArr[i2] = c;
        }
        return new String(cArr);
    }

    public static String XO0OX(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2)) {
            boolean startsWith = str.startsWith(str2);
            boolean endsWith = str.endsWith(str2);
            if (startsWith && endsWith) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + str2.length() + str2.length());
            if (!startsWith) {
                sb.append(str2);
            }
            sb.append(str);
            if (!endsWith) {
                sb.append(str2);
            }
            return sb.toString();
        }
        return str;
    }

    public static int XO0o(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        int i2 = -1;
        if (charSequence != null && charSequence2 != null && i > 0) {
            int i3 = 0;
            if (charSequence2.length() == 0) {
                if (!z) {
                    return 0;
                }
                return charSequence.length();
            }
            if (z) {
                i2 = charSequence.length();
            }
            do {
                if (z) {
                    i2 = II0XooXoX.X0o0xo(charSequence, charSequence2, i2 - 1);
                } else {
                    i2 = II0XooXoX.I0Io(charSequence, charSequence2, i2 + 1);
                }
                if (i2 < 0) {
                    return i2;
                }
                i3++;
            } while (i3 < i);
        }
        return i2;
    }

    public static String XOo0(String str, String str2) {
        if (!XIXIX(str) && str2 != null) {
            if (str2.isEmpty()) {
                return "";
            }
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return str;
            }
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static boolean XOxIOxOx(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (oxoX.o0IXXIx(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (x0o(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public static String XOxoX(String str, String str2, String str3) {
        return xII.xoIox(str, str2, str3);
    }

    public static String XOxxooXI(short[] sArr, char c, int i, int i2) {
        if (sArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append((int) sArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append((int) sArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    @SafeVarargs
    public static <T extends CharSequence> T XX(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (xOoOIoI(t)) {
                    return t;
                }
            }
            return null;
        }
        return null;
    }

    public static <T extends CharSequence> T XX0(T t, Supplier<T> supplier) {
        Object obj;
        if (XIXIX(t)) {
            if (supplier != null) {
                obj = supplier.get();
                return (T) obj;
            }
            return null;
        }
        return t;
    }

    public static int XX0xXo(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            if (i < 0) {
                i = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i;
            }
            while (i < length) {
                if (II0XooXoX.XO(charSequence, true, i, charSequence2, 0, charSequence2.length())) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static int XXXI(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            return II0XooXoX.X0o0xo(charSequence, charSequence2, i);
        }
        return -1;
    }

    public static String XXoOx0(char[] cArr, char c) {
        if (cArr == null) {
            return null;
        }
        return IxIX0I(cArr, c, 0, cArr.length);
    }

    public static String Xo(String str, String str2, String str3) {
        if (!XIXIX(str) && !XIXIX(str2)) {
            if (str3 == null) {
                str3 = "";
            }
            int length = str3.length();
            int length2 = str.length();
            StringBuilder sb = new StringBuilder(length2);
            boolean z = false;
            for (int i = 0; i < length2; i++) {
                char charAt = str.charAt(i);
                int indexOf = str2.indexOf(charAt);
                if (indexOf >= 0) {
                    if (indexOf < length) {
                        sb.append(str3.charAt(indexOf));
                    }
                    z = true;
                } else {
                    sb.append(charAt);
                }
            }
            if (z) {
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    @Deprecated
    public static int Xo0(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        int i3;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int min;
        if (charSequence != null && charSequence2 != null) {
            if (i >= 0) {
                int length = charSequence.length();
                int length2 = charSequence2.length();
                if (length == 0) {
                    if (length2 > i) {
                        return -1;
                    }
                    return length2;
                }
                if (length2 == 0) {
                    if (length > i) {
                        return -1;
                    }
                    return length;
                }
                if (Math.abs(length - length2) > i) {
                    return -1;
                }
                if (length > length2) {
                    i3 = charSequence.length();
                    i2 = length2;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i2 = length;
                    i3 = length2;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                int i4 = i2 + 1;
                int[] iArr = new int[i4];
                int[] iArr2 = new int[i4];
                int min2 = Math.min(i2, i) + 1;
                char c = 0;
                for (int i5 = 0; i5 < min2; i5++) {
                    iArr[i5] = i5;
                }
                int i6 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min2, i4, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i7 = 1;
                while (i7 <= i3) {
                    char charAt = charSequence4.charAt(i7 - 1);
                    iArr2[c] = i7;
                    int max = Math.max(1, i7 - i);
                    if (i7 > i6 - i) {
                        min = i2;
                    } else {
                        min = Math.min(i2, i7 + i);
                    }
                    if (max > min) {
                        return -1;
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i6;
                    }
                    while (max <= min) {
                        int i8 = max - 1;
                        if (charSequence3.charAt(i8) == charAt) {
                            iArr2[max] = iArr[i8];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i8], iArr[max]), iArr[i8]) + 1;
                        }
                        max++;
                    }
                    i7++;
                    c = 0;
                    i6 = Integer.MAX_VALUE;
                    int[] iArr3 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr3;
                }
                int i9 = iArr[i2];
                if (i9 > i) {
                    return -1;
                }
                return i9;
            }
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public static int XoI0Ixx0(CharSequence charSequence, int i) {
        if (XIXIX(charSequence)) {
            return -1;
        }
        return II0XooXoX.II0xO0(charSequence, i, 0);
    }

    public static String XoIxOXIXo(String str, int i) {
        return OO0(str, i, TokenParser.SP);
    }

    public static String XoOxI0ox(String str, String[] strArr, String[] strArr2) {
        int length;
        if (strArr == null) {
            length = 0;
        } else {
            length = strArr.length;
        }
        return IIOIX(str, strArr, strArr2, true, length);
    }

    public static String XoX(String... strArr) {
        if (oxoX.XOxxooXI(strArr)) {
            return "";
        }
        int Ioxxx2 = Ioxxx(strArr);
        if (Ioxxx2 == -1) {
            String str = strArr[0];
            if (str == null) {
                return "";
            }
            return str;
        }
        if (Ioxxx2 == 0) {
            return "";
        }
        return strArr[0].substring(0, Ioxxx2);
    }

    public static String XooIO0oo0(String str, String str2, int i) {
        if (str != null && str2 != null) {
            return o0oxo0oI(OXXoIoXI(str + str2, i), str2);
        }
        return OXXoIoXI(str, i);
    }

    public static boolean Xx000oIo(CharSequence charSequence, CharSequence charSequence2) {
        return X00IoxXI(charSequence, charSequence2, false);
    }

    public static String XxI(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static int[] XxIIOXIXx(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() == 0) {
            return oxoX.f32766ooOOo0oXI;
        }
        String charSequence2 = charSequence.toString();
        int codePointCount = charSequence2.codePointCount(0, charSequence2.length());
        int[] iArr = new int[codePointCount];
        int i = 0;
        for (int i2 = 0; i2 < codePointCount; i2++) {
            int codePointAt = charSequence2.codePointAt(i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
        }
        return iArr;
    }

    public static String[] XxIo(String str, char c) {
        return x0oox0(str, c, false);
    }

    public static void XxX0x0xxx(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 321) {
                sb.deleteCharAt(i);
                sb.insert(i, 'L');
            } else if (sb.charAt(i) == 322) {
                sb.deleteCharAt(i);
                sb.insert(i, 'l');
            }
        }
    }

    public static String[] XxXX(String str, String str2) {
        return o0Oo(str, str2, -1, true);
    }

    @SafeVarargs
    public static <T extends CharSequence> T o0(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (IIX0(t)) {
                    return t;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean o00(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!XIXIX(charSequence) && !oxoX.XOxxooXI(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (OxxIIOOXO(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String o00xOoIO(String str) {
        return IxI(str, null);
    }

    public static String o0IXXIx(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    public static boolean o0OO0(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!XIXIX(charSequence) && !oxoX.XOxxooXI(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (oO0IXx(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[] o0Oo(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return oxoX.f32758OxxIIOOXO;
        }
        if (str2 != null && !"".equals(str2)) {
            int length2 = str2.length();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                i2 = str.indexOf(str2, i3);
                if (i2 > -1) {
                    if (i2 > i3) {
                        i4++;
                        if (i4 == i) {
                            arrayList.add(str.substring(i3));
                        } else {
                            arrayList.add(str.substring(i3, i2));
                        }
                    } else if (z) {
                        i4++;
                        if (i4 == i) {
                            arrayList.add(str.substring(i3));
                            i2 = length;
                        } else {
                            arrayList.add("");
                        }
                    }
                    i3 = i2 + length2;
                } else {
                    arrayList.add(str.substring(i3));
                }
                i2 = length;
            }
            return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
        }
        return I00O(str, null, i, z);
    }

    @Deprecated
    public static String o0Xo(String str, String str2) {
        return xII.X0o0xo(str, str2);
    }

    public static String o0oIxOo(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String o0oxo0oI(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2) && str.endsWith(str2)) {
            return str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static boolean o0xxxXXxX(CharSequence... charSequenceArr) {
        if (oxoX.XOxxooXI(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (IIX0(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static String oI(float[] fArr, char c) {
        if (fArr == null) {
            return null;
        }
        return Ix00oIoI(fArr, c, 0, fArr.length);
    }

    public static String oI0(String str, String str2) {
        return xIoXXXIXo(str, str2, str2);
    }

    public static boolean oI0IIXIo(CharSequence charSequence, int i) {
        if (XIXIX(charSequence) || II0XooXoX.II0xO0(charSequence, i, 0) < 0) {
            return false;
        }
        return true;
    }

    public static String oI0X0(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.ROOT);
    }

    public static int oIIxXoo(CharSequence charSequence, int i, int i2) {
        if (XIXIX(charSequence)) {
            return -1;
        }
        return II0XooXoX.oxoX(charSequence, i, i2);
    }

    public static String oIX0oI(String str, int i) {
        return oxoX(str, "...", 0, i);
    }

    @Deprecated
    public static String oIXoXx0(byte[] bArr, String str) throws UnsupportedEncodingException {
        String str2;
        if (str != null) {
            str2 = new String(bArr, str);
        } else {
            str2 = new String(bArr, Charset.defaultCharset());
        }
        return str2;
    }

    public static String oO(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String substring = str.substring(0, i);
        if (str.charAt(i) == '\n') {
            int i2 = length - 2;
            if (substring.charAt(i2) == '\r') {
                return substring.substring(0, i2);
            }
        }
        return substring;
    }

    public static boolean oO0IXx(CharSequence charSequence, CharSequence charSequence2) {
        return ooO0oXxI(charSequence, charSequence2, false);
    }

    public static String oOXoIIIo(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int XIo0oOXIx2 = XIo0oOXIx(str, str2);
        if (XIo0oOXIx2 == -1) {
            return "";
        }
        return str2.substring(XIo0oOXIx2);
    }

    public static boolean oOo(CharSequence... charSequenceArr) {
        return !xoO0xx0(charSequenceArr);
    }

    public static String oOoIIO0(double[] dArr, char c) {
        if (dArr == null) {
            return null;
        }
        return IXO(dArr, c, 0, dArr.length);
    }

    public static String oOoXoXO(String str, int i, String str2) {
        if (str != null && i > 0) {
            if (XIXIX(str2)) {
                str2 = " ";
            }
            int length = str.length();
            int i2 = i - length;
            if (i2 <= 0) {
                return str;
            }
            return Ix0(OooI(str, length + (i2 / 2), str2), i, str2);
        }
        return str;
    }

    @Deprecated
    public static int oX(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                return length2;
            }
            if (length2 == 0) {
                return length;
            }
            if (length > length2) {
                length2 = charSequence.length();
                length = length2;
            } else {
                charSequence2 = charSequence;
                charSequence = charSequence2;
            }
            int[] iArr = new int[length + 1];
            for (int i2 = 0; i2 <= length; i2++) {
                iArr[i2] = i2;
            }
            for (int i3 = 1; i3 <= length2; i3++) {
                int i4 = iArr[0];
                char charAt = charSequence.charAt(i3 - 1);
                iArr[0] = i3;
                int i5 = 1;
                while (i5 <= length) {
                    int i6 = iArr[i5];
                    int i7 = i5 - 1;
                    if (charSequence2.charAt(i7) == charAt) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    iArr[i5] = Math.min(Math.min(iArr[i7] + 1, iArr[i5] + 1), i4 + i);
                    i5++;
                    i4 = i6;
                }
            }
            return iArr[length];
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public static String oX000x(String str, String str2, String str3) {
        return xIOXX(str, str2, str3, -1);
    }

    public static String oX0I0O(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 <= length) {
            length = i2;
        }
        if (i > length) {
            int i3 = length;
            length = i;
            i = i3;
        }
        return str.substring(0, i) + str2 + str.substring(length);
    }

    public static String oX0ooo0I0(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return x00IOx(str, charSequence, true, charSequenceArr);
    }

    public static boolean oXIO0o0XI(CharSequence charSequence) {
        if (XIXIX(charSequence) || charSequence.length() == 1) {
            return false;
        }
        int length = charSequence.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            if (z && z2) {
                return true;
            }
            if (Character.isUpperCase(charSequence.charAt(i))) {
                z = true;
            } else if (Character.isLowerCase(charSequence.charAt(i))) {
                z2 = true;
            }
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public static int oXIoO(CharSequence charSequence, CharSequence charSequence2, int i) {
        return XO0o(charSequence, charSequence2, i, true);
    }

    public static String oXO0oOx0(String str, String[] strArr, String[] strArr2) {
        return IIOIX(str, strArr, strArr2, false, 0);
    }

    public static int oXX0IoI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return II0XooXoX.X0o0xo(charSequence, charSequence2, charSequence.length());
        }
        return -1;
    }

    public static String[] oXoXxOo(String[] strArr, String str) {
        int XoI0Ixx02 = oxoX.XoI0Ixx0(strArr);
        if (XoI0Ixx02 == 0) {
            return strArr;
        }
        String[] strArr2 = new String[XoI0Ixx02];
        for (int i = 0; i < XoI0Ixx02; i++) {
            strArr2[i] = IxI(strArr[i], str);
        }
        return strArr2;
    }

    public static String oXxOI0oIx(short[] sArr, char c) {
        if (sArr == null) {
            return null;
        }
        return XOxxooXI(sArr, c, 0, sArr.length);
    }

    public static String oXxx000(String str, String str2, String str3, int i, boolean z) {
        int xoxXI2;
        int min;
        if (!XIXIX(str) && !XIXIX(str2) && str3 != null && i != 0) {
            if (z) {
                str2 = str2.toLowerCase();
            }
            int i2 = 0;
            if (z) {
                xoxXI2 = XX0xXo(str, str2, 0);
            } else {
                xoxXI2 = xoxXI(str, str2, 0);
            }
            if (xoxXI2 == -1) {
                return str;
            }
            int length = str2.length();
            int max = Math.max(str3.length() - length, 0);
            if (i < 0) {
                min = 16;
            } else {
                min = Math.min(i, 64);
            }
            StringBuilder sb = new StringBuilder(str.length() + (max * min));
            while (xoxXI2 != -1) {
                sb.append((CharSequence) str, i2, xoxXI2);
                sb.append(str3);
                i2 = xoxXI2 + length;
                i--;
                if (i == 0) {
                    break;
                }
                if (z) {
                    xoxXI2 = XX0xXo(str, str2, i2);
                } else {
                    xoxXI2 = xoxXI(str, str2, i2);
                }
            }
            sb.append((CharSequence) str, i2, str.length());
            return sb.toString();
        }
        return str;
    }

    public static String oo(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String oo00(String str, char c) {
        if (!XIXIX(str) && str.indexOf(c) != -1) {
            char[] charArray = str.toCharArray();
            int i = 0;
            for (char c2 : charArray) {
                if (c2 != c) {
                    charArray[i] = c2;
                    i++;
                }
            }
            return new String(charArray, 0, i);
        }
        return str;
    }

    public static String[] oo0oIXo(String str, String str2, int i) {
        return I00O(str, str2, i, false);
    }

    public static String oo0xXOI0I(String str) {
        return oo(str, "");
    }

    public static boolean ooO0oXxI(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence != null && charSequence2 != null) {
            if (charSequence2.length() > charSequence.length()) {
                return false;
            }
            return II0XooXoX.XO(charSequence, z, 0, charSequence2, 0, charSequence2.length());
        }
        if (charSequence != charSequence2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r5 != '\r') goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String ooOOo0oXI(java.lang.String r6) {
        /*
            boolean r0 = XIXIX(r6)
            if (r0 == 0) goto L7
            return r6
        L7:
            int r0 = r6.length()
            r1 = 10
            r2 = 0
            r3 = 1
            r4 = 13
            if (r0 != r3) goto L20
            char r0 = r6.charAt(r2)
            if (r0 == r4) goto L1d
            if (r0 != r1) goto L1c
            goto L1d
        L1c:
            return r6
        L1d:
            java.lang.String r6 = ""
            return r6
        L20:
            int r0 = r6.length()
            int r3 = r0 + (-1)
            char r5 = r6.charAt(r3)
            if (r5 != r1) goto L37
            int r1 = r0 + (-2)
            char r1 = r6.charAt(r1)
            if (r1 != r4) goto L3a
            int r0 = r0 + (-2)
            goto L3b
        L37:
            if (r5 == r4) goto L3a
            goto L3b
        L3a:
            r0 = r3
        L3b:
            java.lang.String r6 = r6.substring(r2, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.xXOx.ooOOo0oXI(java.lang.String):java.lang.String");
    }

    public static boolean ooOx(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static <T extends CharSequence> T ooXIXxIX(T t, T t2) {
        if (xOOOX(t)) {
            return t2;
        }
        return t;
    }

    public static String oox000IX(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static boolean ox(CharSequence charSequence) {
        if (XIXIX(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLowerCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String ox0I(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        if (i > i2) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return str.substring(i, i2);
    }

    public static String oxIIX0o(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String[] oxIO0IIo(String str, String str2) {
        return I00O(str, str2, -1, false);
    }

    public static String oxOXxoXII(String str) {
        if (XIXIX(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 1;
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (Character.isWhitespace(charAt)) {
                if (i3 == 0 && !z) {
                    cArr[i2] = " ".charAt(0);
                    i2++;
                }
                i3++;
            } else {
                int i5 = i2 + 1;
                if (charAt == 160) {
                    charAt = TokenParser.SP;
                }
                cArr[i2] = charAt;
                i2 = i5;
                z = false;
                i3 = 0;
            }
        }
        if (z) {
            return "";
        }
        if (i3 <= 0) {
            i = 0;
        }
        return new String(cArr, 0, i2 - i).trim();
    }

    public static String oxXx0IX(String str) {
        if (XIXIX(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String oxoX(String str, String str2, int i, int i2) {
        if (xOoOIoI(str) && "".equals(str2) && i2 > 0) {
            return ox0I(str, 0, i2);
        }
        if (OX00O0xII(str, str2)) {
            return str;
        }
        int length = str2.length();
        int i3 = length + 1;
        int i4 = length + length + 1;
        if (i2 >= i3) {
            if (str.length() <= i2) {
                return str;
            }
            if (i > str.length()) {
                i = str.length();
            }
            int i5 = i2 - length;
            if (str.length() - i < i5) {
                i = str.length() - i5;
            }
            if (i <= i3) {
                return str.substring(0, i5) + str2;
            }
            if (i2 >= i4) {
                if ((i2 + i) - length < str.length()) {
                    return str2 + I0Io(str.substring(i), str2, i5);
                }
                return str2 + str.substring(str.length() - i5);
            }
            throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", Integer.valueOf(i4)));
        }
        throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", Integer.valueOf(i3)));
    }

    public static byte[] oxxXoxO(String str, Charset charset) {
        if (str == null) {
            return oxoX.f32749I0Io;
        }
        return str.getBytes(OOXIXo.II0xO0(charset));
    }

    public static String x0(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return X0xII0I(objArr, c, 0, objArr.length);
    }

    public static String x00IOx(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str != null && !XIXIX(charSequence) && !ooO0oXxI(str, charSequence, z)) {
            if (oxoX.o0IXXIx(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (ooO0oXxI(str, charSequence2, z)) {
                        return str;
                    }
                }
            }
            return charSequence.toString() + str;
        }
        return str;
    }

    public static String x00X0xoXO(String str, String str2) {
        int lastIndexOf;
        if (XIXIX(str)) {
            return str;
        }
        if (XIXIX(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String x0OIX00oO(byte[] bArr, char c, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append((int) bArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append((int) bArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static String[] x0OOI(String str, char c) {
        return x0oox0(str, c, true);
    }

    @SafeVarargs
    public static <T> String x0OxxIOxX(T... tArr) {
        return X0xxXX0(tArr, null);
    }

    @Deprecated
    public static String x0XOIxOo(String str, String str2) {
        return o0oxo0oI(str, str2);
    }

    public static boolean x0o(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String[] x0oox0(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return oxoX.f32758OxxIIOOXO;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i < length) {
            if (str.charAt(i) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z2 = false;
                    z3 = true;
                }
                i2 = i + 1;
                i = i2;
            } else {
                i++;
                z2 = true;
                z3 = false;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
    }

    public static String x0oxIIIX(String str, String str2, String str3) {
        return xIOXX(str, str2, str3, 1);
    }

    public static int x0xO(CharSequence charSequence, CharSequence charSequence2) {
        boolean z;
        if (!XIXIX(charSequence) && !XIXIX(charSequence2)) {
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                char charAt = charSequence.charAt(i);
                if (II0XooXoX.II0xO0(charSequence2, charAt, 0) >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                int i2 = i + 1;
                if (i2 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i2);
                    if (z && II0XooXoX.II0xO0(charSequence2, charAt2, 0) < 0) {
                        return i;
                    }
                } else if (!z) {
                    return i;
                }
                i = i2;
            }
        }
        return -1;
    }

    public static int x0xO0oo(String str, String str2) {
        return Oo(str, str2, true);
    }

    public static <T extends CharSequence> T xI(T t, T t2) {
        if (XIXIX(t)) {
            return t2;
        }
        return t;
    }

    public static String xI0oxI00(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return oxIIX0o(iterable.iterator(), c);
    }

    public static boolean xII(CharSequence charSequence, CharSequence charSequence2) {
        return X00IoxXI(charSequence, charSequence2, true);
    }

    public static String xIOXX(String str, String str2, String str3, int i) {
        return oXxx000(str, str2, str3, i, true);
    }

    public static String xIXIOX(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String xIXOoI(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFD));
        XxX0x0xxx(sb);
        return f32947II0XooXoX.matcher(sb).replaceAll("");
    }

    public static String xIXX(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String xIoXXXIXo(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (!ObjectUtils.oOoXoXO(str, str2, str3) || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static String xIx(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String xIx0XO(String str, String str2, String str3, int i) {
        return oXxx000(str, str2, str3, i, false);
    }

    public static String[] xIxooxXX(String str) {
        return oo0oIXo(str, null, -1);
    }

    public static boolean xOOOX(CharSequence charSequence) {
        int OIx00oxx2 = OIx00oxx(charSequence);
        if (OIx00oxx2 == 0) {
            return true;
        }
        for (int i = 0; i < OIx00oxx2; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static String xOOxI(String str, String str2, String str3) {
        return xII.XO(str, str2, str3);
    }

    public static String xOOxIO(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 >= 0 && i <= str.length()) {
            if (i < 0) {
                i = 0;
            }
            int i3 = i2 + i;
            if (str.length() <= i3) {
                return str.substring(i);
            }
            return str.substring(i, i3);
        }
        return "";
    }

    public static boolean xOoOIoI(CharSequence charSequence) {
        return !XIXIX(charSequence);
    }

    public static String xX(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return x00IOx(str, charSequence, false, charSequenceArr);
    }

    public static boolean xX0IIXIx0(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!xoIox.xxIXOIIO(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String xX0ox(String str) {
        String XxI2 = XxI(str);
        if (XIXIX(XxI2)) {
            return null;
        }
        return XxI2;
    }

    public static <T extends CharSequence> T xXOx(T t, Supplier<T> supplier) {
        Object obj;
        if (xOOOX(t)) {
            if (supplier != null) {
                obj = supplier.get();
                return (T) obj;
            }
            return null;
        }
        return t;
    }

    public static boolean xXo(CharSequence charSequence, CharSequence charSequence2) {
        return ooO0oXxI(charSequence, charSequence2, true);
    }

    public static String xXoOI00O(long[] jArr, char c, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder O0xxXxI2 = O0xxXxI(i3);
        O0xxXxI2.append(jArr[i]);
        while (true) {
            i++;
            if (i < i2) {
                O0xxXxI2.append(c);
                O0xxXxI2.append(jArr[i]);
            } else {
                return O0xxXxI2.toString();
            }
        }
    }

    public static int xXxxox0I(CharSequence charSequence, char c) {
        if (XIXIX(charSequence)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (c == charSequence.charAt(i2)) {
                i++;
            }
        }
        return i;
    }

    public static String xo(String str, char c) {
        if (str == null) {
            return null;
        }
        String[] XxIo2 = XxIo(str, c);
        oxoX.OoI0OO(XxIo2);
        return x0(XxIo2, c);
    }

    @Deprecated
    public static int xo0x(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        if (charSequence != null && charSequence2 != null) {
            if (locale != null) {
                String lowerCase = charSequence.toString().toLowerCase(locale);
                String lowerCase2 = charSequence2.toString().toLowerCase(locale);
                int i = Integer.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < lowerCase2.length(); i4++) {
                    char charAt = lowerCase2.charAt(i4);
                    boolean z = false;
                    while (i3 < lowerCase.length() && !z) {
                        if (charAt == lowerCase.charAt(i3)) {
                            int i5 = i2 + 1;
                            if (i + 1 == i3) {
                                i5 = i2 + 3;
                            }
                            i = i3;
                            i2 = i5;
                            z = true;
                        }
                        i3++;
                    }
                }
                return i2;
            }
            throw new IllegalArgumentException("Locale must not be null");
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public static String xoIXOxX(String str, int i) {
        return xooxxX(str, 0, i);
    }

    public static String xoIox(String str, int i) {
        return OOXIXo(str, i, TokenParser.SP);
    }

    public static int xoIxX(CharSequence charSequence, CharSequence... charSequenceArr) {
        int I0Io2;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (charSequence2 != null && (I0Io2 = II0XooXoX.I0Io(charSequence, charSequence2, 0)) != -1 && I0Io2 < i) {
                i = I0Io2;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static boolean xoO0xx0(CharSequence... charSequenceArr) {
        if (oxoX.XOxxooXI(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (xOOOX(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static String[] xoX(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return oxoX.f32758OxxIIOOXO;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int type = Character.getType(charArray[0]);
        for (int i2 = 1; i2 < charArray.length; i2++) {
            int type2 = Character.getType(charArray[i2]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i3 = i2 - 1;
                    if (i3 != i) {
                        arrayList.add(new String(charArray, i, i3 - i));
                        i = i3;
                    }
                } else {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(oxoX.f32758OxxIIOOXO);
    }

    public static boolean xoXoI(CharSequence charSequence, char... cArr) {
        if (!XIXIX(charSequence) && !oxoX.x0(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = length - 1;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                            return true;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String xooxxX(String str, int i, int i2) {
        if (i >= 0) {
            if (i2 >= 0) {
                if (str == null) {
                    return null;
                }
                if (i > str.length()) {
                    return "";
                }
                if (str.length() > i2) {
                    return str.substring(i, Math.min(i2 + i, str.length()));
                }
                return str.substring(i);
            }
            throw new IllegalArgumentException("maxWith cannot be negative");
        }
        throw new IllegalArgumentException("offset cannot be negative");
    }

    public static String xox(String str, int i) {
        int i2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (i != 0 && length != 0 && (i2 = i % length) != 0) {
            StringBuilder sb = new StringBuilder(length);
            int i3 = -i2;
            sb.append(oox000IX(str, i3));
            sb.append(ox0I(str, 0, i3));
            return sb.toString();
        }
        return str;
    }

    public static int xoxXI(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            return II0XooXoX.I0Io(charSequence, charSequence2, i);
        }
        return -1;
    }

    public static String[] xx0(String str, String str2) {
        return o0Oo(str, str2, -1, false);
    }

    public static boolean xx0X0(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String xx0o0O(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static int xxIO(CharSequence charSequence, CharSequence charSequence2) {
        return XX0xXo(charSequence, charSequence2, 0);
    }

    public static String xxIXOIIO(String str) {
        int OIx00oxx2 = OIx00oxx(str);
        if (OIx00oxx2 == 0) {
            return str;
        }
        int codePointAt = str.codePointAt(0);
        int titleCase = Character.toTitleCase(codePointAt);
        if (codePointAt == titleCase) {
            return str;
        }
        int[] iArr = new int[OIx00oxx2];
        iArr[0] = titleCase;
        int charCount = Character.charCount(codePointAt);
        int i = 1;
        while (charCount < OIx00oxx2) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public static String xxOXOOoIX(long[] jArr, char c) {
        if (jArr == null) {
            return null;
        }
        return xXoOI00O(jArr, c, 0, jArr.length);
    }

    public static boolean xxX(CharSequence charSequence) {
        if (XIXIX(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String xxXXXxIxo(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2)) {
            return str2.concat(str).concat(str2);
        }
        return str;
    }

    public static String xxx00(String str, String str2) {
        if (!XIXIX(str) && !XIXIX(str2)) {
            return xIOXX(str, str2, "", -1);
        }
        return str;
    }

    public static String xxxI(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    public static String xxxoo0XI(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return String.valueOf(cArr);
    }
}
