package okhttp3.internal.connection;

import OXOo.OOXIXo;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* loaded from: classes6.dex */
public final class ConnectInterceptor implements Interceptor {

    @OOXIXo
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    private ConnectInterceptor() {
    }

    @Override // okhttp3.Interceptor
    @OOXIXo
    public Response intercept(@OOXIXo Interceptor.Chain chain) throws IOException {
        IIX0o.x0xO0oo(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, realInterceptorChain.getCall$okhttp().initExchange$okhttp(realInterceptorChain), null, 0, 0, 0, 61, null).proceed(realInterceptorChain.getRequest$okhttp());
    }
}
