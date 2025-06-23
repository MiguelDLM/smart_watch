package kotlinx.coroutines.flow;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OOXIxO0;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.o0;

@XX({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n53#2:219\n55#2:223\n53#2:224\n55#2:228\n50#3:220\n55#3:222\n50#3:225\n55#3:227\n107#4:221\n107#4:226\n107#4:229\n1#5:230\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n47#1:219\n47#1:223\n74#1:224\n74#1:228\n47#1:220\n47#1:222\n74#1:225\n74#1:227\n47#1:221\n74#1:226\n82#1:229\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: oIX0oI */
    public static final int f30030oIX0oI = o0.II0xO0(Oxx0IOOO.f30127oIX0oI, 16, 1, Integer.MAX_VALUE);

    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,113:1\n83#2,2:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements X0o0xo<T> {

        /* renamed from: XO */
        public final /* synthetic */ X0o0xo f30040XO;

        public oIX0oI(X0o0xo x0o0xo) {
            this.f30040XO = x0o0xo;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object collect = this.f30040XO.collect(new FlowKt__MergeKt$flattenConcat$1$1(xo2), i0Io);
            if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return collect;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> I0Io(@OXOo.OOXIXo final X0o0xo<? extends T> x0o0xo, int i, @OXOo.OOXIXo final Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return Oxx0IOOO.oXIO0o0XI(new X0o0xo<X0o0xo<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2<T> implements XO {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ Oox.x0xO0oo f30037Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ XO f30038XO;

                @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
                @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.I0Io i0Io) {
                        super(i0Io);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @OXOo.oOoXoXO
                    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(XO xo2, Oox.x0xO0oo x0xo0oo) {
                    this.f30038XO = xo2;
                    this.f30037Oo = x0xo0oo;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, @OXOo.OOXIXo kotlin.coroutines.I0Io r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.I0oOoX.x0XOIxOo(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.XO r7 = (kotlinx.coroutines.flow.XO) r7
                        kotlin.I0oOoX.x0XOIxOo(r8)
                        goto L51
                    L3c:
                        kotlin.I0oOoX.x0XOIxOo(r8)
                        kotlinx.coroutines.flow.XO r8 = r6.f30038XO
                        Oox.x0xO0oo r2 = r6.f30037Oo
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r2.invoke(r7, r0)
                        if (r7 != r1) goto L4e
                        return r1
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object collect = X0o0xo.this.collect(new AnonymousClass2(xo2, x0xo0oo), i0Io);
                if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return collect;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        }, i);
    }

    public static final int II0XooXoX() {
        return f30030oIX0oI;
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> II0xO0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return Oxx0IOOO.oXxx000(x0o0xo, new FlowKt__MergeKt$flatMapLatest$1(x0xo0oo, null));
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> OOXIXo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return Oxx0IOOO.oXxx000(x0o0xo, new FlowKt__MergeKt$mapLatest$1(x0xo0oo, null));
    }

    public static /* synthetic */ X0o0xo Oxx0IOOO(X0o0xo x0o0xo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = f30030oIX0oI;
        }
        return Oxx0IOOO.oXIO0o0XI(x0o0xo, i);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo) {
        return new oIX0oI(x0o0xo);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T> X0o0xo<T> XO(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo, int i) {
        if (i > 0) {
            if (i == 1) {
                return Oxx0IOOO.XIXIX(x0o0xo);
            }
            return new ChannelFlowMerge(x0o0xo, i, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i).toString());
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> oIX0oI(@OXOo.OOXIXo final X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo final Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return Oxx0IOOO.XIXIX(new X0o0xo<X0o0xo<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2<T> implements XO {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ Oox.x0xO0oo f30033Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ XO f30034XO;

                @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
                @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.I0Io i0Io) {
                        super(i0Io);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @OXOo.oOoXoXO
                    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(XO xo2, Oox.x0xO0oo x0xo0oo) {
                    this.f30034XO = xo2;
                    this.f30033Oo = x0xo0oo;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, @OXOo.OOXIXo kotlin.coroutines.I0Io r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.I0oOoX.x0XOIxOo(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.XO r7 = (kotlinx.coroutines.flow.XO) r7
                        kotlin.I0oOoX.x0XOIxOo(r8)
                        goto L51
                    L3c:
                        kotlin.I0oOoX.x0XOIxOo(r8)
                        kotlinx.coroutines.flow.XO r8 = r6.f30034XO
                        Oox.x0xO0oo r2 = r6.f30033Oo
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r2.invoke(r7, r0)
                        if (r7 != r1) goto L4e
                        return r1
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object collect = X0o0xo.this.collect(new AnonymousClass2(xo2, x0xo0oo), i0Io);
                if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return collect;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        });
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oOoXoXO(@OXOo.OOXIXo Iterable<? extends X0o0xo<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> ooOOo0oXI(@OXOo.OOXIXo X0o0xo<? extends T>... x0o0xoArr) {
        return Oxx0IOOO.oOoIIO0(ArraysKt___ArraysKt.xOIx00(x0o0xoArr));
    }

    public static /* synthetic */ X0o0xo oxoX(X0o0xo x0o0xo, int i, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = f30030oIX0oI;
        }
        return Oxx0IOOO.OX00O0xII(x0o0xo, i, x0xo0oo);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> x0XOIxOo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return new ChannelFlowTransformLatest(iXxxXO, x0o0xo, null, 0, null, 28, null);
    }

    @OOXIxO0
    public static /* synthetic */ void xoIox() {
    }

    @OOXIxO0
    public static /* synthetic */ void xxIXOIIO() {
    }
}
