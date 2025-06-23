package com.google.maps.android.data.kml;

import com.google.maps.android.data.Geometry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class KmlMultiTrack extends KmlMultiGeometry {
    public KmlMultiTrack(ArrayList<KmlTrack> arrayList) {
        super(createGeometries(arrayList));
    }

    private static ArrayList<Geometry> createGeometries(ArrayList<KmlTrack> arrayList) {
        ArrayList<Geometry> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<KmlTrack> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next());
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("Tracks cannot be null");
    }
}
