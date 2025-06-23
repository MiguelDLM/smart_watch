package okhttp3;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private final String protocol;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final Protocol get(@OOXIXo String protocol) throws IOException {
            IIX0o.x0xO0oo(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!IIX0o.Oxx0IOOO(protocol, protocol2.protocol)) {
                protocol2 = Protocol.HTTP_1_1;
                if (!IIX0o.Oxx0IOOO(protocol, protocol2.protocol)) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!IIX0o.Oxx0IOOO(protocol, protocol2.protocol)) {
                        protocol2 = Protocol.HTTP_2;
                        if (!IIX0o.Oxx0IOOO(protocol, protocol2.protocol)) {
                            protocol2 = Protocol.SPDY_3;
                            if (!IIX0o.Oxx0IOOO(protocol, protocol2.protocol)) {
                                protocol2 = Protocol.QUIC;
                                if (!IIX0o.Oxx0IOOO(protocol, protocol2.protocol)) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }

        private Companion() {
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Protocol get(@OOXIXo String str) throws IOException {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    @OOXIXo
    public String toString() {
        return this.protocol;
    }
}
