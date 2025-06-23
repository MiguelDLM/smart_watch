package androidx.room;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.xxIXOIIO;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.X0xxXX0;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.xII;

@XX({"SMAP\nRoomDatabaseExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabaseExt.kt\nandroidx/room/RoomDatabaseKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,239:1\n314#2,11:240\n*S KotlinDebug\n*F\n+ 1 RoomDatabaseExt.kt\nandroidx/room/RoomDatabaseKt\n*L\n92#1:240,11\n*E\n"})
@xxIXOIIO(name = "RoomDatabaseKt")
public final class RoomDatabaseKt {
    /* access modifiers changed from: private */
    public static final CoroutineContext createTransactionContext(RoomDatabase roomDatabase, oxoX oxox) {
        TransactionElement transactionElement = new TransactionElement(oxox);
        return oxox.plus(transactionElement).plus(X0xxXX0.oIX0oI(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    @OOXIXo
    public static final X0o0xo<Set<String>> invalidationTrackerFlow(@OOXIXo RoomDatabase roomDatabase, @OOXIXo String[] strArr, boolean z) {
        return Oxx0IOOO.Oxx0xo(new RoomDatabaseKt$invalidationTrackerFlow$1(z, roomDatabase, strArr, (I0Io<? super RoomDatabaseKt$invalidationTrackerFlow$1>) null));
    }

    public static /* synthetic */ X0o0xo invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return invalidationTrackerFlow(roomDatabase, strArr, z);
    }

    /* access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine(RoomDatabase roomDatabase, CoroutineContext coroutineContext, x0xO0oo<? super xII, ? super I0Io<? super R>, ? extends Object> x0xo0oo, I0Io<? super R> i0Io) {
        kotlinx.coroutines.x0xO0oo x0xo0oo2 = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo2.IO();
        try {
            roomDatabase.getTransactionExecutor().execute(new RoomDatabaseKt$startTransactionCoroutine$2$1(coroutineContext, x0xo0oo2, roomDatabase, x0xo0oo));
        } catch (RejectedExecutionException e) {
            x0xo0oo2.oIX0oI(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object o002 = x0xo0oo2.o00();
        if (o002 == II0xO0.oOoXoXO()) {
            XO.I0Io(i0Io);
        }
        return o002;
    }

    @oOoXoXO
    public static final <R> Object withTransaction(@OOXIXo RoomDatabase roomDatabase, @OOXIXo Oox.oOoXoXO<? super I0Io<? super R>, ? extends Object> oooxoxo, @OOXIXo I0Io<? super R> i0Io) {
        oxoX oxox = null;
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(roomDatabase, oooxoxo, (I0Io<? super RoomDatabaseKt$withTransaction$transactionBlock$1>) null);
        TransactionElement transactionElement = (TransactionElement) i0Io.getContext().get(TransactionElement.Key);
        if (transactionElement != null) {
            oxox = transactionElement.getTransactionDispatcher$room_ktx_release();
        }
        if (oxox != null) {
            return II0XooXoX.II0XooXoX(oxox, roomDatabaseKt$withTransaction$transactionBlock$1, i0Io);
        }
        return startTransactionCoroutine(roomDatabase, i0Io.getContext(), roomDatabaseKt$withTransaction$transactionBlock$1, i0Io);
    }
}
