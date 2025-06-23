package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.util.concurrent.Callable;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.IIxOXoOo0;
import kotlinx.coroutines.oXIO0o0XI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class CoroutinesRoom {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @XX({"SMAP\nCoroutinesRoom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutinesRoom.kt\nandroidx/room/CoroutinesRoom$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 CoroutinesRoom.kt\nandroidx/room/CoroutinesRoom$Companion\n*L\n84#1:163,11\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final <R> kotlinx.coroutines.flow.X0o0xo<R> createFlow(@OXOo.OOXIXo RoomDatabase roomDatabase, boolean z, @OXOo.OOXIXo String[] strArr, @OXOo.OOXIXo Callable<R> callable) {
            return kotlinx.coroutines.flow.Oxx0IOOO.O0X(new CoroutinesRoom$Companion$createFlow$1(z, roomDatabase, strArr, callable, null));
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final <R> Object execute(@OXOo.OOXIXo RoomDatabase roomDatabase, boolean z, @OXOo.OOXIXo Callable<R> callable, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
            kotlin.coroutines.oxoX transactionDispatcher;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) i0Io.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return kotlinx.coroutines.II0XooXoX.II0XooXoX(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), i0Io);
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final <R> Object execute(@OXOo.OOXIXo RoomDatabase roomDatabase, boolean z, @OXOo.oOoXoXO final CancellationSignal cancellationSignal, @OXOo.OOXIXo Callable<R> callable, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
            kotlin.coroutines.oxoX transactionDispatcher;
            final oXIO0o0XI XO2;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) i0Io.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            kotlin.coroutines.oxoX oxox = transactionDispatcher;
            kotlinx.coroutines.x0xO0oo x0xo0oo = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            x0xo0oo.IO();
            XO2 = kotlinx.coroutines.xoIox.XO(IIxOXoOo0.f29690XO, oxox, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, x0xo0oo, null), 2, null);
            x0xo0oo.ooXIXxIX(new Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.oOoXoXO Throwable th) {
                    CancellationSignal cancellationSignal2 = cancellationSignal;
                    if (cancellationSignal2 != null) {
                        SupportSQLiteCompat.Api16Impl.cancel(cancellationSignal2);
                    }
                    oXIO0o0XI.oIX0oI.II0xO0(XO2, null, 1, null);
                }
            });
            Object o002 = x0xo0oo.o00();
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return o002;
        }
    }

    private CoroutinesRoom() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <R> kotlinx.coroutines.flow.X0o0xo<R> createFlow(@OXOo.OOXIXo RoomDatabase roomDatabase, boolean z, @OXOo.OOXIXo String[] strArr, @OXOo.OOXIXo Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final <R> Object execute(@OXOo.OOXIXo RoomDatabase roomDatabase, boolean z, @OXOo.oOoXoXO CancellationSignal cancellationSignal, @OXOo.OOXIXo Callable<R> callable, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        return Companion.execute(roomDatabase, z, cancellationSignal, callable, i0Io);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final <R> Object execute(@OXOo.OOXIXo RoomDatabase roomDatabase, boolean z, @OXOo.OOXIXo Callable<R> callable, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        return Companion.execute(roomDatabase, z, callable, i0Io);
    }
}
