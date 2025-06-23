package androidx.lifecycle;

import OXOo.OOXIXo;
import com.huawei.openalliance.ad.constant.bn;
import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.xII;

public final class CloseableCoroutineScope implements Closeable, xII {
    @OOXIXo
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(@OOXIXo CoroutineContext coroutineContext2) {
        IIX0o.x0xO0oo(coroutineContext2, bn.f.o);
        this.coroutineContext = coroutineContext2;
    }

    public void close() {
        Ox0O.xxIXOIIO(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @OOXIXo
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
