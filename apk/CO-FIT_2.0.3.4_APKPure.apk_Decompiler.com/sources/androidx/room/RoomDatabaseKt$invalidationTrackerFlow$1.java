package androidx.room;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.I0oOoX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.xoIox;

@oxoX(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1", f = "RoomDatabaseExt.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
public final class RoomDatabaseKt$invalidationTrackerFlow$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super Set<? extends String>>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $tables;
    final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$invalidationTrackerFlow$1(boolean z, RoomDatabase roomDatabase, String[] strArr, I0Io<? super RoomDatabaseKt$invalidationTrackerFlow$1> i0Io) {
        super(2, i0Io);
        this.$emitInitialState = z;
        this.$this_invalidationTrackerFlow = roomDatabase;
        this.$tables = strArr;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        RoomDatabaseKt$invalidationTrackerFlow$1 roomDatabaseKt$invalidationTrackerFlow$1 = new RoomDatabaseKt$invalidationTrackerFlow$1(this.$emitInitialState, this.$this_invalidationTrackerFlow, this.$tables, i0Io);
        roomDatabaseKt$invalidationTrackerFlow$1.L$0 = obj;
        return roomDatabaseKt$invalidationTrackerFlow$1;
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        CoroutineContext coroutineContext;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            IXxxXO iXxxXO = (IXxxXO) this.L$0;
            AtomicBoolean atomicBoolean = new AtomicBoolean(this.$emitInitialState);
            RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 roomDatabaseKt$invalidationTrackerFlow$1$observer$1 = new RoomDatabaseKt$invalidationTrackerFlow$1$observer$1(this.$tables, atomicBoolean, iXxxXO);
            TransactionElement transactionElement = (TransactionElement) iXxxXO.getCoroutineContext().get(TransactionElement.Key);
            if (transactionElement == null || (coroutineContext = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                coroutineContext = CoroutinesRoomKt.getQueryDispatcher(this.$this_invalidationTrackerFlow);
            }
            final kotlinx.coroutines.oXIO0o0XI X0o0xo2 = xoIox.XO(iXxxXO, coroutineContext, (CoroutineStart) null, new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, roomDatabaseKt$invalidationTrackerFlow$1$observer$1, this.$emitInitialState, iXxxXO, this.$tables, atomicBoolean, (I0Io<? super RoomDatabaseKt$invalidationTrackerFlow$1$job$1>) null), 2, (Object) null);
            AnonymousClass1 r3 = new oIX0oI<oXIO0o0XI>() {
                public final void invoke() {
                    oXIO0o0XI.oIX0oI.II0xO0(X0o0xo2, (CancellationException) null, 1, (Object) null);
                }
            };
            this.label = 1;
            if (ProduceKt.oIX0oI(iXxxXO, r3, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return kotlin.oXIO0o0XI.f19155oIX0oI;
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo IXxxXO<? super Set<String>> iXxxXO, @oOoXoXO I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((RoomDatabaseKt$invalidationTrackerFlow$1) create(iXxxXO, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f19155oIX0oI);
    }
}
