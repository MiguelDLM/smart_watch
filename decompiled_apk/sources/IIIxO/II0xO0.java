package IIIxO;

import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public final class II0xO0 {
    @xx0o0O.XO
    @XO
    @oxxXoxO(version = "1.8")
    public static final byte[] I0Io(oIX0oI oix0oi, byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(source, "source");
        return oix0oi.XI0IXoo(source, i, i2);
    }

    @xx0o0O.XO
    @XO
    @oxxXoxO(version = "1.8")
    public static final int II0xO0(oIX0oI oix0oi, byte[] source, byte[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(destination, "destination");
        return oix0oi.IIXOooo(source, destination, i, i2, i3);
    }

    @xx0o0O.XO
    @XO
    @oxxXoxO(version = "1.8")
    public static final byte[] oIX0oI(oIX0oI oix0oi, CharSequence source, int i, int i2) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(source, "source");
        if (source instanceof String) {
            oix0oi.Oxx0IOOO(source.length(), i, i2);
            String substring = ((String) source).substring(i, i2);
            IIX0o.oO(substring, "substring(...)");
            Charset charset = kotlin.text.oxoX.f29582Oxx0IOOO;
            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(charset);
            IIX0o.oO(bytes, "getBytes(...)");
            return bytes;
        }
        return oix0oi.X0o0xo(source, i, i2);
    }

    @xx0o0O.XO
    @XO
    @oxxXoxO(version = "1.8")
    public static final String oxoX(oIX0oI oix0oi, byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(source, "source");
        return new String(oix0oi.XI0IXoo(source, i, i2), kotlin.text.oxoX.f29582Oxx0IOOO);
    }
}
