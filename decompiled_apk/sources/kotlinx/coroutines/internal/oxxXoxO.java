package kotlinx.coroutines.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.X0xII0I;

/* loaded from: classes6.dex */
public final class oxxXoxO<T> implements X0xII0I<T> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext.II0xO0<?> f30308IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ThreadLocal<T> f30309Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final T f30310XO;

    public oxxXoxO(T t, @OXOo.OOXIXo ThreadLocal<T> threadLocal) {
        this.f30310XO = t;
        this.f30309Oo = threadLocal;
        this.f30308IXxxXO = new XoX(threadLocal);
    }

    @Override // kotlinx.coroutines.X0xII0I
    public T Io(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        T t = this.f30309Oo.get();
        this.f30309Oo.set(this.f30310XO);
        return t;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return (R) X0xII0I.oIX0oI.oIX0oI(this, r, x0xo0oo);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(getKey(), iI0xO0)) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI
    @OXOo.OOXIXo
    public CoroutineContext.II0xO0<?> getKey() {
        return this.f30308IXxxXO;
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext minusKey(@OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(getKey(), iI0xO0)) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext plus(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return X0xII0I.oIX0oI.oxoX(this, coroutineContext);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "ThreadLocal(value=" + this.f30310XO + ", threadLocal = " + this.f30309Oo + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // kotlinx.coroutines.X0xII0I
    public void x0XOIxOo(@OXOo.OOXIXo CoroutineContext coroutineContext, T t) {
        this.f30309Oo.set(t);
    }
}
