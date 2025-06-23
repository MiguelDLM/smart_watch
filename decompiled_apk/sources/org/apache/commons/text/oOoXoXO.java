package org.apache.commons.text;

import IOooo0o.oxoX;
import OoOoXO0.xoXoI;
import XXO0.oIX0oI;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.text.translate.NumericEntityUnescaper;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes6.dex */
public class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33052I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33053II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33054II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33055OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33056Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33057Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33058X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33059XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33060oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33061oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33062oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33063ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33064oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33065x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33066x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33067xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final IOooo0o.II0xO0 f33068xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class I0Io extends IOooo0o.II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final char f33069II0xO0 = '\\';

        @Override // IOooo0o.II0xO0
        public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i == 0) {
                String charSequence2 = charSequence.toString();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int indexOf = charSequence2.indexOf(92, i2);
                    if (indexOf == -1) {
                        break;
                    }
                    if (indexOf > i3) {
                        writer.write(charSequence2.substring(i3, indexOf));
                    }
                    i3 = indexOf + 1;
                    i2 = indexOf + 2;
                }
                if (i3 < charSequence2.length()) {
                    writer.write(charSequence2.substring(i3));
                }
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            throw new IllegalStateException("XsiUnescaper should never reach the [1] index");
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final IOooo0o.II0xO0 f33070II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final StringBuilder f33071oIX0oI;

        public II0xO0 II0xO0(String str) {
            this.f33071oIX0oI.append(this.f33070II0xO0.I0Io(str));
            return this;
        }

        public II0xO0 oIX0oI(String str) {
            this.f33071oIX0oI.append(str);
            return this;
        }

        public String toString() {
            return this.f33071oIX0oI.toString();
        }

        public II0xO0(IOooo0o.II0xO0 iI0xO0) {
            this.f33071oIX0oI = new StringBuilder();
            this.f33070II0xO0 = iI0xO0;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("\"", "\\\"");
        hashMap.put("\\", "\\\\");
        IOooo0o.Oxx0IOOO oxx0IOOO = new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap));
        Map<CharSequence, CharSequence> map = IOooo0o.X0o0xo.f643xxIXOIIO;
        f33060oIX0oI = new IOooo0o.oIX0oI(oxx0IOOO, new IOooo0o.Oxx0IOOO(map), IOooo0o.XO.oO(32, 127));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("'", "\\'");
        hashMap2.put("\"", "\\\"");
        hashMap2.put("\\", "\\\\");
        hashMap2.put("/", "\\/");
        f33054II0xO0 = new IOooo0o.oIX0oI(new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap2)), new IOooo0o.Oxx0IOOO(map), IOooo0o.XO.oO(32, 127));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("\"", "\\\"");
        hashMap3.put("\\", "\\\\");
        hashMap3.put("/", "\\/");
        f33052I0Io = new IOooo0o.oIX0oI(new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap3)), new IOooo0o.Oxx0IOOO(map), IOooo0o.XO.oO(32, 126));
        HashMap hashMap4 = new HashMap();
        hashMap4.put("\u0000", "");
        hashMap4.put("\u0001", "");
        hashMap4.put("\u0002", "");
        hashMap4.put("\u0003", "");
        hashMap4.put("\u0004", "");
        hashMap4.put("\u0005", "");
        hashMap4.put("\u0006", "");
        hashMap4.put("\u0007", "");
        hashMap4.put("\b", "");
        hashMap4.put("\u000b", "");
        hashMap4.put("\f", "");
        hashMap4.put("\u000e", "");
        hashMap4.put("\u000f", "");
        hashMap4.put("\u0010", "");
        hashMap4.put("\u0011", "");
        hashMap4.put("\u0012", "");
        hashMap4.put("\u0013", "");
        hashMap4.put("\u0014", "");
        hashMap4.put("\u0015", "");
        hashMap4.put("\u0016", "");
        hashMap4.put("\u0017", "");
        hashMap4.put("\u0018", "");
        hashMap4.put("\u0019", "");
        hashMap4.put("\u001a", "");
        hashMap4.put("\u001b", "");
        hashMap4.put("\u001c", "");
        hashMap4.put("\u001d", "");
        hashMap4.put("\u001e", "");
        hashMap4.put("\u001f", "");
        hashMap4.put("\ufffe", "");
        hashMap4.put("\uffff", "");
        Map<CharSequence, CharSequence> map2 = IOooo0o.X0o0xo.f638X0o0xo;
        IOooo0o.Oxx0IOOO oxx0IOOO2 = new IOooo0o.Oxx0IOOO(map2);
        Map<CharSequence, CharSequence> map3 = IOooo0o.X0o0xo.f637Oxx0IOOO;
        f33064oxoX = new IOooo0o.oIX0oI(oxx0IOOO2, new IOooo0o.Oxx0IOOO(map3), new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap4)), IOooo0o.II0XooXoX.xxIXOIIO(127, 132), IOooo0o.II0XooXoX.xxIXOIIO(134, 159), new IOooo0o.ooOOo0oXI());
        HashMap hashMap5 = new HashMap();
        hashMap5.put("\u0000", "");
        hashMap5.put("\u000b", "&#11;");
        hashMap5.put("\f", "&#12;");
        hashMap5.put("\ufffe", "");
        hashMap5.put("\uffff", "");
        f33058X0o0xo = new IOooo0o.oIX0oI(new IOooo0o.Oxx0IOOO(map2), new IOooo0o.Oxx0IOOO(map3), new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap5)), IOooo0o.II0XooXoX.xxIXOIIO(1, 8), IOooo0o.II0XooXoX.xxIXOIIO(14, 31), IOooo0o.II0XooXoX.xxIXOIIO(127, 132), IOooo0o.II0XooXoX.xxIXOIIO(134, 159), new IOooo0o.ooOOo0oXI());
        IOooo0o.Oxx0IOOO oxx0IOOO3 = new IOooo0o.Oxx0IOOO(map2);
        Map<CharSequence, CharSequence> map4 = IOooo0o.X0o0xo.f640oIX0oI;
        f33059XO = new IOooo0o.oIX0oI(oxx0IOOO3, new IOooo0o.Oxx0IOOO(map4));
        f33057Oxx0IOOO = new IOooo0o.oIX0oI(new IOooo0o.Oxx0IOOO(map2), new IOooo0o.Oxx0IOOO(map4), new IOooo0o.Oxx0IOOO(IOooo0o.X0o0xo.f634I0Io));
        f33053II0XooXoX = new oxoX.oIX0oI();
        HashMap hashMap6 = new HashMap();
        hashMap6.put("|", "\\|");
        hashMap6.put("&", "\\&");
        hashMap6.put(x.aL, "\\;");
        hashMap6.put("<", "\\<");
        hashMap6.put(">", "\\>");
        hashMap6.put(oIX0oI.I0Io.f4096II0xO0, "\\(");
        hashMap6.put(oIX0oI.I0Io.f4095I0Io, "\\)");
        hashMap6.put("$", "\\$");
        hashMap6.put("`", "\\`");
        hashMap6.put("\\", "\\\\");
        hashMap6.put("\"", "\\\"");
        hashMap6.put("'", "\\'");
        hashMap6.put(" ", "\\ ");
        hashMap6.put("\t", "\\\t");
        hashMap6.put("\r\n", "");
        hashMap6.put("\n", "");
        hashMap6.put("*", "\\*");
        hashMap6.put(LocationInfo.NA, "\\?");
        hashMap6.put("[", "\\[");
        hashMap6.put(xoXoI.f2670oxoX, "\\#");
        hashMap6.put("~", "\\~");
        hashMap6.put("=", "\\=");
        hashMap6.put("%", "\\%");
        f33068xxIXOIIO = new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap6));
        HashMap hashMap7 = new HashMap();
        hashMap7.put("\\\\", "\\");
        hashMap7.put("\\\"", "\"");
        hashMap7.put("\\'", "'");
        hashMap7.put("\\", "");
        IOooo0o.oIX0oI oix0oi = new IOooo0o.oIX0oI(new IOooo0o.xxIXOIIO(), new IOooo0o.oOoXoXO(), new IOooo0o.Oxx0IOOO(IOooo0o.X0o0xo.f642xoIox), new IOooo0o.Oxx0IOOO(Collections.unmodifiableMap(hashMap7)));
        f33067xoIox = oix0oi;
        f33055OOXIXo = oix0oi;
        f33062oOoXoXO = oix0oi;
        Map<CharSequence, CharSequence> map5 = IOooo0o.X0o0xo.f639XO;
        IOooo0o.Oxx0IOOO oxx0IOOO4 = new IOooo0o.Oxx0IOOO(map5);
        Map<CharSequence, CharSequence> map6 = IOooo0o.X0o0xo.f636II0xO0;
        f33063ooOOo0oXI = new IOooo0o.oIX0oI(oxx0IOOO4, new IOooo0o.Oxx0IOOO(map6), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        f33065x0XOIxOo = new IOooo0o.oIX0oI(new IOooo0o.Oxx0IOOO(map5), new IOooo0o.Oxx0IOOO(map6), new IOooo0o.Oxx0IOOO(IOooo0o.X0o0xo.f641oxoX), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        f33061oO = new IOooo0o.oIX0oI(new IOooo0o.Oxx0IOOO(map5), new IOooo0o.Oxx0IOOO(IOooo0o.X0o0xo.f635II0XooXoX), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        f33066x0xO0oo = new oxoX.II0xO0();
        f33056Oo = new I0Io();
    }

    public static final String I0Io(String str) {
        return f33054II0xO0.I0Io(str);
    }

    public static final String II0XooXoX(String str) {
        return f33068xxIXOIIO.I0Io(str);
    }

    public static final String II0xO0(String str) {
        return f33053II0XooXoX.I0Io(str);
    }

    public static final String IXxxXO(String str) {
        return f33061oO.I0Io(str);
    }

    public static final String OOXIXo(String str) {
        return f33066x0xO0oo.I0Io(str);
    }

    public static final String Oo(String str) {
        return f33056Oo.I0Io(str);
    }

    public static final String Oxx0IOOO(String str) {
        return f33052I0Io.I0Io(str);
    }

    public static final String X0o0xo(String str) {
        return f33057Oxx0IOOO.I0Io(str);
    }

    public static final String XO(String str) {
        return f33060oIX0oI.I0Io(str);
    }

    public static II0xO0 oIX0oI(IOooo0o.II0xO0 iI0xO0) {
        return new II0xO0(iI0xO0);
    }

    public static final String oO(String str) {
        return f33067xoIox.I0Io(str);
    }

    public static final String oOoXoXO(String str) {
        return f33055OOXIXo.I0Io(str);
    }

    public static final String ooOOo0oXI(String str) {
        return f33063ooOOo0oXI.I0Io(str);
    }

    public static final String oxoX(String str) {
        return f33059XO.I0Io(str);
    }

    public static final String x0XOIxOo(String str) {
        return f33065x0XOIxOo.I0Io(str);
    }

    public static final String x0xO0oo(String str) {
        return f33062oOoXoXO.I0Io(str);
    }

    public static String xoIox(String str) {
        return f33058X0o0xo.I0Io(str);
    }

    public static String xxIXOIIO(String str) {
        return f33064oxoX.I0Io(str);
    }
}
