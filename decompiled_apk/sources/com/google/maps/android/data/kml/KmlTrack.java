package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class KmlTrack extends KmlLineString {
    private final HashMap<String, String> mProperties;
    private final ArrayList<Long> mTimestamps;

    public KmlTrack(ArrayList<LatLng> arrayList, ArrayList<Double> arrayList2, ArrayList<Long> arrayList3, HashMap<String, String> hashMap) {
        super(arrayList, arrayList2);
        this.mTimestamps = arrayList3;
        this.mProperties = hashMap;
    }

    public HashMap<String, String> getProperties() {
        return this.mProperties;
    }

    public ArrayList<Long> getTimestamps() {
        return this.mTimestamps;
    }
}
