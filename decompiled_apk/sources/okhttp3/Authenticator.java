package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

/* loaded from: classes6.dex */
public interface Authenticator {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    @OOXIXo
    @XO
    public static final Authenticator NONE = new Companion.AuthenticatorNone();

    @OOXIXo
    @XO
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, 0 == true ? 1 : 0);

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes6.dex */
        public static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            @oOoXoXO
            public Request authenticate(@oOoXoXO Route route, @OOXIXo Response response) {
                IIX0o.x0xO0oo(response, "response");
                return null;
            }
        }

        private Companion() {
        }
    }

    @oOoXoXO
    Request authenticate(@oOoXoXO Route route, @OOXIXo Response response) throws IOException;
}
