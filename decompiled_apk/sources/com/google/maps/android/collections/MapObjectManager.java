package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.MapObjectManager.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class MapObjectManager<O, C extends Collection> {
    protected final GoogleMap mMap;
    private final Map<String, C> mNamedCollections = new HashMap();
    protected final Map<O, C> mAllObjects = new HashMap();

    /* loaded from: classes10.dex */
    public class Collection {
        private final Set<O> mObjects = new HashSet();

        public Collection() {
        }

        public void add(O o) {
            this.mObjects.add(o);
            MapObjectManager.this.mAllObjects.put(o, this);
        }

        public void clear() {
            for (O o : this.mObjects) {
                MapObjectManager.this.removeObjectFromMap(o);
                MapObjectManager.this.mAllObjects.remove(o);
            }
            this.mObjects.clear();
        }

        public java.util.Collection<O> getObjects() {
            return Collections.unmodifiableCollection(this.mObjects);
        }

        public boolean remove(O o) {
            if (this.mObjects.remove(o)) {
                MapObjectManager.this.mAllObjects.remove(o);
                MapObjectManager.this.removeObjectFromMap(o);
                return true;
            }
            return false;
        }
    }

    public MapObjectManager(@NonNull GoogleMap googleMap) {
        this.mMap = googleMap;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.maps.android.collections.MapObjectManager.1
            @Override // java.lang.Runnable
            public void run() {
                MapObjectManager.this.setListenersOnUiThread();
            }
        });
    }

    public C getCollection(String str) {
        return this.mNamedCollections.get(str);
    }

    public abstract C newCollection();

    public C newCollection(String str) {
        if (this.mNamedCollections.get(str) == null) {
            C newCollection = newCollection();
            this.mNamedCollections.put(str, newCollection);
            return newCollection;
        }
        throw new IllegalArgumentException("collection id is not unique: " + str);
    }

    public boolean remove(O o) {
        C c = this.mAllObjects.get(o);
        if (c != null && c.remove(o)) {
            return true;
        }
        return false;
    }

    public abstract void removeObjectFromMap(O o);

    public abstract void setListenersOnUiThread();
}
