package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "CharsetsKt")
/* loaded from: classes6.dex */
public final class X0o0xo {
    @xx0o0O.XO
    public static final Charset oIX0oI(String charsetName) {
        IIX0o.x0xO0oo(charsetName, "charsetName");
        Charset forName = Charset.forName(charsetName);
        IIX0o.oO(forName, "forName(...)");
        return forName;
    }
}
