package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes6.dex */
public final class oX implements Executor {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final CoroutineDispatcher f30342XO;

    public oX(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher) {
        this.f30342XO = coroutineDispatcher;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@OXOo.OOXIXo Runnable runnable) {
        CoroutineDispatcher coroutineDispatcher = this.f30342XO;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            this.f30342XO.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        return this.f30342XO.toString();
    }
}
