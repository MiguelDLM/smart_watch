package XXIoX0;

import X0.IIXOooo;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.XoI0Ixx0;
import kotlinx.coroutines.internal.I0oOoX;
import kotlinx.coroutines.internal.o0;

/* loaded from: classes6.dex */
public final class oIX0oI extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final CoroutineDispatcher f4053IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f4054Oo = new oIX0oI();

    static {
        int X0o0xo2;
        x0XOIxOo x0xoixoo = x0XOIxOo.f4071XO;
        X0o0xo2 = I0oOoX.X0o0xo(XoI0Ixx0.f29784oIX0oI, IIXOooo.OxxIIOOXO(64, o0.oIX0oI()), 0, 0, 12, null);
        f4053IXxxXO = x0xoixoo.limitedParallelism(X0o0xo2);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        f4053IXxxXO.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OX00O0xII
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        f4053IXxxXO.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@OXOo.OOXIXo Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    @XI0oooXX
    public CoroutineDispatcher limitedParallelism(int i) {
        return x0XOIxOo.f4071XO.limitedParallelism(i);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @OXOo.OOXIXo
    public Executor IIXOooo() {
        return this;
    }
}
