package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    @OOXIXo
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        return r;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OOXIXo CoroutineContext.II0xO0<E> key) {
        IIX0o.x0xO0oo(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OOXIXo
    public CoroutineContext minusKey(@OOXIXo CoroutineContext.II0xO0<?> key) {
        IIX0o.x0xO0oo(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OOXIXo
    public CoroutineContext plus(@OOXIXo CoroutineContext context) {
        IIX0o.x0xO0oo(context, "context");
        return context;
    }

    @OOXIXo
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
