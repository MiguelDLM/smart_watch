package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.oXIO0o0XI;

@IXIxx0.oxoX(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1", f = "RoomDatabaseExt.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class RoomDatabaseKt$invalidationTrackerFlow$1 extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.channels.IXxxXO<? super Set<? extends String>>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $tables;
    final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$invalidationTrackerFlow$1(boolean z, RoomDatabase roomDatabase, String[] strArr, kotlin.coroutines.I0Io<? super RoomDatabaseKt$invalidationTrackerFlow$1> i0Io) {
        super(2, i0Io);
        this.$emitInitialState = z;
        this.$this_invalidationTrackerFlow = roomDatabase;
        this.$tables = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        RoomDatabaseKt$invalidationTrackerFlow$1 roomDatabaseKt$invalidationTrackerFlow$1 = new RoomDatabaseKt$invalidationTrackerFlow$1(this.$emitInitialState, this.$this_invalidationTrackerFlow, this.$tables, i0Io);
        roomDatabaseKt$invalidationTrackerFlow$1.L$0 = obj;
        return roomDatabaseKt$invalidationTrackerFlow$1;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.IXxxXO<? super Set<? extends String>> iXxxXO, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke2((kotlinx.coroutines.channels.IXxxXO<? super Set<String>>) iXxxXO, i0Io);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$observer$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.coroutines.oxoX queryDispatcher;
        final kotlinx.coroutines.oXIO0o0XI XO2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            final kotlinx.coroutines.channels.IXxxXO iXxxXO = (kotlinx.coroutines.channels.IXxxXO) this.L$0;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(this.$emitInitialState);
            final String[] strArr = this.$tables;
            ?? r5 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(@OXOo.OOXIXo Set<String> set) {
                    if (atomicBoolean.get()) {
                        return;
                    }
                    iXxxXO.x0xO0oo(set);
                }
            };
            TransactionElement transactionElement = (TransactionElement) iXxxXO.getCoroutineContext().get(TransactionElement.Key);
            if (transactionElement == null || (queryDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                queryDispatcher = CoroutinesRoomKt.getQueryDispatcher(this.$this_invalidationTrackerFlow);
            }
            XO2 = kotlinx.coroutines.xoIox.XO(iXxxXO, queryDispatcher, null, new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, r5, this.$emitInitialState, iXxxXO, this.$tables, atomicBoolean, null), 2, null);
            Oox.oIX0oI<oXIO0o0XI> oix0oi = new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1.1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    oXIO0o0XI.oIX0oI.II0xO0(kotlinx.coroutines.oXIO0o0XI.this, null, 1, null);
                }
            };
            this.label = 1;
            if (ProduceKt.oIX0oI(iXxxXO, oix0oi, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@OXOo.OOXIXo kotlinx.coroutines.channels.IXxxXO<? super Set<String>> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((RoomDatabaseKt$invalidationTrackerFlow$1) create(iXxxXO, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
