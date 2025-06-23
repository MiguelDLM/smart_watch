package o0oIxXOx;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
public final class XxX0x0xxx extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final XxX0x0xxx f31184I0Io = new XxX0x0xxx();

    public String Oxx0IOOO(String str, String str2) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, str2);
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
