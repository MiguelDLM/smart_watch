package androidx.room;

import OXOo.OOXIXo;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

public final class RoomTrackingLiveData$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$observer$1(String[] strArr, RoomTrackingLiveData<T> roomTrackingLiveData) {
        super(strArr);
        this.this$0 = roomTrackingLiveData;
    }

    public void onInvalidated(@OOXIXo Set<String> set) {
        IIX0o.x0xO0oo(set, "tables");
        ArchTaskExecutor.getInstance().executeOnMainThread(this.this$0.getInvalidationRunnable());
    }
}
