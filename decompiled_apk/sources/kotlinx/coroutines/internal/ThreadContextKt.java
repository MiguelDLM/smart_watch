package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.X0xII0I;

/* loaded from: classes6.dex */
public final class ThreadContextKt {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final x0o f30273oIX0oI = new x0o("NO_THREAD_ELEMENTS");

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oox.x0xO0oo<Object, CoroutineContext.oIX0oI, Object> f30272II0xO0 = new Oox.x0xO0oo<Object, CoroutineContext.oIX0oI, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
            if (!(oix0oi instanceof X0xII0I)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? oix0oi : Integer.valueOf(intValue + 1);
        }
    };

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oox.x0xO0oo<X0xII0I<?>, CoroutineContext.oIX0oI, X0xII0I<?>> f30271I0Io = new Oox.x0xO0oo<X0xII0I<?>, CoroutineContext.oIX0oI, X0xII0I<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final X0xII0I<?> invoke(@OXOo.oOoXoXO X0xII0I<?> x0xII0I, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
            if (x0xII0I != null) {
                return x0xII0I;
            }
            if (oix0oi instanceof X0xII0I) {
                return (X0xII0I) oix0oi;
            }
            return null;
        }
    };

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oox.x0xO0oo<XX0, CoroutineContext.oIX0oI, XX0> f30274oxoX = new Oox.x0xO0oo<XX0, CoroutineContext.oIX0oI, XX0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // Oox.x0xO0oo
        @OXOo.OOXIXo
        public final XX0 invoke(@OXOo.OOXIXo XX0 xx02, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
            if (oix0oi instanceof X0xII0I) {
                X0xII0I<?> x0xII0I = (X0xII0I) oix0oi;
                xx02.oIX0oI(x0xII0I, x0xII0I.Io(xx02.f30286oIX0oI));
            }
            return xx02;
        }
    };

    @OXOo.oOoXoXO
    public static final Object I0Io(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO Object obj) {
        if (obj == null) {
            obj = II0xO0(coroutineContext);
        }
        if (obj == 0) {
            return f30273oIX0oI;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new XX0(coroutineContext, ((Number) obj).intValue()), f30274oxoX);
        }
        kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((X0xII0I) obj).Io(coroutineContext);
    }

    @OXOo.OOXIXo
    public static final Object II0xO0(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f30272II0xO0);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(fold);
        return fold;
    }

    public static final void oIX0oI(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO Object obj) {
        if (obj == f30273oIX0oI) {
            return;
        }
        if (obj instanceof XX0) {
            ((XX0) obj).II0xO0(coroutineContext);
            return;
        }
        Object fold = coroutineContext.fold(null, f30271I0Io);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((X0xII0I) fold).x0XOIxOo(coroutineContext, obj);
    }
}
