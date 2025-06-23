package kotlinx.coroutines.flow;

import kotlin.collections.xI;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,136:1\n21#1:143\n23#1:147\n21#1:148\n23#1:152\n50#2:137\n55#2:139\n50#2:140\n55#2:142\n50#2:144\n55#2:146\n50#2:149\n55#2:151\n50#2:153\n55#2:155\n50#2:156\n55#2:158\n50#2:159\n55#2:161\n50#2:163\n55#2:165\n107#3:138\n107#3:141\n107#3:145\n107#3:150\n107#3:154\n107#3:157\n107#3:160\n107#3:162\n107#3:164\n107#3:166\n107#3:167\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n36#1:143\n36#1:147\n41#1:148\n41#1:152\n21#1:137\n21#1:139\n28#1:140\n28#1:142\n36#1:144\n36#1:146\n41#1:149\n41#1:151\n46#1:153\n46#1:155\n53#1:156\n53#1:158\n60#1:159\n60#1:161\n78#1:163\n78#1:165\n21#1:138\n28#1:141\n36#1:145\n41#1:150\n46#1:154\n53#1:157\n60#1:160\n68#1:162\n78#1:164\n105#1:166\n125#1:167\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__TransformKt {

    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n69#2,5:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<T> implements X0o0xo<xI<? extends T>> {

        /* renamed from: XO */
        public final /* synthetic */ X0o0xo f30090XO;

        public II0xO0(X0o0xo x0o0xo) {
            this.f30090XO = x0o0xo;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super xI<? extends T>> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object collect = this.f30090XO.collect(new FlowKt__TransformKt$withIndex$1$1(xo2, new Ref.IntRef()), i0Io);
            if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return collect;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n126#2,10:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements X0o0xo<T> {

        /* renamed from: Oo */
        public final /* synthetic */ Oox.IXxxXO f30091Oo;

        /* renamed from: XO */
        public final /* synthetic */ X0o0xo f30092XO;

        public oIX0oI(X0o0xo x0o0xo, Oox.IXxxXO iXxxXO) {
            this.f30092XO = x0o0xo;
            this.f30091Oo = iXxxXO;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
            Object collect = this.f30092XO.collect(new FlowKt__TransformKt$runningReduce$1$1(objectRef, this.f30091Oo, xo2), i0Io);
            if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return collect;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final <R> X0o0xo<R> I0Io(@OXOo.OOXIXo final X0o0xo<?> x0o0xo, @OXOo.OOXIXo final kotlin.reflect.oxoX<R> oxox) {
        return (X0o0xo<R>) new X0o0xo<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n41#2:224\n23#2:225\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2<T> implements XO {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ kotlin.reflect.oxoX f30067Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ XO f30068XO;

                @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(XO xo2, kotlin.reflect.oxoX oxox) {
                    this.f30068XO = xo2;
                    this.f30067Oo = oxox;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, @OXOo.OOXIXo kotlin.coroutines.I0Io r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.I0oOoX.x0XOIxOo(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.I0oOoX.x0XOIxOo(r6)
                        kotlinx.coroutines.flow.XO r6 = r4.f30068XO
                        kotlin.reflect.oxoX r2 = r4.f30067Oo
                        boolean r2 = r2.Oxx0xo(r5)
                        if (r2 == 0) goto L47
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO<? super Object> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object collect = X0o0xo.this.collect(new AnonymousClass2(xo2, oxox), i0Io);
                if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return collect;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo final X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo final Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new X0o0xo<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n79#2,2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2<T> implements XO {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ Oox.x0xO0oo f30085Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ XO f30086XO;

                @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 224}, m = "emit", n = {"value", "$this$onEach_u24lambda_u248"}, s = {"L$0", "L$1"})
                @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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
                    this.f30086XO = xo2;
                    this.f30085Oo = x0xo0oo;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(T r6, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3e
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.I0oOoX.x0XOIxOo(r7)
                        goto L6a
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        java.lang.Object r6 = r0.L$1
                        kotlinx.coroutines.flow.XO r6 = (kotlinx.coroutines.flow.XO) r6
                        java.lang.Object r2 = r0.L$0
                        kotlin.I0oOoX.x0XOIxOo(r7)
                        goto L5c
                    L3e:
                        kotlin.I0oOoX.x0XOIxOo(r7)
                        kotlinx.coroutines.flow.XO r7 = r5.f30086XO
                        Oox.x0xO0oo r2 = r5.f30085Oo
                        r0.L$0 = r6
                        r0.L$1 = r7
                        r0.label = r4
                        r4 = 6
                        kotlin.jvm.internal.xxX.X0o0xo(r4)
                        java.lang.Object r2 = r2.invoke(r6, r0)
                        r4 = 7
                        kotlin.jvm.internal.xxX.X0o0xo(r4)
                        if (r2 != r1) goto L5a
                        return r1
                    L5a:
                        r2 = r6
                        r6 = r7
                    L5c:
                        r7 = 0
                        r0.L$0 = r7
                        r0.L$1 = r7
                        r0.label = r3
                        java.lang.Object r6 = r6.emit(r2, r0)
                        if (r6 != r1) goto L6a
                        return r1
                    L6a:
                        kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
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
        };
    }

    public static final /* synthetic */ <R> X0o0xo<R> II0xO0(X0o0xo<?> x0o0xo) {
        IIX0o.xoXoI();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> OOXIXo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return Oxx0IOOO.OO0(x0o0xo, r, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo final X0o0xo<? extends T> x0o0xo) {
        return new X0o0xo<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n47#2,2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2<T> implements XO {

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ XO f30074XO;

                @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
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

                public AnonymousClass2(XO xo2) {
                    this.f30074XO = xo2;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(T r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.I0oOoX.x0XOIxOo(r6)
                        goto L41
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.I0oOoX.x0XOIxOo(r6)
                        kotlinx.coroutines.flow.XO r6 = r4.f30074XO
                        if (r5 == 0) goto L41
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L41
                        return r1
                    L41:
                        kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object collect = X0o0xo.this.collect(new AnonymousClass2(xo2), i0Io);
                if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return collect;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> XO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<xI<T>> oOoXoXO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return new II0xO0(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oxoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoIox(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super T, ? super T, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> iXxxXO) {
        return new oIX0oI(x0o0xo, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> xxIXOIIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(r, x0o0xo, iXxxXO);
    }
}
