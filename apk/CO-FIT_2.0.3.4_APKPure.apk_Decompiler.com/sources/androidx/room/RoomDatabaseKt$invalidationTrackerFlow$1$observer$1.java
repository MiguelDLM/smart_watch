package androidx.room;

import OXOo.OOXIXo;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.channels.IXxxXO;

public final class RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ IXxxXO<Set<String>> $$this$callbackFlow;
    final /* synthetic */ AtomicBoolean $ignoreInvalidation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$invalidationTrackerFlow$1$observer$1(String[] strArr, AtomicBoolean atomicBoolean, IXxxXO<? super Set<String>> iXxxXO) {
        super(strArr);
        this.$ignoreInvalidation = atomicBoolean;
        this.$$this$callbackFlow = iXxxXO;
    }

    public void onInvalidated(@OOXIXo Set<String> set) {
        if (!this.$ignoreInvalidation.get()) {
            this.$$this$callbackFlow.x0xO0oo(set);
        }
    }
}
