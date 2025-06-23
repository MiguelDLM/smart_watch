package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;

@Deprecated
/* loaded from: classes6.dex */
public class xo0x {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32959OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32964oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32965oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32966ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32968x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32969x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32970xoIox;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32963oIX0oI = new oO0OX0.XO(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).X0o0xo(new oO0OX0.XO(oO0OX0.oxoX.xxIXOIIO())).X0o0xo(oO0OX0.X0o0xo.oO(32, 127));

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32958II0xO0 = new oO0OX0.oIX0oI(new oO0OX0.XO(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new oO0OX0.XO(oO0OX0.oxoX.xxIXOIIO()), oO0OX0.X0o0xo.oO(32, 127));

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32956I0Io = new oO0OX0.oIX0oI(new oO0OX0.XO(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new oO0OX0.XO(oO0OX0.oxoX.xxIXOIIO()), oO0OX0.X0o0xo.oO(32, 127));

    /* renamed from: oxoX, reason: collision with root package name */
    @Deprecated
    public static final oO0OX0.II0xO0 f32967oxoX = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.I0Io()), new oO0OX0.XO(oO0OX0.oxoX.oIX0oI()));

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32961X0o0xo = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.I0Io()), new oO0OX0.XO(oO0OX0.oxoX.oIX0oI()), new oO0OX0.XO(new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), oO0OX0.Oxx0IOOO.xxIXOIIO(127, 132), oO0OX0.Oxx0IOOO.xxIXOIIO(134, 159), new oO0OX0.OOXIXo());

    /* renamed from: XO, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32962XO = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.I0Io()), new oO0OX0.XO(oO0OX0.oxoX.oIX0oI()), new oO0OX0.XO(new String[]{"\u0000", ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), oO0OX0.Oxx0IOOO.xxIXOIIO(1, 8), oO0OX0.Oxx0IOOO.xxIXOIIO(14, 31), oO0OX0.Oxx0IOOO.xxIXOIIO(127, 132), oO0OX0.Oxx0IOOO.xxIXOIIO(134, 159), new oO0OX0.OOXIXo());

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32960Oxx0IOOO = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.I0Io()), new oO0OX0.XO(oO0OX0.oxoX.Oxx0IOOO()));

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32957II0XooXoX = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.I0Io()), new oO0OX0.XO(oO0OX0.oxoX.Oxx0IOOO()), new oO0OX0.XO(oO0OX0.oxoX.X0o0xo()));

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final oO0OX0.II0xO0 f32971xxIXOIIO = new oIX0oI();

    /* loaded from: classes6.dex */
    public static class II0xO0 extends oO0OX0.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final char f32972I0Io = '\"';

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final char f32973II0xO0 = ',';

        /* renamed from: oxoX, reason: collision with root package name */
        public static final String f32975oxoX = String.valueOf('\"');

        /* renamed from: X0o0xo, reason: collision with root package name */
        public static final char[] f32974X0o0xo = {',', '\"', '\r', '\n'};

        @Override // oO0OX0.II0xO0
        public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i == 0) {
                if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                    String charSequence2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                    if (xXOx.xoXoI(charSequence2, f32974X0o0xo)) {
                        StringBuilder sb = new StringBuilder();
                        String str = f32975oxoX;
                        sb.append(str);
                        sb.append(str);
                        writer.write(xXOx.OOIXx0x(charSequence2, sb.toString(), str));
                    } else {
                        writer.write(charSequence.toString());
                    }
                    return Character.codePointCount(charSequence, 0, charSequence.length());
                }
                writer.write(charSequence.toString());
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI extends oO0OX0.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final char f32976I0Io = '\"';

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final char f32977II0xO0 = ',';

        /* renamed from: oxoX, reason: collision with root package name */
        public static final String f32979oxoX = String.valueOf('\"');

        /* renamed from: X0o0xo, reason: collision with root package name */
        public static final char[] f32978X0o0xo = {',', '\"', '\r', '\n'};

        @Override // oO0OX0.II0xO0
        public int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i == 0) {
                if (xXOx.X0IIOO(charSequence.toString(), f32978X0o0xo)) {
                    writer.write(charSequence.toString());
                } else {
                    writer.write(34);
                    String charSequence2 = charSequence.toString();
                    String str = f32979oxoX;
                    writer.write(xXOx.OOIXx0x(charSequence2, str, str + str));
                    writer.write(34);
                }
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            throw new IllegalStateException("CsvEscaper should never reach the [1] index");
        }
    }

    static {
        oO0OX0.oIX0oI oix0oi = new oO0OX0.oIX0oI(new oO0OX0.II0XooXoX(), new oO0OX0.xoIox(), new oO0OX0.XO(oO0OX0.oxoX.xoIox()), new oO0OX0.XO(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
        f32970xoIox = oix0oi;
        f32959OOXIXo = oix0oi;
        f32965oOoXoXO = oix0oi;
        f32966ooOOo0oXI = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.oxoX()), new oO0OX0.XO(oO0OX0.oxoX.II0XooXoX()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        f32968x0XOIxOo = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.oxoX()), new oO0OX0.XO(oO0OX0.oxoX.II0XooXoX()), new oO0OX0.XO(oO0OX0.oxoX.XO()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        f32964oO = new oO0OX0.oIX0oI(new oO0OX0.XO(oO0OX0.oxoX.oxoX()), new oO0OX0.XO(oO0OX0.oxoX.II0xO0()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        f32969x0xO0oo = new II0xO0();
    }

    public static final String I0Io(String str) {
        return f32960Oxx0IOOO.I0Io(str);
    }

    public static String II0XooXoX(String str) {
        return f32961X0o0xo.I0Io(str);
    }

    public static final String II0xO0(String str) {
        return f32958II0xO0.I0Io(str);
    }

    public static final String OOXIXo(String str) {
        return f32959OOXIXo.I0Io(str);
    }

    @Deprecated
    public static final String Oxx0IOOO(String str) {
        return f32967oxoX.I0Io(str);
    }

    public static final String X0o0xo(String str) {
        return f32963oIX0oI.I0Io(str);
    }

    public static final String XO(String str) {
        return f32956I0Io.I0Io(str);
    }

    public static final String oIX0oI(String str) {
        return f32971xxIXOIIO.I0Io(str);
    }

    public static final String oO(String str) {
        return f32965oOoXoXO.I0Io(str);
    }

    public static final String oOoXoXO(String str) {
        return f32966ooOOo0oXI.I0Io(str);
    }

    public static final String ooOOo0oXI(String str) {
        return f32968x0XOIxOo.I0Io(str);
    }

    public static final String oxoX(String str) {
        return f32957II0XooXoX.I0Io(str);
    }

    public static final String x0XOIxOo(String str) {
        return f32970xoIox.I0Io(str);
    }

    public static final String x0xO0oo(String str) {
        return f32964oO.I0Io(str);
    }

    public static final String xoIox(String str) {
        return f32969x0xO0oo.I0Io(str);
    }

    public static String xxIXOIIO(String str) {
        return f32962XO.I0Io(str);
    }
}
