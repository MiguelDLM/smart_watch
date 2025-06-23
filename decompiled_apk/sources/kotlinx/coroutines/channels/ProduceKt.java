package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.xII;

@XX({"SMAP\nProduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,151:1\n1#2:152\n314#3,11:153\n*S KotlinDebug\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n*L\n48#1:153,11\n*E\n"})
/* loaded from: classes6.dex */
public final class ProduceKt {
    @OXOo.OOXIXo
    @XI0oooXX
    public static final <E> ReceiveChannel<E> I0Io(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super IXxxXO<? super E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return X0o0xo(xii, coroutineContext, i, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, x0xo0oo);
    }

    public static /* synthetic */ ReceiveChannel II0XooXoX(xII xii, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Oox.oOoXoXO oooxoxo, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        int i3;
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i2 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 16) != 0) {
            oooxoxo = null;
        }
        return X0o0xo(xii, coroutineContext2, i3, bufferOverflow2, coroutineStart2, oooxoxo, x0xo0oo);
    }

    public static /* synthetic */ Object II0xO0(IXxxXO iXxxXO, Oox.oIX0oI oix0oi, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 1) != 0) {
            oix0oi = new Oox.oIX0oI<oXIO0o0XI>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return oIX0oI(iXxxXO, oix0oi, i0Io);
    }

    public static /* synthetic */ ReceiveChannel Oxx0IOOO(xII xii, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Oox.oOoXoXO oooxoxo, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        int i3;
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            oooxoxo = null;
        }
        return oxoX(xii, coroutineContext2, i3, coroutineStart2, oooxoxo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <E> ReceiveChannel<E> X0o0xo(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super IXxxXO<? super E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        x0xO0oo x0xo0oo2 = new x0xO0oo(CoroutineContextKt.X0o0xo(xii, coroutineContext), xxIXOIIO.oxoX(i, bufferOverflow, null, 4, null));
        if (oooxoxo != null) {
            x0xo0oo2.Oo(oooxoxo);
        }
        x0xo0oo2.OO0(coroutineStart, x0xo0oo2, x0xo0oo);
        return x0xo0oo2;
    }

    public static /* synthetic */ ReceiveChannel XO(xII xii, CoroutineContext coroutineContext, int i, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return I0Io(xii, coroutineContext, i, x0xo0oo);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object oIX0oI(@OXOo.OOXIXo kotlinx.coroutines.channels.IXxxXO<?> r4, @OXOo.OOXIXo Oox.oIX0oI<kotlin.oXIO0o0XI> r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            r5 = r4
            Oox.oIX0oI r5 = (Oox.oIX0oI) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.IXxxXO r4 = (kotlinx.coroutines.channels.IXxxXO) r4
            kotlin.I0oOoX.x0XOIxOo(r6)     // Catch: java.lang.Throwable -> L32
            goto L75
        L32:
            r4 = move-exception
            goto L7b
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.I0oOoX.x0XOIxOo(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.oXIO0o0XI$II0xO0 r2 = kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO
            kotlin.coroutines.CoroutineContext$oIX0oI r6 = r6.get(r2)
            if (r6 != r4) goto L7f
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.x0xO0oo r6 = new kotlinx.coroutines.x0xO0oo     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.I0Io r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.IO()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            r4.OOXIXo(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.o00()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L72
            IXIxx0.XO.I0Io(r0)     // Catch: java.lang.Throwable -> L32
        L72:
            if (r4 != r1) goto L75
            return r1
        L75:
            r5.invoke()
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r4
        L7b:
            r5.invoke()
            throw r4
        L7f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.oIX0oI(kotlinx.coroutines.channels.IXxxXO, Oox.oIX0oI, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    @OX00O0xII
    public static final <E> ReceiveChannel<E> oxoX(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo CoroutineStart coroutineStart, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super IXxxXO<? super E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return X0o0xo(xii, coroutineContext, i, BufferOverflow.SUSPEND, coroutineStart, oooxoxo, x0xo0oo);
    }
}
