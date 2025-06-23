package androidx.activity.contextaware;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,88:1\n314#2,11:89\n*S KotlinDebug\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n*L\n76#1:89,11\n*E\n"})
/* loaded from: classes.dex */
public final class ContextAwareKt {
    @oOoXoXO
    public static final <R> Object withContextAvailable(@OOXIXo ContextAware contextAware, @OOXIXo Oox.oOoXoXO<Context, R> oooxoxo, @OOXIXo I0Io<R> i0Io) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return oooxoxo.invoke(peekAvailableContext);
        }
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(x0xo0oo, oooxoxo);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        x0xo0oo.ooXIXxIX(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object o002 = x0xo0oo.o00();
        if (o002 == II0xO0.oOoXoXO()) {
            XO.I0Io(i0Io);
        }
        return o002;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, Oox.oOoXoXO<Context, R> oooxoxo, I0Io<R> i0Io) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return oooxoxo.invoke(peekAvailableContext);
        }
        xxX.X0o0xo(0);
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(x0xo0oo, oooxoxo);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        x0xo0oo.ooXIXxIX(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        Object o002 = x0xo0oo.o00();
        if (o002 == II0xO0.oOoXoXO()) {
            XO.I0Io(i0Io);
        }
        xxX.X0o0xo(1);
        return o002;
    }
}
