package kotlin.coroutines;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public final class X0o0xo {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n*L\n1#1,161:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements I0Io<T> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO<Result<? extends T>, oXIO0o0XI> f29194Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f29195XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(CoroutineContext coroutineContext, oOoXoXO<? super Result<? extends T>, oXIO0o0XI> oooxoxo) {
            this.f29195XO = coroutineContext;
            this.f29194Oo = oooxoxo;
        }

        @Override // kotlin.coroutines.I0Io
        @OOXIXo
        public CoroutineContext getContext() {
            return this.f29195XO;
        }

        @Override // kotlin.coroutines.I0Io
        public void resumeWith(@OOXIXo Object obj) {
            this.f29194Oo.invoke(Result.m286boximpl(obj));
        }
    }

    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <R, T> I0Io<oXIO0o0XI> I0Io(@OOXIXo x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo, R r, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(x0xo0oo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        return new II0XooXoX(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(IntrinsicsKt__IntrinsicsJvmKt.I0Io(x0xo0oo, r, completion)), kotlin.coroutines.intrinsics.II0xO0.oOoXoXO());
    }

    @oxxXoxO(version = "1.3")
    public static final <T> void II0XooXoX(@OOXIXo oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        I0Io X0o0xo2 = IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(IntrinsicsKt__IntrinsicsJvmKt.II0xO0(oooxoxo, completion));
        Result.oIX0oI oix0oi = Result.Companion;
        X0o0xo2.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
    }

    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <T> I0Io<oXIO0o0XI> II0xO0(@OOXIXo oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        return new II0XooXoX(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(IntrinsicsKt__IntrinsicsJvmKt.II0xO0(oooxoxo, completion)), kotlin.coroutines.intrinsics.II0xO0.oOoXoXO());
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> void Oxx0IOOO(I0Io<? super T> i0Io, Throwable exception) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        IIX0o.x0xO0oo(exception, "exception");
        Result.oIX0oI oix0oi = Result.Companion;
        i0Io.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(exception)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void X0o0xo() {
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> void XO(I0Io<? super T> i0Io, T t) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        Result.oIX0oI oix0oi = Result.Companion;
        i0Io.resumeWith(Result.m287constructorimpl(t));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> I0Io<T> oIX0oI(CoroutineContext context, oOoXoXO<? super Result<? extends T>, oXIO0o0XI> resumeWith) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(resumeWith, "resumeWith");
        return new oIX0oI(context, resumeWith);
    }

    public static final CoroutineContext oxoX() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> Object xoIox(oOoXoXO<? super I0Io<? super T>, oXIO0o0XI> oooxoxo, I0Io<? super T> i0Io) {
        xxX.X0o0xo(0);
        II0XooXoX iI0XooXoX = new II0XooXoX(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io));
        oooxoxo.invoke(iI0XooXoX);
        Object II0xO02 = iI0XooXoX.II0xO0();
        if (II0xO02 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        xxX.X0o0xo(1);
        return II0xO02;
    }

    @oxxXoxO(version = "1.3")
    public static final <R, T> void xxIXOIIO(@OOXIXo x0xO0oo<? super R, ? super I0Io<? super T>, ? extends Object> x0xo0oo, R r, @OOXIXo I0Io<? super T> completion) {
        IIX0o.x0xO0oo(x0xo0oo, "<this>");
        IIX0o.x0xO0oo(completion, "completion");
        I0Io X0o0xo2 = IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(IntrinsicsKt__IntrinsicsJvmKt.I0Io(x0xo0oo, r, completion));
        Result.oIX0oI oix0oi = Result.Companion;
        X0o0xo2.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
    }
}
