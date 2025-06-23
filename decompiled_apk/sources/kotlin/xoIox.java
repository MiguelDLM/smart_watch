package kotlin;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: classes6.dex */
public final class xoIox<T, R> extends xxIXOIIO<T, R> implements kotlin.coroutines.I0Io<R> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public kotlin.coroutines.I0Io<Object> f29665IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f29666Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public Object f29667Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public Oox.IXxxXO<? super xxIXOIIO<?, ?>, Object, ? super kotlin.coroutines.I0Io<Object>, ? extends Object> f29668XO;

    @kotlin.jvm.internal.XX({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n+ 2 DeepRecursive.kt\nkotlin/DeepRecursiveScopeImpl\n*L\n1#1,161:1\n182#2,6:162\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements kotlin.coroutines.I0Io<Object> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Oox.IXxxXO f29669IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ xoIox f29670Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ kotlin.coroutines.I0Io f29671Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f29672XO;

        public oIX0oI(CoroutineContext coroutineContext, xoIox xoiox, Oox.IXxxXO iXxxXO, kotlin.coroutines.I0Io i0Io) {
            this.f29672XO = coroutineContext;
            this.f29670Oo = xoiox;
            this.f29669IXxxXO = iXxxXO;
            this.f29671Oxx0xo = i0Io;
        }

        @Override // kotlin.coroutines.I0Io
        @OXOo.OOXIXo
        public CoroutineContext getContext() {
            return this.f29672XO;
        }

        @Override // kotlin.coroutines.I0Io
        public void resumeWith(@OXOo.OOXIXo Object obj) {
            this.f29670Oo.f29668XO = this.f29669IXxxXO;
            this.f29670Oo.f29665IXxxXO = this.f29671Oxx0xo;
            this.f29670Oo.f29667Oxx0xo = obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public xoIox(@OXOo.OOXIXo Oox.IXxxXO<? super xxIXOIIO<T, R>, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> block, T t) {
        super(null);
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        this.f29668XO = block;
        this.f29666Oo = t;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f29665IXxxXO = this;
        obj = II0XooXoX.f29057oIX0oI;
        this.f29667Oxx0xo = obj;
    }

    @Override // kotlin.xxIXOIIO
    @OXOo.oOoXoXO
    public <U, S> Object I0Io(@OXOo.OOXIXo Oxx0IOOO<U, S> oxx0IOOO, U u, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super S> i0Io) {
        Oox.IXxxXO<xxIXOIIO<U, S>, U, kotlin.coroutines.I0Io<? super S>, Object> oIX0oI2 = oxx0IOOO.oIX0oI();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(oIX0oI2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        Oox.IXxxXO<? super xxIXOIIO<?, ?>, Object, ? super kotlin.coroutines.I0Io<Object>, ? extends Object> iXxxXO = this.f29668XO;
        if (oIX0oI2 != iXxxXO) {
            this.f29668XO = oIX0oI2;
            kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f29665IXxxXO = xxIXOIIO(iXxxXO, i0Io);
        } else {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f29665IXxxXO = i0Io;
        }
        this.f29666Oo = u;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (oOoXoXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return oOoXoXO2;
    }

    @Override // kotlin.xxIXOIIO
    @OXOo.oOoXoXO
    public Object II0xO0(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        kotlin.jvm.internal.IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f29665IXxxXO = i0Io;
        this.f29666Oo = t;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (oOoXoXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return oOoXoXO2;
    }

    @Override // kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OXOo.OOXIXo Object obj) {
        this.f29665IXxxXO = null;
        this.f29667Oxx0xo = obj;
    }

    public final R xoIox() {
        Object obj;
        Object obj2;
        Object invoke;
        while (true) {
            R r = (R) this.f29667Oxx0xo;
            kotlin.coroutines.I0Io<Object> i0Io = this.f29665IXxxXO;
            if (i0Io != null) {
                obj = II0XooXoX.f29057oIX0oI;
                if (!Result.m289equalsimpl0(obj, r)) {
                    obj2 = II0XooXoX.f29057oIX0oI;
                    this.f29667Oxx0xo = obj2;
                    i0Io.resumeWith(r);
                } else {
                    try {
                        Oox.IXxxXO<? super xxIXOIIO<?, ?>, Object, ? super kotlin.coroutines.I0Io<Object>, ? extends Object> iXxxXO = this.f29668XO;
                        Object obj3 = this.f29666Oo;
                        if (!(iXxxXO instanceof BaseContinuationImpl)) {
                            invoke = IntrinsicsKt__IntrinsicsJvmKt.OOXIXo(iXxxXO, this, obj3, i0Io);
                        } else {
                            invoke = ((Oox.IXxxXO) kotlin.jvm.internal.XoX.Oo(iXxxXO, 3)).invoke(this, obj3, i0Io);
                        }
                        if (invoke != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                            Result.oIX0oI oix0oi = Result.Companion;
                            i0Io.resumeWith(Result.m287constructorimpl(invoke));
                        }
                    } catch (Throwable th) {
                        Result.oIX0oI oix0oi2 = Result.Companion;
                        i0Io.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
                    }
                }
            } else {
                I0oOoX.x0XOIxOo(r);
                return r;
            }
        }
    }

    public final kotlin.coroutines.I0Io<Object> xxIXOIIO(Oox.IXxxXO<? super xxIXOIIO<?, ?>, Object, ? super kotlin.coroutines.I0Io<Object>, ? extends Object> iXxxXO, kotlin.coroutines.I0Io<Object> i0Io) {
        return new oIX0oI(EmptyCoroutineContext.INSTANCE, this, iXxxXO, i0Io);
    }
}
