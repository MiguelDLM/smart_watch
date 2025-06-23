package kotlin.coroutines.intrinsics;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

@XX({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n204#1,4:270\n225#1:274\n204#1,4:275\n225#1:279\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n130#1:270,4\n130#1:274\n165#1:275,4\n165#1:279\n*E\n"})
/* loaded from: classes6.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static <R, T> I0Io<oXIO0o0XI> I0Io(@OOXIXo final x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo, final R r, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(x0xo0oo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        final I0Io<?> oIX0oI2 = XO.oIX0oI(completion);
        if (x0xo0oo instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) x0xo0oo).create(r, oIX0oI2);
        }
        final CoroutineContext context = oIX0oI2.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(oIX0oI2, x0xo0oo, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ x0xO0oo $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(oIX0oI2);
                    this.$this_createCoroutineUnintercepted$inlined = x0xo0oo;
                    this.$receiver$inlined = r;
                    IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @oOoXoXO
                public Object invokeSuspend(@OOXIXo Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            I0oOoX.x0XOIxOo(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 1;
                    I0oOoX.x0XOIxOo(obj);
                    IIX0o.x0XOIxOo(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((x0xO0oo) XoX.Oo(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                }
            };
        }
        return new ContinuationImpl(oIX0oI2, context, x0xo0oo, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ x0xO0oo $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(oIX0oI2, context);
                this.$this_createCoroutineUnintercepted$inlined = x0xo0oo;
                this.$receiver$inlined = r;
                IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @oOoXoXO
            public Object invokeSuspend(@OOXIXo Object obj) {
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        this.label = 2;
                        I0oOoX.x0XOIxOo(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 1;
                I0oOoX.x0XOIxOo(obj);
                IIX0o.x0XOIxOo(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((x0xO0oo) XoX.Oo(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            }
        };
    }

    @xx0o0O.XO
    public static final <R, P, T> Object II0XooXoX(IXxxXO<? super R, ? super P, ? super I0Io<? super T>, ? extends Object> iXxxXO, R r, P p, I0Io<? super T> completion) {
        IIX0o.x0xO0oo(iXxxXO, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        if (!(iXxxXO instanceof BaseContinuationImpl)) {
            return OOXIXo(iXxxXO, r, p, completion);
        }
        return ((IXxxXO) XoX.Oo(iXxxXO, 3)).invoke(r, p, completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static <T> I0Io<oXIO0o0XI> II0xO0(@OOXIXo final Oox.oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        final I0Io<?> oIX0oI2 = XO.oIX0oI(completion);
        if (oooxoxo instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) oooxoxo).create(oIX0oI2);
        }
        final CoroutineContext context = oIX0oI2.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(oIX0oI2, oooxoxo) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                final /* synthetic */ Oox.oOoXoXO $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(oIX0oI2);
                    this.$this_createCoroutineUnintercepted$inlined = oooxoxo;
                    IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @oOoXoXO
                public Object invokeSuspend(@OOXIXo Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            I0oOoX.x0XOIxOo(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 1;
                    I0oOoX.x0XOIxOo(obj);
                    IIX0o.x0XOIxOo(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((Oox.oOoXoXO) XoX.Oo(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                }
            };
        }
        return new ContinuationImpl(oIX0oI2, context, oooxoxo) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            final /* synthetic */ Oox.oOoXoXO $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(oIX0oI2, context);
                this.$this_createCoroutineUnintercepted$inlined = oooxoxo;
                IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @oOoXoXO
            public Object invokeSuspend(@OOXIXo Object obj) {
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        this.label = 2;
                        I0oOoX.x0XOIxOo(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 1;
                I0oOoX.x0XOIxOo(obj);
                IIX0o.x0XOIxOo(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((Oox.oOoXoXO) XoX.Oo(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
            }
        };
    }

    @o0
    @oOoXoXO
    public static <R, P, T> Object OOXIXo(@OOXIXo IXxxXO<? super R, ? super P, ? super I0Io<? super T>, ? extends Object> iXxxXO, R r, P p, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(iXxxXO, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        return ((IXxxXO) XoX.Oo(iXxxXO, 3)).invoke(r, p, oxoX(XO.oIX0oI(completion)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T> Object Oxx0IOOO(x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo, R r, I0Io<? super T> completion) {
        IIX0o.x0xO0oo(x0xo0oo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        if (!(x0xo0oo instanceof BaseContinuationImpl)) {
            return xoIox(x0xo0oo, r, completion);
        }
        return ((x0xO0oo) XoX.Oo(x0xo0oo, 2)).invoke(r, completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static <T> I0Io<T> X0o0xo(@OOXIXo I0Io<? super T> i0Io) {
        ContinuationImpl continuationImpl;
        I0Io<T> i0Io2;
        IIX0o.x0xO0oo(i0Io, "<this>");
        if (i0Io instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) i0Io;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl != null && (i0Io2 = (I0Io<T>) continuationImpl.intercepted()) != null) {
            return i0Io2;
        }
        return i0Io;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> Object XO(Oox.oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, I0Io<? super T> completion) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        if (!(oooxoxo instanceof BaseContinuationImpl)) {
            return xxIXOIIO(oooxoxo, completion);
        }
        return ((Oox.oOoXoXO) XoX.Oo(oooxoxo, 1)).invoke(completion);
    }

    @oxxXoxO(version = "1.3")
    public static final <T> I0Io<oXIO0o0XI> oIX0oI(final I0Io<? super T> i0Io, final Oox.oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo) {
        final CoroutineContext context = i0Io.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(i0Io, oooxoxo) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                final /* synthetic */ Oox.oOoXoXO<I0Io<? super T>, Object> $block;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(i0Io);
                    this.$block = oooxoxo;
                    IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @oOoXoXO
                public Object invokeSuspend(@OOXIXo Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            I0oOoX.x0XOIxOo(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 1;
                    I0oOoX.x0XOIxOo(obj);
                    return this.$block.invoke(this);
                }
            };
        }
        return new ContinuationImpl(i0Io, context, oooxoxo) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            final /* synthetic */ Oox.oOoXoXO<I0Io<? super T>, Object> $block;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(i0Io, context);
                this.$block = oooxoxo;
                IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @oOoXoXO
            public Object invokeSuspend(@OOXIXo Object obj) {
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        this.label = 2;
                        I0oOoX.x0XOIxOo(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 1;
                I0oOoX.x0XOIxOo(obj);
                return this.$block.invoke(this);
            }
        };
    }

    public static final <T> I0Io<T> oxoX(final I0Io<? super T> i0Io) {
        final CoroutineContext context = i0Io.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(i0Io) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(i0Io);
                    IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @oOoXoXO
                public Object invokeSuspend(@OOXIXo Object obj) {
                    I0oOoX.x0XOIxOo(obj);
                    return obj;
                }
            };
        }
        return new ContinuationImpl(i0Io, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(i0Io, context);
                IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @oOoXoXO
            public Object invokeSuspend(@OOXIXo Object obj) {
                I0oOoX.x0XOIxOo(obj);
                return obj;
            }
        };
    }

    @o0
    @oOoXoXO
    public static final <R, T> Object xoIox(@OOXIXo x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo, R r, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(x0xo0oo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        return ((x0xO0oo) XoX.Oo(x0xo0oo, 2)).invoke(r, oxoX(XO.oIX0oI(completion)));
    }

    @o0
    @oOoXoXO
    public static final <T> Object xxIXOIIO(@OOXIXo Oox.oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        return ((Oox.oOoXoXO) XoX.Oo(oooxoxo, 1)).invoke(oxoX(XO.oIX0oI(completion)));
    }
}
