package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class InvalidationLiveDataContainer {

    @OXOo.OOXIXo
    private final RoomDatabase database;

    @OXOo.OOXIXo
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(@OXOo.OOXIXo RoomDatabase database) {
        IIX0o.x0xO0oo(database, "database");
        this.database = database;
        Set<LiveData<?>> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        IIX0o.oO(newSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.liveDataSet = newSetFromMap;
    }

    @OXOo.OOXIXo
    public final <T> LiveData<T> create(@OXOo.OOXIXo String[] tableNames, boolean z, @OXOo.OOXIXo Callable<T> computeFunction) {
        IIX0o.x0xO0oo(tableNames, "tableNames");
        IIX0o.x0xO0oo(computeFunction, "computeFunction");
        return new RoomTrackingLiveData(this.database, this, z, computeFunction, tableNames);
    }

    @OXOo.OOXIXo
    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(@OXOo.OOXIXo LiveData<?> liveData) {
        IIX0o.x0xO0oo(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(@OXOo.OOXIXo LiveData<?> liveData) {
        IIX0o.x0xO0oo(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }
}
