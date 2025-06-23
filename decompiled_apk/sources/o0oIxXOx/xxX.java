package o0oIxXOx;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
public final class xxX extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final xxX f31206I0Io = new xxX();

    public String Oxx0IOOO(String str, String str2) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, str2);
    }

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String name = StandardCharsets.UTF_8.name();
        try {
            return Oxx0IOOO(str, name);
        } catch (UnsupportedEncodingException e) {
            throw oOoXoXO.II0xO0(e, "%s: source=%s, encoding=%s", e, str, name);
        }
    }
}
