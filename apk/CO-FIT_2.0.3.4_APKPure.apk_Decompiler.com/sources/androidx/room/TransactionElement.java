package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransactionElement implements CoroutineContext.oIX0oI {
    @OOXIXo
    public static final Key Key = new Key((IIXOooo) null);
    @OOXIXo
    private final AtomicInteger referenceCount = new AtomicInteger(0);
    @OOXIXo
    private final oxoX transactionDispatcher;

    public static final class Key implements CoroutineContext.II0xO0<TransactionElement> {
        public /* synthetic */ Key(IIXOooo iIXOooo) {
            this();
        }

        private Key() {
        }
    }

    public TransactionElement(@OOXIXo oxoX oxox) {
        this.transactionDispatcher = oxox;
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    public <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return CoroutineContext.oIX0oI.C0392oIX0oI.oIX0oI(this, r, x0xo0oo);
    }

    @oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return CoroutineContext.oIX0oI.C0392oIX0oI.II0xO0(this, iI0xO0);
    }

    @OOXIXo
    public CoroutineContext.II0xO0<TransactionElement> getKey() {
        return Key;
    }

    @OOXIXo
    public final oxoX getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @OOXIXo
    public CoroutineContext minusKey(@OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return CoroutineContext.oIX0oI.C0392oIX0oI.I0Io(this, iI0xO0);
    }

    @OOXIXo
    public CoroutineContext plus(@OOXIXo CoroutineContext coroutineContext) {
        return CoroutineContext.oIX0oI.C0392oIX0oI.oxoX(this, coroutineContext);
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }
}
