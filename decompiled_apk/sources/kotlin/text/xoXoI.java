package kotlin.text;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n1#1,274:1\n265#1,7:275\n265#1,7:282\n265#1,7:289\n265#1,7:296\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n142#1:275,7\n149#1:282,7\n229#1:289,7\n240#1:296,7\n*E\n"})
/* loaded from: classes6.dex */
public class xoXoI extends IIXOooo {
    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger I0(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return new BigInteger(str, II0xO0.oIX0oI(i));
    }

    @xx0o0O.XO
    public static final int IIX0(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Integer.parseInt(str);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger IIxOXoOo0(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return new BigInteger(str);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final String IoIOOxIIo(byte b, int i) {
        String num = Integer.toString(b, II0xO0.oIX0oI(i));
        IIX0o.oO(num, "toString(...)");
        return num;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final long O0(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return Long.parseLong(str, II0xO0.oIX0oI(i));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal O00XxXI(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return new BigDecimal(str);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Float O0X(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        try {
            if (!oO.f29577II0xO0.matches(str)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @oxxXoxO(version = "1.2")
    @OXOo.oOoXoXO
    public static final BigDecimal OOXIxO0(@OXOo.OOXIXo String str, @OXOo.OOXIXo MathContext mathContext) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(mathContext, "mathContext");
        try {
            if (!oO.f29577II0xO0.matches(str)) {
                return null;
            }
            return new BigDecimal(str, mathContext);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean OX00O0xII(String str) {
        return Boolean.parseBoolean(str);
    }

    @xx0o0O.XO
    public static final long Ox0O(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Long.parseLong(str);
    }

    @oxxXoxO(version = "1.2")
    @OXOo.oOoXoXO
    public static final BigDecimal XI0oooXX(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        try {
            if (!oO.f29577II0xO0.matches(str)) {
                return null;
            }
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @xx0o0O.XO
    public static final double XIXIX(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Double.parseDouble(str);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final String XIXIxO(short s, int i) {
        String num = Integer.toString(s, II0xO0.oIX0oI(i));
        IIX0o.oO(num, "toString(...)");
        return num;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final String o0oIxOo(long j, int i) {
        String l = Long.toString(j, II0xO0.oIX0oI(i));
        IIX0o.oO(l, "toString(...)");
        return l;
    }

    public static final <T> T o0xxxXXxX(String str, Oox.oOoXoXO<? super String, ? extends T> oooxoxo) {
        try {
            if (!oO.f29577II0xO0.matches(str)) {
                return null;
            }
            return oooxoxo.invoke(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @xx0o0O.XO
    public static final float oOo(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Float.parseFloat(str);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Double oXIO0o0XI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        try {
            if (!oO.f29577II0xO0.matches(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @oxxXoxO(version = "1.2")
    @OXOo.oOoXoXO
    public static final BigInteger ooOx(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return xoO0xx0(str, 10);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal ox(String str, MathContext mathContext) {
        IIX0o.x0xO0oo(str, "<this>");
        IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final String oxIIX0o(int i, int i2) {
        String num = Integer.toString(i, II0xO0.oIX0oI(i2));
        IIX0o.oO(num, "toString(...)");
        return num;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final short xI0oxI00(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return Short.parseShort(str, II0xO0.oIX0oI(i));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final byte xOOOX(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return Byte.parseByte(str, II0xO0.oIX0oI(i));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final int xOoOIoI(String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        return Integer.parseInt(str, II0xO0.oIX0oI(i));
    }

    @xx0o0O.XO
    public static final byte xX0IIXIx0(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Byte.parseByte(str);
    }

    @oxxXoxO(version = "1.2")
    @OXOo.oOoXoXO
    public static final BigInteger xoO0xx0(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        II0xO0.oIX0oI(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        if (length != 1) {
            if (str.charAt(0) == '-') {
                i2 = 1;
            }
            while (i2 < length) {
                if (II0xO0.II0xO0(str.charAt(i2), i) < 0) {
                    return null;
                }
                i2++;
            }
        } else if (II0xO0.II0xO0(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, II0xO0.oIX0oI(i));
    }

    @xx0o0O.XO
    public static final short xx0X0(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Short.parseShort(str);
    }
}
