package androidx.lifecycle;

import OXOo.OOXIXo;
import XO0OX.XO;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Xo0;

public final class PausingDispatcher extends CoroutineDispatcher {
    @XO
    @OOXIXo
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public void dispatch(@OOXIXo CoroutineContext coroutineContext, @OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(coroutineContext, bn.f.o);
        IIX0o.x0xO0oo(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(coroutineContext, runnable);
    }

    public boolean isDispatchNeeded(@OOXIXo CoroutineContext coroutineContext) {
        IIX0o.x0xO0oo(coroutineContext, bn.f.o);
        if (Xo0.X0o0xo().IIXOooo().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
