package kotlinx.coroutines.flow;

import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n107#2:223\n107#2:224\n107#2:225\n107#2:226\n75#3:227\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n50#1:223\n76#1:224\n146#1:225\n181#1:226\n218#1:227\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__EmittersKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object I0Io(kotlinx.coroutines.flow.XO<? super T> r4, Oox.IXxxXO<? super kotlinx.coroutines.flow.XO<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends java.lang.Object> r5, java.lang.Throwable r6, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            kotlin.I0oOoX.x0XOIxOo(r7)     // Catch: java.lang.Throwable -> L2e
            goto L46
        L2e:
            r4 = move-exception
            goto L49
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.I0oOoX.x0XOIxOo(r7)
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L2e
            r0.label = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            kotlin.oO.oIX0oI(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.I0Io(kotlinx.coroutines.flow.XO, Oox.IXxxXO, java.lang.Throwable, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    @o0
    public static final <T, R> X0o0xo<R> II0XooXoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(x0o0xo, iXxxXO);
    }

    public static final void II0xO0(@OXOo.OOXIXo XO<?> xo2) {
        if (!(xo2 instanceof OxI)) {
        } else {
            throw ((OxI) xo2).f30126XO;
        }
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return Oxx0IOOO.O0X(new FlowKt__EmittersKt$transform$1(x0o0xo, iXxxXO, null));
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(x0xo0oo, x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oxoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super T>, ? super Throwable, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(x0o0xo, iXxxXO);
    }
}
