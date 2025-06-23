package androidx.room;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
public final class RoomDatabaseKt$withTransaction$transactionBlock$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super R>, Object> {
    final /* synthetic */ oOoXoXO<I0Io<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase roomDatabase, oOoXoXO<? super I0Io<? super R>, ? extends Object> oooxoxo, I0Io<? super RoomDatabaseKt$withTransaction$transactionBlock$1> i0Io) {
        super(2, i0Io);
        this.$this_withTransaction = roomDatabase;
        this.$block = oooxoxo;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, i0Io);
        roomDatabaseKt$withTransaction$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt$withTransaction$transactionBlock$1;
    }

    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        TransactionElement transactionElement;
        Throwable th;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            CoroutineContext.oIX0oI oix0oi = ((xII) this.L$0).getCoroutineContext().get(TransactionElement.Key);
            IIX0o.ooOOo0oXI(oix0oi);
            TransactionElement transactionElement2 = (TransactionElement) oix0oi;
            transactionElement2.acquire();
            try {
                this.$this_withTransaction.beginTransaction();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                transactionElement = transactionElement2;
                th = th3;
                transactionElement.release();
                throw th;
            }
            try {
                oOoXoXO<I0Io<? super R>, Object> oooxoxo = this.$block;
                this.L$0 = transactionElement2;
                this.label = 1;
                Object invoke = oooxoxo.invoke(this);
                if (invoke == oOoXoXO2) {
                    return oOoXoXO2;
                }
                transactionElement = transactionElement2;
                obj = invoke;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                transactionElement = transactionElement2;
                th = th5;
                this.$this_withTransaction.endTransaction();
                throw th;
            }
        } else if (i == 1) {
            transactionElement = (TransactionElement) this.L$0;
            try {
                I0oOoX.x0XOIxOo(obj);
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$this_withTransaction.setTransactionSuccessful();
        try {
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th7) {
            th = th7;
            transactionElement.release();
            throw th;
        }
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @OXOo.oOoXoXO I0Io<? super R> i0Io) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
