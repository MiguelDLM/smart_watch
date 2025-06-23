package com.baidu.ar;

import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class li {
    private ArrayList<TrackModel> Ef;
    private long mTimestamp;
    private boolean vU;
    private boolean vW;

    public li(long j) {
        this.mTimestamp = j;
    }

    public void C(boolean z) {
        this.vU = z;
    }

    public void D(boolean z) {
        this.vW = z;
    }

    public void b(ArrayList<TrackModel> arrayList) {
        this.Ef = arrayList;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public ArrayList<TrackModel> hO() {
        return this.Ef;
    }
}
