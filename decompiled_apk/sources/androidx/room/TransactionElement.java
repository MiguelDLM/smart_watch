package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class TransactionElement implements CoroutineContext.oIX0oI {

    @OXOo.OOXIXo
    public static final Key Key = new Key(null);

    @OXOo.OOXIXo
    private final AtomicInteger referenceCount = new AtomicInteger(0);

    @OXOo.OOXIXo
    private final kotlin.coroutines.oxoX transactionDispatcher;

    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.II0xO0<TransactionElement> {
        public /* synthetic */ Key(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Key() {
        }
    }

    public TransactionElement(@OXOo.OOXIXo kotlin.coroutines.oxoX oxox) {
        this.transactionDispatcher = oxox;
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(this, r, x0xo0oo);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return (E) CoroutineContext.oIX0oI.C1106oIX0oI.II0xO0(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI
    @OXOo.OOXIXo
    public CoroutineContext.II0xO0<TransactionElement> getKey() {
        return Key;
    }

    @OXOo.OOXIXo
    public final kotlin.coroutines.oxoX getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext minusKey(@OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return CoroutineContext.oIX0oI.C1106oIX0oI.I0Io(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext plus(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(this, coroutineContext);
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() >= 0) {
        } else {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }
}
