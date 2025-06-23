package okhttp3.internal.http2;

import OXOo.OOXIXo;
import XO0OX.XO;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import okio.BufferedSource;

/* loaded from: classes6.dex */
public interface PushObserver {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    @OOXIXo
    @XO
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes6.dex */
        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i, @OOXIXo BufferedSource source, int i2, boolean z) throws IOException {
                IIX0o.x0xO0oo(source, "source");
                source.skip(i2);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i, @OOXIXo List<Header> responseHeaders, boolean z) {
                IIX0o.x0xO0oo(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i, @OOXIXo List<Header> requestHeaders) {
                IIX0o.x0xO0oo(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i, @OOXIXo ErrorCode errorCode) {
                IIX0o.x0xO0oo(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i, @OOXIXo BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, @OOXIXo List<Header> list, boolean z);

    boolean onRequest(int i, @OOXIXo List<Header> list);

    void onReset(int i, @OOXIXo ErrorCode errorCode);
}
