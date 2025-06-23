package androidx.room;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.I0oOoX;
import kotlin.KotlinNothingValueException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$job$1", f = "RoomDatabaseExt.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
public final class RoomDatabaseKt$invalidationTrackerFlow$1$job$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ IXxxXO<Set<String>> $$this$callbackFlow;
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ AtomicBoolean $ignoreInvalidation;
    final /* synthetic */ RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 $observer;
    final /* synthetic */ String[] $tables;
    final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$invalidationTrackerFlow$1$job$1(RoomDatabase roomDatabase, RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 roomDatabaseKt$invalidationTrackerFlow$1$observer$1, boolean z, IXxxXO<? super Set<String>> iXxxXO, String[] strArr, AtomicBoolean atomicBoolean, I0Io<? super RoomDatabaseKt$invalidationTrackerFlow$1$job$1> i0Io) {
        super(2, i0Io);
        this.$this_invalidationTrackerFlow = roomDatabase;
        this.$observer = roomDatabaseKt$invalidationTrackerFlow$1$observer$1;
        this.$emitInitialState = z;
        this.$$this$callbackFlow = iXxxXO;
        this.$tables = strArr;
        this.$ignoreInvalidation = atomicBoolean;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        return new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, this.$observer, this.$emitInitialState, this.$$this$callbackFlow, this.$tables, this.$ignoreInvalidation, i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            this.$this_invalidationTrackerFlow.getInvalidationTracker().addObserver(this.$observer);
            if (this.$emitInitialState) {
                this.$$this$callbackFlow.x0xO0oo(ArraysKt___ArraysKt.oOIoOOO(this.$tables));
            }
            this.$ignoreInvalidation.set(false);
            this.label = 1;
            if (DelayKt.oIX0oI(this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            try {
                I0oOoX.x0XOIxOo(obj);
            } catch (Throwable th) {
                this.$this_invalidationTrackerFlow.getInvalidationTracker().removeObserver(this.$observer);
                throw th;
            }
        }
        throw new KotlinNothingValueException();
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((RoomDatabaseKt$invalidationTrackerFlow$1$job$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
