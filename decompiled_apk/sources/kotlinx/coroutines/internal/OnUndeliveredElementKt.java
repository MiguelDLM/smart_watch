package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nOnUndeliveredElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,44:1\n75#2:45\n*S KotlinDebug\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n*L\n22#1:45\n*E\n"})
/* loaded from: classes6.dex */
public final class OnUndeliveredElementKt {
    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.oOoXoXO
    public static final <E> UndeliveredElementException I0Io(@OXOo.OOXIXo Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo, E e, @OXOo.oOoXoXO UndeliveredElementException undeliveredElementException) {
        try {
            oooxoxo.invoke(e);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                kotlin.oO.oIX0oI(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e, th);
            }
        }
        return undeliveredElementException;
    }

    public static final <E> void II0xO0(@OXOo.OOXIXo Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo, E e, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        UndeliveredElementException I0Io2 = I0Io(oooxoxo, e, null);
        if (I0Io2 != null) {
            kotlinx.coroutines.Xx000oIo.II0xO0(coroutineContext, I0Io2);
        }
    }

    @OXOo.OOXIXo
    public static final <E> Oox.oOoXoXO<Throwable, oXIO0o0XI> oIX0oI(@OXOo.OOXIXo final Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo, final E e, @OXOo.OOXIXo final CoroutineContext coroutineContext) {
        return new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                invoke2(th);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo Throwable th) {
                OnUndeliveredElementKt.II0xO0(oooxoxo, e, coroutineContext);
            }
        };
    }

    public static /* synthetic */ UndeliveredElementException oxoX(Oox.oOoXoXO oooxoxo, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return I0Io(oooxoxo, obj, undeliveredElementException);
    }
}
