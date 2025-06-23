package androidx.room;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.IIxOXoOo0;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.x0xO0oo;
import kotlinx.coroutines.xoIox;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);

    @XX({"SMAP\nCoroutinesRoom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutinesRoom.kt\nandroidx/room/CoroutinesRoom$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 CoroutinesRoom.kt\nandroidx/room/CoroutinesRoom$Companion\n*L\n84#1:163,11\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final <R> X0o0xo<R> createFlow(@OOXIXo RoomDatabase roomDatabase, boolean z, @OOXIXo String[] strArr, @OOXIXo Callable<R> callable) {
            return Oxx0IOOO.O0X(new CoroutinesRoom$Companion$createFlow$1(z, roomDatabase, strArr, callable, (I0Io<? super CoroutinesRoom$Companion$createFlow$1>) null));
        }

        @x0XOIxOo
        @oOoXoXO
        public final <R> Object execute(@OOXIXo RoomDatabase roomDatabase, boolean z, @OOXIXo Callable<R> callable, @OOXIXo I0Io<? super R> i0Io) {
            oxoX oxox;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) i0Io.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (oxox = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                oxox = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return II0XooXoX.II0XooXoX(oxox, new CoroutinesRoom$Companion$execute$2(callable, (I0Io<? super CoroutinesRoom$Companion$execute$2>) null), i0Io);
        }

        private Companion() {
        }

        @x0XOIxOo
        @oOoXoXO
        public final <R> Object execute(@OOXIXo RoomDatabase roomDatabase, boolean z, @oOoXoXO CancellationSignal cancellationSignal, @OOXIXo Callable<R> callable, @OOXIXo I0Io<? super R> i0Io) {
            oxoX transactionDispatcher;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) i0Io.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            oxoX oxox = transactionDispatcher;
            x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            x0xo0oo.IO();
            x0xo0oo.ooXIXxIX(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, xoIox.XO(IIxOXoOo0.f19453XO, oxox, (CoroutineStart) null, new CoroutinesRoom$Companion$execute$4$job$1(callable, x0xo0oo, (I0Io<? super CoroutinesRoom$Companion$execute$4$job$1>) null), 2, (Object) null)));
            Object o002 = x0xo0oo.o00();
            if (o002 == II0xO0.oOoXoXO()) {
                XO.I0Io(i0Io);
            }
            return o002;
        }
    }

    private CoroutinesRoom() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final <R> X0o0xo<R> createFlow(@OOXIXo RoomDatabase roomDatabase, boolean z, @OOXIXo String[] strArr, @OOXIXo Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final <R> Object execute(@OOXIXo RoomDatabase roomDatabase, boolean z, @oOoXoXO CancellationSignal cancellationSignal, @OOXIXo Callable<R> callable, @OOXIXo I0Io<? super R> i0Io) {
        return Companion.execute(roomDatabase, z, cancellationSignal, callable, i0Io);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final <R> Object execute(@OOXIXo RoomDatabase roomDatabase, boolean z, @OOXIXo Callable<R> callable, @OOXIXo I0Io<? super R> i0Io) {
        return Companion.execute(roomDatabase, z, callable, i0Io);
    }
}
