package androidx.room;

import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.X0xxXX0;
import kotlinx.coroutines.xII;

@XO0OX.xxIXOIIO(name = "RoomDatabaseKt")
@XX({"SMAP\nRoomDatabaseExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabaseExt.kt\nandroidx/room/RoomDatabaseKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,239:1\n314#2,11:240\n*S KotlinDebug\n*F\n+ 1 RoomDatabaseExt.kt\nandroidx/room/RoomDatabaseKt\n*L\n92#1:240,11\n*E\n"})
/* loaded from: classes.dex */
public final class RoomDatabaseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext createTransactionContext(RoomDatabase roomDatabase, kotlin.coroutines.oxoX oxox) {
        TransactionElement transactionElement = new TransactionElement(oxox);
        return oxox.plus(transactionElement).plus(X0xxXX0.oIX0oI(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    @OXOo.OOXIXo
    public static final kotlinx.coroutines.flow.X0o0xo<Set<String>> invalidationTrackerFlow(@OXOo.OOXIXo RoomDatabase roomDatabase, @OXOo.OOXIXo String[] strArr, boolean z) {
        return kotlinx.coroutines.flow.Oxx0IOOO.Oxx0xo(new RoomDatabaseKt$invalidationTrackerFlow$1(z, roomDatabase, strArr, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.X0o0xo invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return invalidationTrackerFlow(roomDatabase, strArr, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine(final RoomDatabase roomDatabase, final CoroutineContext coroutineContext, final Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super R> i0Io) {
        final kotlinx.coroutines.x0xO0oo x0xo0oo2 = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo2.IO();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1

                @IXIxx0.oxoX(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
                    final /* synthetic */ kotlinx.coroutines.oO<R> $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super R>, Object> $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(RoomDatabase roomDatabase, kotlinx.coroutines.oO<? super R> oOVar, Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super AnonymousClass1> i0Io) {
                        super(2, i0Io);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = oOVar;
                        this.$transactionBlock = x0xo0oo;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @OXOo.OOXIXo
                    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, i0Io);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @OXOo.oOoXoXO
                    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                        CoroutineContext createTransactionContext;
                        kotlin.coroutines.I0Io i0Io;
                        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
                        int i = this.label;
                        if (i != 0) {
                            if (i == 1) {
                                i0Io = (kotlin.coroutines.I0Io) this.L$0;
                                I0oOoX.x0XOIxOo(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            I0oOoX.x0XOIxOo(obj);
                            CoroutineContext.oIX0oI oix0oi = ((xII) this.L$0).getCoroutineContext().get(kotlin.coroutines.oxoX.f29196Oxx0IOOO);
                            IIX0o.ooOOo0oXI(oix0oi);
                            createTransactionContext = RoomDatabaseKt.createTransactionContext(this.$this_startTransactionCoroutine, (kotlin.coroutines.oxoX) oix0oi);
                            kotlin.coroutines.I0Io i0Io2 = this.$continuation;
                            Result.oIX0oI oix0oi2 = Result.Companion;
                            Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super R>, Object> x0xo0oo = this.$transactionBlock;
                            this.L$0 = i0Io2;
                            this.label = 1;
                            obj = kotlinx.coroutines.II0XooXoX.II0XooXoX(createTransactionContext, x0xo0oo, this);
                            if (obj == oOoXoXO2) {
                                return oOoXoXO2;
                            }
                            i0Io = i0Io2;
                        }
                        i0Io.resumeWith(Result.m287constructorimpl(obj));
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    @Override // Oox.x0xO0oo
                    @OXOo.oOoXoXO
                    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
                        return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        kotlinx.coroutines.II0XooXoX.XO(CoroutineContext.this.minusKey(kotlin.coroutines.oxoX.f29196Oxx0IOOO), new AnonymousClass1(roomDatabase, x0xo0oo2, x0xo0oo, null));
                    } catch (Throwable th) {
                        x0xo0oo2.oIX0oI(th);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            x0xo0oo2.oIX0oI(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object o002 = x0xo0oo2.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return o002;
    }

    @OXOo.oOoXoXO
    public static final <R> Object withTransaction(@OXOo.OOXIXo RoomDatabase roomDatabase, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        kotlin.coroutines.oxoX oxox = null;
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(roomDatabase, oooxoxo, null);
        TransactionElement transactionElement = (TransactionElement) i0Io.getContext().get(TransactionElement.Key);
        if (transactionElement != null) {
            oxox = transactionElement.getTransactionDispatcher$room_ktx_release();
        }
        if (oxox != null) {
            return kotlinx.coroutines.II0XooXoX.II0XooXoX(oxox, roomDatabaseKt$withTransaction$transactionBlock$1, i0Io);
        }
        return startTransactionCoroutine(roomDatabase, i0Io.getContext(), roomDatabaseKt$withTransaction$transactionBlock$1, i0Io);
    }
}
