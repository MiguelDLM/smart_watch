package kotlinx.serialization.internal;

import java.util.Locale;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nPlatform.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.common.kt\nkotlinx/serialization/internal/InternalHexConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: classes6.dex */
public final class o0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30721II0xO0 = "0123456789ABCDEF";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final o0 f30722oIX0oI = new o0();

    public static /* synthetic */ String oxoX(o0 o0Var, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return o0Var.I0Io(bArr, z);
    }

    @OXOo.OOXIXo
    public final String I0Io(@OXOo.OOXIXo byte[] data, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte b : data) {
            sb.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            sb.append("0123456789ABCDEF".charAt(b & 15));
        }
        if (z) {
            String sb2 = sb.toString();
            kotlin.jvm.internal.IIX0o.oO(sb2, "toString(...)");
            String lowerCase = sb2.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.IIX0o.oO(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        String sb3 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb3, "toString(...)");
        return sb3;
    }

    @OXOo.OOXIXo
    public final byte[] II0xO0(@OXOo.OOXIXo String s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(s, "s");
        int length = s.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                int oIX0oI2 = oIX0oI(s.charAt(i));
                int i2 = i + 1;
                int oIX0oI3 = oIX0oI(s.charAt(i2));
                if (oIX0oI2 != -1 && oIX0oI3 != -1) {
                    bArr[i / 2] = (byte) ((oIX0oI2 << 4) + oIX0oI3);
                } else {
                    throw new IllegalArgumentException(("Invalid hex chars: " + s.charAt(i) + s.charAt(i2)).toString());
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("HexBinary string must be even length");
    }

    @OXOo.OOXIXo
    public final String X0o0xo(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (24 - (i2 * 8)));
        }
        String XIo = StringsKt__StringsKt.XIo(I0Io(bArr, true), '0');
        if (XIo.length() <= 0) {
            XIo = null;
        }
        if (XIo == null) {
            return "0";
        }
        return XIo;
    }

    public final int oIX0oI(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        if ('a' > c || c >= 'g') {
            return -1;
        }
        return c - 'W';
    }
}
