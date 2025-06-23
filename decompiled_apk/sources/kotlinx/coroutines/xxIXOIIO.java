package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@kotlin.jvm.internal.XX({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BuildersKt__BuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class xxIXOIIO {
    public static /* synthetic */ Object II0xO0(CoroutineContext coroutineContext, Oox.x0xO0oo x0xo0oo, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return II0XooXoX.XO(coroutineContext, x0xo0oo);
    }

    public static final <T> T oIX0oI(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo) throws InterruptedException {
        x0xO x0xo;
        x0xO oIX0oI2;
        CoroutineContext X0o0xo2;
        Thread currentThread = Thread.currentThread();
        kotlin.coroutines.oxoX oxox = (kotlin.coroutines.oxoX) coroutineContext.get(kotlin.coroutines.oxoX.f29196Oxx0IOOO);
        if (oxox == null) {
            oIX0oI2 = IO0XoXxO.f29694oIX0oI.II0xO0();
            X0o0xo2 = CoroutineContextKt.X0o0xo(IIxOXoOo0.f29690XO, coroutineContext.plus(oIX0oI2));
        } else {
            x0xO x0xo2 = null;
            if (oxox instanceof x0xO) {
                x0xo = (x0xO) oxox;
            } else {
                x0xo = null;
            }
            if (x0xo != null) {
                if (x0xo.xII()) {
                    x0xo2 = x0xo;
                }
                if (x0xo2 != null) {
                    oIX0oI2 = x0xo2;
                    X0o0xo2 = CoroutineContextKt.X0o0xo(IIxOXoOo0.f29690XO, coroutineContext);
                }
            }
            oIX0oI2 = IO0XoXxO.f29694oIX0oI.oIX0oI();
            X0o0xo2 = CoroutineContextKt.X0o0xo(IIxOXoOo0.f29690XO, coroutineContext);
        }
        XO xo2 = new XO(X0o0xo2, currentThread, oIX0oI2);
        xo2.OO0(CoroutineStart.DEFAULT, xo2, x0xo0oo);
        return (T) xo2.OooI();
    }
}
