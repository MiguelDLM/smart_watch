package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Key f29681XO = new Key(null);

    @kotlin.IXxxXO
    /* loaded from: classes6.dex */
    public static final class Key extends kotlin.coroutines.II0xO0<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public /* synthetic */ Key(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public Key() {
            super(CoroutineDispatcher.Key, new Oox.oOoXoXO<CoroutineContext.oIX0oI, ExecutorCoroutineDispatcher>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher.Key.1
                @Override // Oox.oOoXoXO
                @OXOo.oOoXoXO
                public final ExecutorCoroutineDispatcher invoke(@OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                    if (oix0oi instanceof ExecutorCoroutineDispatcher) {
                        return (ExecutorCoroutineDispatcher) oix0oi;
                    }
                    return null;
                }
            });
        }
    }

    @OXOo.OOXIXo
    public abstract Executor IIXOooo();

    public abstract void close();
}
