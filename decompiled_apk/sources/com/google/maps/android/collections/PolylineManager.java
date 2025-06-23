package com.google.maps.android.collections;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.collections.MapObjectManager;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class PolylineManager extends MapObjectManager<Polyline, Collection> implements GoogleMap.OnPolylineClickListener {
    public PolylineManager(@NonNull GoogleMap googleMap) {
        super(googleMap);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.PolylineManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
    public void onPolylineClick(Polyline polyline) {
        Collection collection = (Collection) this.mAllObjects.get(polyline);
        if (collection != null && collection.mPolylineClickListener != null) {
            collection.mPolylineClickListener.onPolylineClick(polyline);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Polyline polyline) {
        return super.remove(polyline);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public void setListenersOnUiThread() {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setOnPolylineClickListener(this);
        }
    }

    /* loaded from: classes10.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnPolylineClickListener mPolylineClickListener;

        public Collection() {
            super();
        }

        public void addAll(java.util.Collection<PolylineOptions> collection) {
            Iterator<PolylineOptions> it = collection.iterator();
            while (it.hasNext()) {
                addPolyline(it.next());
            }
        }

        public Polyline addPolyline(PolylineOptions polylineOptions) {
            Polyline addPolyline = PolylineManager.this.mMap.addPolyline(polylineOptions);
            super.add(addPolyline);
            return addPolyline;
        }

        public java.util.Collection<Polyline> getPolylines() {
            return getObjects();
        }

        public void hideAll() {
            Iterator<Polyline> it = getPolylines().iterator();
            while (it.hasNext()) {
                it.next().setVisible(false);
            }
        }

        public boolean remove(Polyline polyline) {
            return super.remove((Collection) polyline);
        }

        public void setOnPolylineClickListener(GoogleMap.OnPolylineClickListener onPolylineClickListener) {
            this.mPolylineClickListener = onPolylineClickListener;
        }

        public void showAll() {
            Iterator<Polyline> it = getPolylines().iterator();
            while (it.hasNext()) {
                it.next().setVisible(true);
            }
        }

        public void addAll(java.util.Collection<PolylineOptions> collection, boolean z) {
            Iterator<PolylineOptions> it = collection.iterator();
            while (it.hasNext()) {
                addPolyline(it.next()).setVisible(z);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.PolylineManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Polyline polyline) {
        polyline.remove();
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }
}
