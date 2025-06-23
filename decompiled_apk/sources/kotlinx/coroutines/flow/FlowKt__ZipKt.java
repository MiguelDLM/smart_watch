package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.internal.CombineKt;

@XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,332:1\n272#1,3:334\n272#1,3:337\n261#1:340\n263#1:342\n272#1,3:343\n261#1:346\n263#1:348\n272#1,3:349\n261#1:352\n263#1:354\n272#1,3:355\n107#2:333\n107#2:341\n107#2:347\n107#2:353\n107#2:358\n107#2:359\n107#2:362\n37#3,2:360\n37#3,2:363\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n75#1:334,3\n103#1:337,3\n119#1:340\n119#1:342\n138#1:343,3\n156#1:346\n156#1:348\n177#1:349,3\n197#1:352\n197#1:354\n220#1:355,3\n32#1:333\n119#1:341\n156#1:347\n197#1:353\n237#1:358\n261#1:359\n288#1:362\n287#1:360,2\n306#1:363,2\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__ZipKt {

    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n33#2,2:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<R> implements X0o0xo<R> {

        /* renamed from: IXxxXO */
        public final /* synthetic */ Oox.IXxxXO f30113IXxxXO;

        /* renamed from: Oo */
        public final /* synthetic */ X0o0xo f30114Oo;

        /* renamed from: XO */
        public final /* synthetic */ X0o0xo f30115XO;

        public oIX0oI(X0o0xo x0o0xo, X0o0xo x0o0xo2, Oox.IXxxXO iXxxXO) {
            this.f30115XO = x0o0xo;
            this.f30114Oo = x0o0xo2;
            this.f30113IXxxXO = iXxxXO;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object oIX0oI2 = CombineKt.oIX0oI(xo2, new X0o0xo[]{this.f30115XO, this.f30114Oo}, FlowKt__ZipKt.oIX0oI(), new FlowKt__ZipKt$combine$1$1(this.f30113IXxxXO, null), i0Io);
            if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return oIX0oI2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> I0Io(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return Oxx0IOOO.IIX0(x0o0xo, x0o0xo2, iXxxXO);
    }

    public static final /* synthetic */ <T, R> X0o0xo<R> II0XooXoX(Iterable<? extends X0o0xo<? extends T>> iterable, @kotlin.II0xO0 Oox.IXxxXO<? super XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        X0o0xo[] x0o0xoArr = (X0o0xo[]) CollectionsKt___CollectionsKt.oOo0o(iterable).toArray(new X0o0xo[0]);
        IIX0o.xoXoI();
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$7(x0o0xoArr, iXxxXO, null));
    }

    public static final /* synthetic */ <T, R> X0o0xo<R> II0xO0(Iterable<? extends X0o0xo<? extends T>> iterable, Oox.x0xO0oo<? super T[], ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        X0o0xo[] x0o0xoArr = (X0o0xo[]) CollectionsKt___CollectionsKt.oOo0o(iterable).toArray(new X0o0xo[0]);
        IIX0o.xoXoI();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(x0o0xoArr, x0xo0oo);
    }

    public static final <T> Oox.oIX0oI<T[]> IXxxXO() {
        return new Oox.oIX0oI() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // Oox.oIX0oI
            @OXOo.oOoXoXO
            public final Void invoke() {
                return null;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, R> X0o0xo<R> OOXIXo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @kotlin.II0xO0 @OXOo.OOXIXo Oox.OxxIIOOXO<? super XO<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oxxIIOOXO) {
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new X0o0xo[]{x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4}, null, oxxIIOOXO));
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "flowCombineTransform")
    public static final <T1, T2, R> X0o0xo<R> Oo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @kotlin.II0xO0 @OXOo.OOXIXo Oox.Oxx0xo<? super XO<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oxx0xo) {
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new X0o0xo[]{x0o0xo, x0o0xo2}, null, oxx0xo));
    }

    public static final /* synthetic */ <T, R> X0o0xo<R> Oxx0IOOO(X0o0xo<? extends T>[] x0o0xoArr, Oox.x0xO0oo<? super T[], ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        IIX0o.xoXoI();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(x0o0xoArr, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> Oxx0xo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return CombineKt.II0xO0(x0o0xo, x0o0xo2, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, R> X0o0xo<R> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo final Oox.oI0IIXIo<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oi0iixio) {
        final X0o0xo[] x0o0xoArr = {x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4};
        return new X0o0xo<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, 262}, m = "invokeSuspend", n = {}, s = {})
            @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n157#2,5:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, Object[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
                final /* synthetic */ Oox.oI0IIXIo $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.I0Io i0Io, Oox.oI0IIXIo oi0iixio) {
                    super(3, i0Io);
                    this.$transform$inlined = oi0iixio;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @OXOo.oOoXoXO
                public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                    XO xo2;
                    Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                I0oOoX.x0XOIxOo(obj);
                                return oXIO0o0XI.f29392oIX0oI;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        xo2 = (XO) this.L$0;
                        I0oOoX.x0XOIxOo(obj);
                    } else {
                        I0oOoX.x0XOIxOo(obj);
                        xo2 = (XO) this.L$0;
                        Object[] objArr = (Object[]) this.L$1;
                        Oox.oI0IIXIo oi0iixio = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        this.L$0 = xo2;
                        this.label = 1;
                        xxX.X0o0xo(6);
                        obj = oi0iixio.invoke(obj2, obj3, obj4, obj5, this);
                        xxX.X0o0xo(7);
                        if (obj == oOoXoXO2) {
                            return oOoXoXO2;
                        }
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (xo2.emit(obj, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                    return oXIO0o0XI.f29392oIX0oI;
                }

                @Override // Oox.IXxxXO
                @OXOo.oOoXoXO
                public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo Object[] objArr, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(i0Io, this.$transform$inlined);
                    anonymousClass2.L$0 = xo2;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object oIX0oI2 = CombineKt.oIX0oI(xo2, x0o0xoArr, FlowKt__ZipKt.oIX0oI(), new AnonymousClass2(null, oi0iixio), i0Io);
                if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return oIX0oI2;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, T5, R> X0o0xo<R> XO(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo X0o0xo<? extends T5> x0o0xo5, @OXOo.OOXIXo final Oox.OxxIIOOXO<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxxIIOOXO) {
        final X0o0xo[] x0o0xoArr = {x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5};
        return new X0o0xo<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", i = {}, l = {333, 262}, m = "invokeSuspend", n = {}, s = {})
            @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n198#2,6:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, Object[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
                final /* synthetic */ Oox.OxxIIOOXO $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.I0Io i0Io, Oox.OxxIIOOXO oxxIIOOXO) {
                    super(3, i0Io);
                    this.$transform$inlined = oxxIIOOXO;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @OXOo.oOoXoXO
                public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                    XO xo2;
                    Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                I0oOoX.x0XOIxOo(obj);
                                return oXIO0o0XI.f29392oIX0oI;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        xo2 = (XO) this.L$0;
                        I0oOoX.x0XOIxOo(obj);
                    } else {
                        I0oOoX.x0XOIxOo(obj);
                        xo2 = (XO) this.L$0;
                        Object[] objArr = (Object[]) this.L$1;
                        Oox.OxxIIOOXO oxxIIOOXO = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        this.L$0 = xo2;
                        this.label = 1;
                        xxX.X0o0xo(6);
                        obj = oxxIIOOXO.invoke(obj2, obj3, obj4, obj5, obj6, this);
                        xxX.X0o0xo(7);
                        if (obj == oOoXoXO2) {
                            return oOoXoXO2;
                        }
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (xo2.emit(obj, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                    return oXIO0o0XI.f29392oIX0oI;
                }

                @Override // Oox.IXxxXO
                @OXOo.oOoXoXO
                public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo Object[] objArr, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(i0Io, this.$transform$inlined);
                    anonymousClass2.L$0 = xo2;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object oIX0oI2 = CombineKt.oIX0oI(xo2, x0o0xoArr, FlowKt__ZipKt.oIX0oI(), new AnonymousClass2(null, oxxIIOOXO), i0Io);
                if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return oIX0oI2;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    public static final /* synthetic */ Oox.oIX0oI oIX0oI() {
        return IXxxXO();
    }

    public static final /* synthetic */ <T, R> X0o0xo<R> oO(X0o0xo<? extends T>[] x0o0xoArr, Oox.x0xO0oo<? super T[], ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        IIX0o.xoXoI();
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(x0o0xoArr, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, T5, R> X0o0xo<R> oOoXoXO(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo X0o0xo<? extends T5> x0o0xo5, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IIXOooo<? super XO<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iIXOooo) {
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new X0o0xo[]{x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5}, null, iIXOooo));
    }

    public static final /* synthetic */ <T, R> X0o0xo<R> ooOOo0oXI(X0o0xo<? extends T>[] x0o0xoArr, @kotlin.II0xO0 Oox.IXxxXO<? super XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        IIX0o.xoXoI();
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$6(x0o0xoArr, iXxxXO, null));
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, R> X0o0xo<R> oxoX(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @kotlin.II0xO0 @OXOo.OOXIXo final Oox.Oxx0xo<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxx0xo) {
        final X0o0xo[] x0o0xoArr = {x0o0xo, x0o0xo2, x0o0xo3};
        return new X0o0xo<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {}, l = {333, 262}, m = "invokeSuspend", n = {}, s = {})
            @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n120#2,4:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, Object[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
                final /* synthetic */ Oox.Oxx0xo $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.I0Io i0Io, Oox.Oxx0xo oxx0xo) {
                    super(3, i0Io);
                    this.$transform$inlined = oxx0xo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @OXOo.oOoXoXO
                public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                    XO xo2;
                    Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                I0oOoX.x0XOIxOo(obj);
                                return oXIO0o0XI.f29392oIX0oI;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        xo2 = (XO) this.L$0;
                        I0oOoX.x0XOIxOo(obj);
                    } else {
                        I0oOoX.x0XOIxOo(obj);
                        xo2 = (XO) this.L$0;
                        Object[] objArr = (Object[]) this.L$1;
                        Oox.Oxx0xo oxx0xo = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        this.L$0 = xo2;
                        this.label = 1;
                        xxX.X0o0xo(6);
                        obj = oxx0xo.invoke(obj2, obj3, obj4, this);
                        xxX.X0o0xo(7);
                        if (obj == oOoXoXO2) {
                            return oOoXoXO2;
                        }
                    }
                    this.L$0 = null;
                    this.label = 2;
                    if (xo2.emit(obj, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                    return oXIO0o0XI.f29392oIX0oI;
                }

                @Override // Oox.IXxxXO
                @OXOo.oOoXoXO
                public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo Object[] objArr, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(i0Io, this.$transform$inlined);
                    anonymousClass2.L$0 = xo2;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object oIX0oI2 = CombineKt.oIX0oI(xo2, x0o0xoArr, FlowKt__ZipKt.oIX0oI(), new AnonymousClass2(null, oxx0xo), i0Io);
                if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return oIX0oI2;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        };
    }

    public static final /* synthetic */ <T, R> X0o0xo<R> x0XOIxOo(X0o0xo<? extends T>[] x0o0xoArr, @kotlin.II0xO0 Oox.IXxxXO<? super XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        IIX0o.xoXoI();
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransformUnsafe$1(x0o0xoArr, iXxxXO, null));
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "flowCombine")
    public static final <T1, T2, R> X0o0xo<R> x0xO0oo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return new oIX0oI(x0o0xo, x0o0xo2, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, R> X0o0xo<R> xoIox(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @kotlin.II0xO0 @OXOo.OOXIXo Oox.oI0IIXIo<? super XO<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oi0iixio) {
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new X0o0xo[]{x0o0xo, x0o0xo2, x0o0xo3}, null, oi0iixio));
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> xxIXOIIO(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @kotlin.II0xO0 @OXOo.OOXIXo Oox.Oxx0xo<? super XO<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oxx0xo) {
        return Oxx0IOOO.O0X(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new X0o0xo[]{x0o0xo, x0o0xo2}, null, oxx0xo));
    }
}
