package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.oXIO0o0XI;

@XX({"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,224:1\n107#2:225\n107#2:227\n1#3:226\n163#4:228\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n58#1:225\n132#1:227\n221#1:228\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {
    public static final boolean I0Io(Throwable th, CoroutineContext coroutineContext) {
        oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        if (oxio0o0xi != null && oxio0o0xi.isCancelled()) {
            return oxoX(th, oxio0o0xi.xI());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object II0xO0(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> r4, @OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super java.lang.Throwable> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.I0oOoX.x0XOIxOo(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.I0oOoX.x0XOIxOo(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L51
            r0.label = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            T r4 = r4.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = oxoX(r5, r4)
            if (r6 != 0) goto L76
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            boolean r6 = I0Io(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            kotlin.oO.oIX0oI(r4, r5)
            throw r4
        L72:
            kotlin.oO.oIX0oI(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.II0xO0(kotlinx.coroutines.flow.X0o0xo, kotlinx.coroutines.flow.XO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.Oxx0xo<? super XO<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> oxx0xo) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(x0o0xo, oxx0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j, @OXOo.OOXIXo Oox.x0xO0oo<? super Throwable, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        if (j > 0) {
            return Oxx0IOOO.XoIxOXIXo(x0o0xo, new FlowKt__ErrorsKt$retry$3(j, x0xo0oo, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
    }

    public static /* synthetic */ X0o0xo XO(X0o0xo x0o0xo, long j, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            x0xo0oo = new FlowKt__ErrorsKt$retry$1(null);
        }
        return Oxx0IOOO.oXIoO(x0o0xo, j, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super T>, ? super Throwable, ? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends Object> iXxxXO) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(x0o0xo, iXxxXO);
    }

    public static final boolean oxoX(Throwable th, Throwable th2) {
        if (th2 != null && IIX0o.Oxx0IOOO(th2, th)) {
            return true;
        }
        return false;
    }
}
