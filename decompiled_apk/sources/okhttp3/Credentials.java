package okhttp3;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.IIX0o;
import okio.ByteString;

/* loaded from: classes6.dex */
public final class Credentials {

    @OOXIXo
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final String basic(@OOXIXo String username, @OOXIXo String password) {
        IIX0o.x0xO0oo(username, "username");
        IIX0o.x0xO0oo(password, "password");
        return basic$default(username, password, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset ISO_8859_1, int i, Object obj) {
        if ((i & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            IIX0o.oO(ISO_8859_1, "ISO_8859_1");
        }
        return basic(str, str2, ISO_8859_1);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final String basic(@OOXIXo String username, @OOXIXo String password, @OOXIXo Charset charset) {
        IIX0o.x0xO0oo(username, "username");
        IIX0o.x0xO0oo(password, "password");
        IIX0o.x0xO0oo(charset, "charset");
        return "Basic " + ByteString.Companion.encodeString(username + ':' + password, charset).base64();
    }
}
