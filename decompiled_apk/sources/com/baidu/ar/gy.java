package com.baidu.ar;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public class gy {
    private long mTimestamp = 0;
    private ArrayList<dc> oA;

    public void b(dc dcVar) {
        if (this.oA == null) {
            this.oA = new ArrayList<>();
        }
        this.oA.add(dcVar);
    }

    public ArrayList<dc> eR() {
        return this.oA;
    }
}
