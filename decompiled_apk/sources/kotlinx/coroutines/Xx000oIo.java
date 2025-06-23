package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.oOXoIIIo;

@kotlin.jvm.internal.XX({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,110:1\n75#2:111\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n38#1:111\n*E\n"})
/* loaded from: classes6.dex */
public final class Xx000oIo {

    @kotlin.jvm.internal.XX({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.coroutines.oIX0oI implements oOXoIIIo {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.x0xO0oo<CoroutineContext, Throwable, kotlin.oXIO0o0XI> f29787XO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Oox.x0xO0oo<? super CoroutineContext, ? super Throwable, kotlin.oXIO0o0XI> x0xo0oo, oOXoIIIo.II0xO0 iI0xO0) {
            super(iI0xO0);
            this.f29787XO = x0xo0oo;
        }

        @Override // kotlinx.coroutines.oOXoIIIo
        public void IXxxXO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Throwable th) {
            this.f29787XO.invoke(coroutineContext, th);
        }
    }

    @OXOo.OOXIXo
    public static final Throwable I0Io(@OXOo.OOXIXo Throwable th, @OXOo.OOXIXo Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.oO.oIX0oI(runtimeException, th);
        return runtimeException;
    }

    @OX00O0xII
    public static final void II0xO0(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Throwable th) {
        try {
            oOXoIIIo ooxoiiio = (oOXoIIIo) coroutineContext.get(oOXoIIIo.f30339II0XooXoX);
            if (ooxoiiio != null) {
                ooxoiiio.IXxxXO(coroutineContext, th);
            } else {
                kotlinx.coroutines.internal.xoIox.oIX0oI(coroutineContext, th);
            }
        } catch (Throwable th2) {
            kotlinx.coroutines.internal.xoIox.oIX0oI(coroutineContext, I0Io(th, th2));
        }
    }

    @OXOo.OOXIXo
    public static final oOXoIIIo oIX0oI(@OXOo.OOXIXo Oox.x0xO0oo<? super CoroutineContext, ? super Throwable, kotlin.oXIO0o0XI> x0xo0oo) {
        return new oIX0oI(x0xo0oo, oOXoIIIo.f30339II0XooXoX);
    }
}
