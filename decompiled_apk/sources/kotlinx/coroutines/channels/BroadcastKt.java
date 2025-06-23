package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.IIxOXoOo0;
import kotlinx.coroutines.IxIX0I;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.oOXoIIIo;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;

@XX({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,202:1\n48#2,4:203\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n51#1:203,4\n*E\n"})
/* loaded from: classes6.dex */
public final class BroadcastKt {

    @XX({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n1#1,110:1\n51#2:111\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.coroutines.oIX0oI implements oOXoIIIo {
        public oIX0oI(oOXoIIIo.II0xO0 iI0xO0) {
            super(iI0xO0);
        }

        @Override // kotlinx.coroutines.oOXoIIIo
        public void IXxxXO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Throwable th) {
        }
    }

    public static /* synthetic */ oxoX I0Io(xII xii, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Oox.oOoXoXO oooxoxo, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        int i3;
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i3 = 1;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            oooxoxo = null;
        }
        return oIX0oI(xii, coroutineContext2, i3, coroutineStart2, oooxoxo, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @IxIX0I
    @OXOo.OOXIXo
    public static final <E> oxoX<E> II0xO0(@OXOo.OOXIXo final ReceiveChannel<? extends E> receiveChannel, int i, @OXOo.OOXIXo CoroutineStart coroutineStart) {
        return I0Io(x0o.ooOOo0oXI(x0o.ooOOo0oXI(IIxOXoOo0.f29690XO, Xo0.Oxx0IOOO()), new oIX0oI(oOXoIIIo.f30339II0XooXoX)), null, i, coroutineStart, new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.channels.BroadcastKt$broadcast$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                invoke2(th);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO Throwable th) {
                oOoXoXO.II0xO0(receiveChannel, th);
            }
        }, new BroadcastKt$broadcast$2(receiveChannel, null), 1, null);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @IxIX0I
    @OXOo.OOXIXo
    public static final <E> oxoX<E> oIX0oI(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super IXxxXO<? super E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        XO xo2;
        CoroutineContext X0o0xo2 = CoroutineContextKt.X0o0xo(xii, coroutineContext);
        oxoX oIX0oI2 = X0o0xo.oIX0oI(i);
        if (coroutineStart.isLazy()) {
            xo2 = new oO(X0o0xo2, oIX0oI2, x0xo0oo);
        } else {
            xo2 = new XO(X0o0xo2, oIX0oI2, true);
        }
        if (oooxoxo != null) {
            ((JobSupport) xo2).Oo(oooxoxo);
        }
        ((kotlinx.coroutines.oIX0oI) xo2).OO0(coroutineStart, xo2, x0xo0oo);
        return (oxoX<E>) xo2;
    }

    public static /* synthetic */ oxoX oxoX(ReceiveChannel receiveChannel, int i, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return II0xO0(receiveChannel, i, coroutineStart);
    }
}
