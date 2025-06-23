package kotlinx.coroutines.flow;

import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XoX;

/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oox.oOoXoXO<Object, Object> f29987oIX0oI = new Oox.oOoXoXO<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // Oox.oOoXoXO
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.oOoXoXO Object obj) {
            return obj;
        }
    };

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oox.x0xO0oo<Object, Object, Boolean> f29986II0xO0 = new Oox.x0xO0oo<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.x0xO0oo
        @OXOo.OOXIXo
        public final Boolean invoke(@OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Object obj2) {
            return Boolean.valueOf(IIX0o.Oxx0IOOO(obj, obj2));
        }
    };

    @OXOo.OOXIXo
    public static final <T, K> X0o0xo<T> I0Io(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
        return oxoX(x0o0xo, oooxoxo, f29986II0xO0);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0xO0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super T, Boolean> x0xo0oo) {
        Oox.oOoXoXO<Object, Object> oooxoxo = f29987oIX0oI;
        IIX0o.x0XOIxOo(x0xo0oo, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return oxoX(x0o0xo, oooxoxo, (Oox.x0xO0oo) XoX.Oo(x0xo0oo, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        if (!(x0o0xo instanceof IIXOooo)) {
            return oxoX(x0o0xo, f29987oIX0oI, f29986II0xO0);
        }
        return x0o0xo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> X0o0xo<T> oxoX(X0o0xo<? extends T> x0o0xo, Oox.oOoXoXO<? super T, ? extends Object> oooxoxo, Oox.x0xO0oo<Object, Object, Boolean> x0xo0oo) {
        if (x0o0xo instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) x0o0xo;
            if (distinctFlowImpl.f29959Oo == oooxoxo && distinctFlowImpl.f29958IXxxXO == x0xo0oo) {
                return x0o0xo;
            }
        }
        return new DistinctFlowImpl(x0o0xo, oooxoxo, x0xo0oo);
    }
}
