package androidx.room;

import OXOo.OOXIXo;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.IIX0o;

public final class InvalidationLiveDataContainer {
    @OOXIXo
    private final RoomDatabase database;
    @OOXIXo
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(@OOXIXo RoomDatabase roomDatabase) {
        IIX0o.x0xO0oo(roomDatabase, "database");
        this.database = roomDatabase;
        Set<LiveData<?>> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        IIX0o.oO(newSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.liveDataSet = newSetFromMap;
    }

    @OOXIXo
    public final <T> LiveData<T> create(@OOXIXo String[] strArr, boolean z, @OOXIXo Callable<T> callable) {
        IIX0o.x0xO0oo(strArr, "tableNames");
        IIX0o.x0xO0oo(callable, "computeFunction");
        return new RoomTrackingLiveData(this.database, this, z, callable, strArr);
    }

    @OOXIXo
    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(@OOXIXo LiveData<?> liveData) {
        IIX0o.x0xO0oo(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(@OOXIXo LiveData<?> liveData) {
        IIX0o.x0xO0oo(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }
}
