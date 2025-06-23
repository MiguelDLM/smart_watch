package androidx.room;

import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class RoomDatabaseKt$withTransaction$transactionBlock$1<R> extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super R>, Object> {
    final /* synthetic */ Oox.oOoXoXO<kotlin.coroutines.I0Io<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase roomDatabase, Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo, kotlin.coroutines.I0Io<? super RoomDatabaseKt$withTransaction$transactionBlock$1> i0Io) {
        super(2, i0Io);
        this.$this_withTransaction = roomDatabase;
        this.$block = oooxoxo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, i0Io);
        roomDatabaseKt$withTransaction$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt$withTransaction$transactionBlock$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Throwable th;
        TransactionElement transactionElement;
        TransactionElement oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    transactionElement = (TransactionElement) this.L$0;
                    try {
                        I0oOoX.x0XOIxOo(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                CoroutineContext.oIX0oI oix0oi = ((xII) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                IIX0o.ooOOo0oXI(oix0oi);
                TransactionElement transactionElement2 = (TransactionElement) oix0oi;
                transactionElement2.acquire();
                try {
                    this.$this_withTransaction.beginTransaction();
                    try {
                        Oox.oOoXoXO<kotlin.coroutines.I0Io<? super R>, Object> oooxoxo = this.$block;
                        this.L$0 = transactionElement2;
                        this.label = 1;
                        Object invoke = oooxoxo.invoke(this);
                        if (invoke == oOoXoXO2) {
                            return oOoXoXO2;
                        }
                        transactionElement = transactionElement2;
                        obj = invoke;
                    } catch (Throwable th3) {
                        th = th3;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } catch (Throwable th4) {
                    oOoXoXO2 = transactionElement2;
                    th = th4;
                    oOoXoXO2.release();
                    throw th;
                }
            }
            this.$this_withTransaction.setTransactionSuccessful();
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super R> i0Io) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
