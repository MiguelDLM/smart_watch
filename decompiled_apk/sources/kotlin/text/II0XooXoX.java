package kotlin.text;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Arrays;
import kotlin.XI0oooXX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.text.xxIXOIIO;

@XX({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,591:1\n1#2:592\n1183#3,3:593\n1183#3,3:596\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n13#1:593,3\n14#1:596,3\n*E\n"})
/* loaded from: classes6.dex */
public final class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final int[] f29506I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29507II0xO0 = "0123456789ABCDEF";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29508oIX0oI = "0123456789abcdef";

    static {
        int[] iArr = new int[128];
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            iArr[i2] = -1;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < f29508oIX0oI.length()) {
            iArr[f29508oIX0oI.charAt(i3)] = i4;
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i < "0123456789ABCDEF".length()) {
            iArr["0123456789ABCDEF".charAt(i)] = i5;
            i++;
            i5++;
        }
        f29506I0Io = iArr;
    }

    public static final void I0Io(String str, int i, int i2, int i3, boolean z) {
        String str2;
        int i4 = i2 - i;
        if (z) {
            if (i4 == i3) {
                return;
            }
        } else if (i4 <= i3) {
            return;
        }
        if (z) {
            str2 = "exactly";
        } else {
            str2 = "at most";
        }
        IIX0o.x0XOIxOo(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        IIX0o.oO(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + TokenParser.SP + i3 + " hexadecimal digits at index " + i + ", but was " + substring + " of length " + i4);
    }

    @kotlin.IXxxXO
    @oxxXoxO(version = "1.9")
    public static final byte II0XooXoX(@OXOo.OOXIXo String str, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(format, "format");
        return Oxx0IOOO(str, 0, str.length(), format);
    }

    public static final int II0xO0(String str, String str2, int i, int i2, String str3) {
        int length = str2.length() + i;
        if (length <= i2 && OxI.OOIXx0x(str, i, str2, 0, str2.length(), true)) {
            return length;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(str3);
        sb.append(" \"");
        sb.append(str2);
        sb.append("\" at index ");
        sb.append(i);
        sb.append(", but was ");
        int XI0IXoo2 = X0.IIXOooo.XI0IXoo(length, i2);
        IIX0o.x0XOIxOo(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, XI0IXoo2);
        IIX0o.oO(substring, "substring(...)");
        sb.append(substring);
        throw new NumberFormatException(sb.toString());
    }

    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final String IIX0o(short s, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(format, "format");
        return IO(s, format, 16);
    }

    public static /* synthetic */ long IIXOooo(String str, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return oI0IIXIo(str, xxixoiio);
    }

    @kotlin.IXxxXO
    public static final String IO(long j, xxIXOIIO xxixoiio, int i) {
        String str;
        if ((i & 3) == 0) {
            if (xxixoiio.X0o0xo()) {
                str = "0123456789ABCDEF";
            } else {
                str = f29508oIX0oI;
            }
            String I0Io2 = xxixoiio.oxoX().I0Io();
            String X0o0xo2 = xxixoiio.oxoX().X0o0xo();
            int length = I0Io2.length() + (i >> 2) + X0o0xo2.length();
            boolean oxoX2 = xxixoiio.oxoX().oxoX();
            StringBuilder sb = new StringBuilder(length);
            sb.append(I0Io2);
            while (i > 0) {
                i -= 4;
                int i2 = (int) ((j >> i) & 15);
                if (oxoX2 && i2 == 0 && i > 0) {
                    oxoX2 = true;
                } else {
                    oxoX2 = false;
                }
                if (!oxoX2) {
                    sb.append(str.charAt(i2));
                }
            }
            sb.append(X0o0xo2);
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "toString(...)");
            return sb2;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static /* synthetic */ int IXxxXO(String str, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return x0xO0oo(str, xxixoiio);
    }

    public static /* synthetic */ String IoOoX(long j, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return xXxxox0I(j, xxixoiio);
    }

    @kotlin.IXxxXO
    @oxxXoxO(version = "1.9")
    public static final short O0xOxO(@OXOo.OOXIXo String str, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(format, "format");
        return OxI(str, 0, str.length(), format);
    }

    @kotlin.IXxxXO
    public static final byte[] OOXIXo(String str, int i, int i2, xxIXOIIO xxixoiio) {
        int i3 = i;
        kotlin.collections.II0xO0.Companion.oIX0oI(i3, i2, str.length());
        if (i3 == i2) {
            return new byte[0];
        }
        xxIXOIIO.II0xO0 I0Io2 = xxixoiio.I0Io();
        int Oxx0IOOO2 = I0Io2.Oxx0IOOO();
        int XO2 = I0Io2.XO();
        String I0Io3 = I0Io2.I0Io();
        String X0o0xo2 = I0Io2.X0o0xo();
        String oxoX2 = I0Io2.oxoX();
        String II0XooXoX2 = I0Io2.II0XooXoX();
        String str2 = oxoX2;
        int XIxXXX0x02 = XIxXXX0x0(i2 - i3, Oxx0IOOO2, XO2, II0XooXoX2.length(), oxoX2.length(), I0Io3.length(), X0o0xo2.length());
        byte[] bArr = new byte[XIxXXX0x02];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < i2) {
            if (i5 == Oxx0IOOO2) {
                i3 = oxoX(str, i3, i2);
                i5 = 0;
            } else if (i6 == XO2) {
                i3 = II0xO0(str, II0XooXoX2, i3, i2, "group separator");
            } else {
                if (i6 != 0) {
                    i3 = II0xO0(str, str2, i3, i2, "byte separator");
                }
                i5++;
                i6++;
                int II0xO02 = II0xO0(str, I0Io3, i3, i2, "byte prefix");
                I0Io(str, II0xO02, X0.IIXOooo.XI0IXoo(II0xO02 + 2, i2), 2, true);
                int X0o0xo3 = X0o0xo(str, II0xO02) << 4;
                bArr[i4] = (byte) (X0o0xo3 | X0o0xo(str, II0xO02 + 1));
                i3 = II0xO0(str, X0o0xo2, II0xO02 + 2, i2, "byte suffix");
                i4++;
                str2 = str2;
            }
            i6 = 0;
            i5++;
            i6++;
            int II0xO022 = II0xO0(str, I0Io3, i3, i2, "byte prefix");
            I0Io(str, II0xO022, X0.IIXOooo.XI0IXoo(II0xO022 + 2, i2), 2, true);
            int X0o0xo32 = X0o0xo(str, II0xO022) << 4;
            bArr[i4] = (byte) (X0o0xo32 | X0o0xo(str, II0xO022 + 1));
            i3 = II0xO0(str, X0o0xo2, II0xO022 + 2, i2, "byte suffix");
            i4++;
            str2 = str2;
        }
        if (i4 != XIxXXX0x02) {
            byte[] copyOf = Arrays.copyOf(bArr, i4);
            IIX0o.oO(copyOf, "copyOf(...)");
            return copyOf;
        }
        return bArr;
    }

    public static /* synthetic */ int Oo(String str, int i, int i2, xxIXOIIO xxixoiio, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return oO(str, i, i2, xxixoiio);
    }

    @kotlin.IXxxXO
    public static final short OxI(String str, int i, int i2, xxIXOIIO xxixoiio) {
        return (short) xoXoI(str, i, i2, xxixoiio, 4);
    }

    @kotlin.IXxxXO
    public static final byte Oxx0IOOO(String str, int i, int i2, xxIXOIIO xxixoiio) {
        return (byte) xoXoI(str, i, i2, xxixoiio, 2);
    }

    @kotlin.IXxxXO
    public static final long Oxx0xo(String str, int i, int i2, xxIXOIIO xxixoiio) {
        return xoXoI(str, i, i2, xxixoiio, 16);
    }

    public static /* synthetic */ long OxxIIOOXO(String str, int i, int i2, xxIXOIIO xxixoiio, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return Oxx0xo(str, i, i2, xxixoiio);
    }

    public static /* synthetic */ String X00IoxXI(byte[] bArr, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return xI(bArr, xxixoiio);
    }

    public static /* synthetic */ short X0IIOO(String str, int i, int i2, xxIXOIIO xxixoiio, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return OxI(str, i, i2, xxixoiio);
    }

    public static final int X0o0xo(String str, int i) {
        int i2;
        char charAt = str.charAt(i);
        if (charAt <= 127 && (i2 = f29506I0Io[charAt]) >= 0) {
            return i2;
        }
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i + ", but was " + str.charAt(i));
    }

    public static /* synthetic */ short XI0IXoo(String str, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return O0xOxO(str, xxixoiio);
    }

    public static final int XIxXXX0x0(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long oIX0oI2;
        int i8;
        int i9;
        if (i > 0) {
            long j = i6 + 2 + i7;
            long oIX0oI3 = oIX0oI(j, i3, i5);
            if (i2 <= i3) {
                oIX0oI2 = oIX0oI(j, i2, i5);
            } else {
                oIX0oI2 = oIX0oI(oIX0oI3, i2 / i3, i4);
                int i10 = i2 % i3;
                if (i10 != 0) {
                    oIX0oI2 = oIX0oI2 + i4 + oIX0oI(j, i10, i5);
                }
            }
            long j2 = i;
            long xII2 = xII(j2, oIX0oI2, 1);
            long j3 = j2 - ((oIX0oI2 + 1) * xII2);
            long xII3 = xII(j3, oIX0oI3, i4);
            long j4 = j3 - ((oIX0oI3 + i4) * xII3);
            long xII4 = xII(j4, j, i5);
            if (j4 - ((j + i5) * xII4) > 0) {
                i9 = i2;
                i8 = 1;
            } else {
                i8 = 0;
                i9 = i2;
            }
            return (int) ((xII2 * i9) + (xII3 * i3) + xII4 + i8);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final int XO(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i > 0) {
            int i8 = (i - 1) / i2;
            int i9 = (i2 - 1) / i3;
            int i10 = i % i2;
            if (i10 != 0) {
                i2 = i10;
            }
            long j = i8 + (((i9 * i8) + ((i2 - 1) / i3)) * i4) + (((r0 - i8) - r2) * i5) + (i * (i6 + 2 + i7));
            if (X0.IIXOooo.IIX0(new X0.oOoXoXO(0, Integer.MAX_VALUE), j)) {
                return (int) j;
            }
            throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) XI0oooXX.Xo0(XI0oooXX.oOoXoXO(j))));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static /* synthetic */ String Xx000oIo(byte[] bArr, int i, int i2, xxIXOIIO xxixoiio, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return ooXIXxIX(bArr, i, i2, xxixoiio);
    }

    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final String XxX0x0xxx(int i, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(format, "format");
        return IO(i, format, 32);
    }

    public static /* synthetic */ long o00(String str, int i, int i2, xxIXOIIO xxixoiio, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        return xoXoI(str, i, i2, xxixoiio, i3);
    }

    @kotlin.IXxxXO
    @oxxXoxO(version = "1.9")
    public static final long oI0IIXIo(@OXOo.OOXIXo String str, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(format, "format");
        return Oxx0xo(str, 0, str.length(), format);
    }

    public static final long oIX0oI(long j, int i, int i2) {
        if (i > 0) {
            long j2 = i;
            return (j * j2) + (i2 * (j2 - 1));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @kotlin.IXxxXO
    public static final int oO(String str, int i, int i2, xxIXOIIO xxixoiio) {
        return (int) xoXoI(str, i, i2, xxixoiio, 8);
    }

    public static /* synthetic */ String oOXoIIIo(short s, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return IIX0o(s, xxixoiio);
    }

    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final byte[] oOoXoXO(@OXOo.OOXIXo String str, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(format, "format");
        return OOXIXo(str, 0, str.length(), format);
    }

    public static /* synthetic */ String oo(int i, xxIXOIIO xxixoiio, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return XxX0x0xxx(i, xxixoiio);
    }

    public static /* synthetic */ String oo0xXOI0I(byte b, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return xxX(b, xxixoiio);
    }

    public static /* synthetic */ byte[] ooOOo0oXI(String str, int i, int i2, xxIXOIIO xxixoiio, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return OOXIXo(str, i, i2, xxixoiio);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[SYNTHETIC] */
    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.9")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String ooXIXxIX(@OXOo.OOXIXo byte[] r17, int r18, int r19, @OXOo.OOXIXo kotlin.text.xxIXOIIO r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r0, r3)
            java.lang.String r3 = "format"
            r4 = r20
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
            kotlin.collections.II0xO0$oIX0oI r3 = kotlin.collections.II0xO0.Companion
            int r5 = r0.length
            r3.oIX0oI(r1, r2, r5)
            if (r1 != r2) goto L1d
            java.lang.String r0 = ""
            return r0
        L1d:
            boolean r3 = r20.X0o0xo()
            if (r3 == 0) goto L26
            java.lang.String r3 = "0123456789ABCDEF"
            goto L28
        L26:
            java.lang.String r3 = "0123456789abcdef"
        L28:
            kotlin.text.xxIXOIIO$II0xO0 r4 = r20.I0Io()
            int r12 = r4.Oxx0IOOO()
            int r13 = r4.XO()
            java.lang.String r14 = r4.I0Io()
            java.lang.String r15 = r4.X0o0xo()
            java.lang.String r11 = r4.oxoX()
            java.lang.String r4 = r4.II0XooXoX()
            int r5 = r2 - r1
            int r8 = r4.length()
            int r9 = r11.length()
            int r10 = r14.length()
            int r16 = r15.length()
            r6 = r12
            r7 = r13
            r1 = r11
            r11 = r16
            int r5 = XO(r5, r6, r7, r8, r9, r10, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r8 = r18
            r9 = 0
            r10 = 0
        L68:
            if (r8 >= r2) goto La2
            r11 = r0[r8]
            r7 = r11 & 255(0xff, float:3.57E-43)
            if (r9 != r12) goto L78
            r9 = 10
            r6.append(r9)
            r9 = 0
        L76:
            r10 = 0
            goto L7e
        L78:
            if (r10 != r13) goto L7e
            r6.append(r4)
            goto L76
        L7e:
            if (r10 == 0) goto L83
            r6.append(r1)
        L83:
            r6.append(r14)
            int r7 = r7 >> 4
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r7 = r11 & 15
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r6.append(r15)
            int r10 = r10 + 1
            int r9 = r9 + 1
            int r8 = r8 + 1
            goto L68
        La2:
            int r0 = r6.length()
            if (r5 != r0) goto Lb2
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            return r0
        Lb2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.II0XooXoX.ooXIXxIX(byte[], int, int, kotlin.text.xxIXOIIO):java.lang.String");
    }

    public static final int oxoX(String str, int i, int i2) {
        if (str.charAt(i) == '\r') {
            int i3 = i + 1;
            if (i3 < i2 && str.charAt(i3) == '\n') {
                return i + 2;
            }
            return i3;
        }
        if (str.charAt(i) == '\n') {
            return i + 1;
        }
        throw new NumberFormatException("Expected a new line at index " + i + ", but was " + str.charAt(i));
    }

    public static /* synthetic */ byte[] x0XOIxOo(String str, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return oOoXoXO(str, xxixoiio);
    }

    @kotlin.IXxxXO
    @oxxXoxO(version = "1.9")
    public static final int x0xO0oo(@OXOo.OOXIXo String str, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(format, "format");
        return oO(str, 0, str.length(), format);
    }

    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final String xI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(bArr, "<this>");
        IIX0o.x0xO0oo(format, "format");
        return ooXIXxIX(bArr, 0, bArr.length, format);
    }

    public static final long xII(long j, long j2, int i) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        long j3 = i;
        return (j + j3) / (j2 + j3);
    }

    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final String xXxxox0I(long j, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(format, "format");
        return IO(j, format, 64);
    }

    public static /* synthetic */ byte xoIox(String str, xxIXOIIO xxixoiio, int i, Object obj) {
        if ((i & 1) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return II0XooXoX(str, xxixoiio);
    }

    @kotlin.IXxxXO
    public static final long xoXoI(String str, int i, int i2, xxIXOIIO xxixoiio, int i3) {
        kotlin.collections.II0xO0.Companion.oIX0oI(i, i2, str.length());
        String I0Io2 = xxixoiio.oxoX().I0Io();
        String X0o0xo2 = xxixoiio.oxoX().X0o0xo();
        if (I0Io2.length() + X0o0xo2.length() < i2 - i) {
            int II0xO02 = II0xO0(str, I0Io2, i, i2, RequestParameters.PREFIX);
            int length = i2 - X0o0xo2.length();
            II0xO0(str, X0o0xo2, length, i2, "suffix");
            I0Io(str, II0xO02, length, i3, false);
            long j = 0;
            while (II0xO02 < length) {
                j = (j << 4) | X0o0xo(str, II0xO02);
                II0xO02++;
            }
            return j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a hexadecimal number with prefix \"");
        sb.append(I0Io2);
        sb.append("\" and suffix \"");
        sb.append(X0o0xo2);
        sb.append("\", but was ");
        IIX0o.x0XOIxOo(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        IIX0o.oO(substring, "substring(...)");
        sb.append(substring);
        throw new NumberFormatException(sb.toString());
    }

    public static /* synthetic */ byte xxIXOIIO(String str, int i, int i2, xxIXOIIO xxixoiio, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            xxixoiio = xxIXOIIO.f29592oxoX.oIX0oI();
        }
        return Oxx0IOOO(str, i, i2, xxixoiio);
    }

    @kotlin.IXxxXO
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.9")
    public static final String xxX(byte b, @OXOo.OOXIXo xxIXOIIO format) {
        IIX0o.x0xO0oo(format, "format");
        return IO(b, format, 8);
    }
}
