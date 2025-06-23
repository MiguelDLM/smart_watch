package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.oxoX;
import kotlinx.coroutines.internal.ThreadContextKt;

@kotlin.jvm.internal.XX({"SMAP\nBuilders.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,273:1\n95#2,5:274\n*S KotlinDebug\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n*L\n166#1:274,5\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class xoIox {

    /* renamed from: I0Io */
    public static final int f30485I0Io = 2;

    /* renamed from: II0xO0 */
    public static final int f30486II0xO0 = 1;

    /* renamed from: oIX0oI */
    public static final int f30487oIX0oI = 0;

    @OXOo.oOoXoXO
    public static final <T> Object I0Io(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return II0XooXoX.II0XooXoX(coroutineDispatcher, x0xo0oo, i0Io);
    }

    public static /* synthetic */ I0oOoX II0xO0(xII xii, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return II0XooXoX.oIX0oI(xii, coroutineContext, coroutineStart, x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object Oxx0IOOO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        Object OooI2;
        CoroutineContext context = i0Io.getContext();
        CoroutineContext oxoX2 = CoroutineContextKt.oxoX(context, coroutineContext);
        IIX0.O0xOxO(oxoX2);
        if (oxoX2 == context) {
            kotlinx.coroutines.internal.Xx000oIo xx000oIo = new kotlinx.coroutines.internal.Xx000oIo(oxoX2, i0Io);
            OooI2 = o0xIoII.II0xO0.X0o0xo(xx000oIo, xx000oIo, x0xo0oo);
        } else {
            oxoX.II0xO0 iI0xO0 = kotlin.coroutines.oxoX.f29196Oxx0IOOO;
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(oxoX2.get(iI0xO0), context.get(iI0xO0))) {
                Oxx oxx = new Oxx(oxoX2, i0Io);
                CoroutineContext context2 = oxx.getContext();
                Object I0Io2 = ThreadContextKt.I0Io(context2, null);
                try {
                    Object X0o0xo2 = o0xIoII.II0xO0.X0o0xo(oxx, oxx, x0xo0oo);
                    ThreadContextKt.oIX0oI(context2, I0Io2);
                    OooI2 = X0o0xo2;
                } catch (Throwable th) {
                    ThreadContextKt.oIX0oI(context2, I0Io2);
                    throw th;
                }
            } else {
                xXOx xxox = new xXOx(oxoX2, i0Io);
                o0xIoII.oIX0oI.XO(x0xo0oo, xxox, xxox, null, 4, null);
                OooI2 = xxox.OooI();
            }
        }
        if (OooI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return OooI2;
    }

    @OXOo.OOXIXo
    public static final oXIO0o0XI X0o0xo(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> x0xo0oo) {
        oIX0oI xxoxoooix;
        CoroutineContext X0o0xo2 = CoroutineContextKt.X0o0xo(xii, coroutineContext);
        if (coroutineStart.isLazy()) {
            xxoxoooix = new oxIIX0o(X0o0xo2, x0xo0oo);
        } else {
            xxoxoooix = new xxOXOOoIX(X0o0xo2, true);
        }
        xxoxoooix.OO0(coroutineStart, xxoxoooix, x0xo0oo);
        return xxoxoooix;
    }

    public static /* synthetic */ oXIO0o0XI XO(xII xii, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return II0XooXoX.oxoX(xii, coroutineContext, coroutineStart, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> I0oOoX<T> oIX0oI(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo) {
        oxxXoxO oxxxoxo;
        CoroutineContext X0o0xo2 = CoroutineContextKt.X0o0xo(xii, coroutineContext);
        if (coroutineStart.isLazy()) {
            oxxxoxo = new IoIOOxIIo(X0o0xo2, x0xo0oo);
        } else {
            oxxxoxo = new oxxXoxO(X0o0xo2, true);
        }
        ((oIX0oI) oxxxoxo).OO0(coroutineStart, oxxxoxo, x0xo0oo);
        return (I0oOoX<T>) oxxxoxo;
    }

    public static final <T> Object oxoX(CoroutineDispatcher coroutineDispatcher, Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super T> i0Io) {
        kotlin.jvm.internal.xxX.X0o0xo(0);
        Object II0XooXoX2 = II0XooXoX.II0XooXoX(coroutineDispatcher, x0xo0oo, i0Io);
        kotlin.jvm.internal.xxX.X0o0xo(1);
        return II0XooXoX2;
    }
}
