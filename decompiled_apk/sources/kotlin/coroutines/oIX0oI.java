package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class oIX0oI implements CoroutineContext.oIX0oI {

    @OOXIXo
    private final CoroutineContext.II0xO0<?> key;

    public oIX0oI(@OOXIXo CoroutineContext.II0xO0<?> key) {
        IIX0o.x0xO0oo(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return (R) CoroutineContext.oIX0oI.C1106oIX0oI.oIX0oI(this, r, x0xo0oo);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return (E) CoroutineContext.oIX0oI.C1106oIX0oI.II0xO0(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI
    @OOXIXo
    public CoroutineContext.II0xO0<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OOXIXo
    public CoroutineContext minusKey(@OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return CoroutineContext.oIX0oI.C1106oIX0oI.I0Io(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OOXIXo
    public CoroutineContext plus(@OOXIXo CoroutineContext coroutineContext) {
        return CoroutineContext.oIX0oI.C1106oIX0oI.oxoX(this, coroutineContext);
    }
}
