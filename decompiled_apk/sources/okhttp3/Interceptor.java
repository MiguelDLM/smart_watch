package okhttp3;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Interceptor;

/* loaded from: classes6.dex */
public interface Interceptor {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes6.dex */
    public interface Chain {
        @OOXIXo
        Call call();

        int connectTimeoutMillis();

        @oOoXoXO
        Connection connection();

        @OOXIXo
        Response proceed(@OOXIXo Request request) throws IOException;

        int readTimeoutMillis();

        @OOXIXo
        Request request();

        @OOXIXo
        Chain withConnectTimeout(int i, @OOXIXo TimeUnit timeUnit);

        @OOXIXo
        Chain withReadTimeout(int i, @OOXIXo TimeUnit timeUnit);

        @OOXIXo
        Chain withWriteTimeout(int i, @OOXIXo TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @OOXIXo
        public final Interceptor invoke(@OOXIXo final Oox.oOoXoXO<? super Chain, Response> block) {
            IIX0o.x0xO0oo(block, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                @OOXIXo
                public final Response intercept(@OOXIXo Interceptor.Chain it) {
                    IIX0o.x0xO0oo(it, "it");
                    return block.invoke(it);
                }
            };
        }
    }

    @OOXIXo
    Response intercept(@OOXIXo Chain chain) throws IOException;
}
