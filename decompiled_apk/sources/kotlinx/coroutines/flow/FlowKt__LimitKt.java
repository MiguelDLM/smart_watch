package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@XX({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n107#3:143\n107#3:144\n107#3:145\n107#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n22#1:143\n33#1:144\n52#1:145\n83#1:146\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n34#2,10:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<T> implements X0o0xo<T> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.x0xO0oo f30016Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ X0o0xo f30017XO;

        public II0xO0(X0o0xo x0o0xo, Oox.x0xO0oo x0xo0oo) {
            this.f30017XO = x0o0xo;
            this.f30016Oo = x0xo0oo;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object collect = this.f30017XO.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref.BooleanRef(), xo2, this.f30016Oo), i0Io);
            if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return collect;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n23#2,5:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements X0o0xo<T> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f30025Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ X0o0xo f30026XO;

        public oIX0oI(X0o0xo x0o0xo, int i) {
            this.f30026XO = x0o0xo;
            this.f30025Oo = i;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object collect = this.f30026XO.collect(new FlowKt__LimitKt$drop$2$1(new Ref.IntRef(), this.f30025Oo, xo2), i0Io);
            if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return collect;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    public static final <T> Object I0Io(X0o0xo<? extends T> x0o0xo, Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(x0xo0oo);
        try {
            xxX.X0o0xo(0);
            x0o0xo.collect(flowKt__LimitKt$collectWhile$collector$1, i0Io);
            xxX.X0o0xo(1);
        } catch (AbortFlowException e) {
            kotlinx.coroutines.flow.internal.II0XooXoX.II0xO0(e, flowKt__LimitKt$collectWhile$collector$1);
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(x0o0xo, x0xo0oo);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object II0xO0(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> r4, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r4 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r4
            kotlin.I0oOoX.x0XOIxOo(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L4c
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.I0oOoX.x0XOIxOo(r6)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r6 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r6.<init>(r5)
            r0.L$0 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            java.lang.Object r4 = r4.collect(r6, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            if (r4 != r1) goto L4f
            return r1
        L4a:
            r5 = move-exception
            r4 = r6
        L4c:
            kotlinx.coroutines.flow.internal.II0XooXoX.II0xO0(r5, r4)
        L4f:
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.II0xO0(kotlinx.coroutines.flow.X0o0xo, Oox.x0xO0oo, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        if (i > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(x0o0xo, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " should be positive").toString());
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return new II0xO0(x0o0xo, x0xo0oo);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object XO(kotlinx.coroutines.flow.XO<? super T> r4, T r5, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.XO r4 = (kotlinx.coroutines.flow.XO) r4
            kotlin.I0oOoX.x0XOIxOo(r6)
            goto L43
        L35:
            kotlin.I0oOoX.x0XOIxOo(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.emit(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.XO(kotlinx.coroutines.flow.XO, java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oxoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        if (i >= 0) {
            return new oIX0oI(x0o0xo, i);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i).toString());
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> xxIXOIIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> iXxxXO) {
        return Oxx0IOOO.O0X(new FlowKt__LimitKt$transformWhile$1(x0o0xo, iXxxXO, null));
    }
}
