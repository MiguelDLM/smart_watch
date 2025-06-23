package IOooo0o;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public final class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f645I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final char f646II0xO0 = '\"';

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final char[] f647X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final char f648oIX0oI = ',';

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f649oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 extends xoIox {
        @Override // IOooo0o.xoIox, IOooo0o.II0xO0
        public /* bridge */ /* synthetic */ int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
            return super.II0xO0(charSequence, i, writer);
        }

        @Override // IOooo0o.xoIox
        public void Oxx0IOOO(CharSequence charSequence, Writer writer) throws IOException {
            if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                String charSequence2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                if (xXOx.xoXoI(charSequence2, oxoX.f647X0o0xo)) {
                    writer.write(xXOx.OOIXx0x(charSequence2, oxoX.f649oxoX, oxoX.f645I0Io));
                    return;
                } else {
                    writer.write(charSequence2);
                    return;
                }
            }
            writer.write(charSequence.toString());
        }
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI extends xoIox {
        @Override // IOooo0o.xoIox, IOooo0o.II0xO0
        public /* bridge */ /* synthetic */ int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException {
            return super.II0xO0(charSequence, i, writer);
        }

        @Override // IOooo0o.xoIox
        public void Oxx0IOOO(CharSequence charSequence, Writer writer) throws IOException {
            String charSequence2 = charSequence.toString();
            if (xXOx.X0IIOO(charSequence2, oxoX.f647X0o0xo)) {
                writer.write(charSequence2);
                return;
            }
            writer.write(34);
            writer.write(xXOx.OOIXx0x(charSequence2, oxoX.f645I0Io, oxoX.f649oxoX));
            writer.write(34);
        }
    }

    static {
        String valueOf = String.valueOf('\"');
        f645I0Io = valueOf;
        f649oxoX = valueOf + valueOf;
        f647X0o0xo = new char[]{',', '\"', '\r', '\n'};
    }
}
