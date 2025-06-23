package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Xo0;

/* loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {

    @OXOo.OOXIXo
    @XO0OX.XO
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext context, @OXOo.OOXIXo Runnable block) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@OXOo.OOXIXo CoroutineContext context) {
        IIX0o.x0xO0oo(context, "context");
        if (Xo0.X0o0xo().IIXOooo().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
