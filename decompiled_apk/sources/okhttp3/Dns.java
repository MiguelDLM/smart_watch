package okhttp3;

import OXOo.OOXIXo;
import XO0OX.XO;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public interface Dns {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    @OOXIXo
    @XO
    public static final Dns SYSTEM = new Companion.DnsSystem();

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes6.dex */
        public static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            @OOXIXo
            public List<InetAddress> lookup(@OOXIXo String hostname) {
                IIX0o.x0xO0oo(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    IIX0o.oO(allByName, "getAllByName(hostname)");
                    return ArraysKt___ArraysKt.IoXOX(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }

    @OOXIXo
    List<InetAddress> lookup(@OOXIXo String str) throws UnknownHostException;
}
