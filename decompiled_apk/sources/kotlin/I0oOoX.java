package kotlin;

import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
/* loaded from: classes6.dex */
public final class I0oOoX {
    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T extends R> R I0Io(Object obj, R r) {
        if (Result.m293isFailureimpl(obj)) {
            return r;
        }
        return obj;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> Object II0XooXoX(Object obj, Oox.oOoXoXO<? super Throwable, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl != null) {
            action.invoke(m290exceptionOrNullimpl);
        }
        return obj;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T> R II0xO0(Object obj, Oox.oOoXoXO<? super T, ? extends R> onSuccess, Oox.oOoXoXO<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onSuccess, "onSuccess");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onFailure, "onFailure");
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl == null) {
            return onSuccess.invoke(obj);
        }
        return onFailure.invoke(m290exceptionOrNullimpl);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T extends R> Object OOXIXo(Object obj, Oox.oOoXoXO<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl != null) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                return Result.m287constructorimpl(transform.invoke(m290exceptionOrNullimpl));
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                return Result.m287constructorimpl(oIX0oI(th));
            }
        }
        return obj;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T> Object Oxx0IOOO(Object obj, Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        if (Result.m294isSuccessimpl(obj)) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                return Result.m287constructorimpl(transform.invoke(obj));
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                return Result.m287constructorimpl(oIX0oI(th));
            }
        }
        return Result.m287constructorimpl(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> T X0o0xo(Object obj) {
        x0XOIxOo(obj);
        return obj;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T> Object XO(Object obj, Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        if (Result.m294isSuccessimpl(obj)) {
            Result.oIX0oI oix0oi = Result.Companion;
            return Result.m287constructorimpl(transform.invoke(obj));
        }
        return Result.m287constructorimpl(obj);
    }

    @OXOo.OOXIXo
    @o0
    @oxxXoxO(version = "1.3")
    public static final Object oIX0oI(@OXOo.OOXIXo Throwable exception) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(exception, "exception");
        return new Result.Failure(exception);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R> Object oOoXoXO(Oox.oIX0oI<? extends R> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            return Result.m287constructorimpl(block.invoke());
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            return Result.m287constructorimpl(oIX0oI(th));
        }
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T, R> Object ooOOo0oXI(T t, Oox.oOoXoXO<? super T, ? extends R> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            return Result.m287constructorimpl(block.invoke(t));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            return Result.m287constructorimpl(oIX0oI(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T extends R> R oxoX(Object obj, Oox.oOoXoXO<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onFailure, "onFailure");
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl != null) {
            return onFailure.invoke(m290exceptionOrNullimpl);
        }
        return obj;
    }

    @o0
    @oxxXoxO(version = "1.3")
    public static final void x0XOIxOo(@OXOo.OOXIXo Object obj) {
        if (!(obj instanceof Result.Failure)) {
        } else {
            throw ((Result.Failure) obj).exception;
        }
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <R, T extends R> Object xoIox(Object obj, Oox.oOoXoXO<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl != null) {
            Result.oIX0oI oix0oi = Result.Companion;
            return Result.m287constructorimpl(transform.invoke(m290exceptionOrNullimpl));
        }
        return obj;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> Object xxIXOIIO(Object obj, Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        if (Result.m294isSuccessimpl(obj)) {
            action.invoke(obj);
        }
        return obj;
    }
}
