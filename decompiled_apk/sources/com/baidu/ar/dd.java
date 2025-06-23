package com.baidu.ar;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class dd extends dc {
    private ArrayList<dc> oA;

    public dd() {
        Z("DetectorGroup");
    }

    public boolean aa(String str) {
        Iterator<dc> it = this.oA.iterator();
        while (it.hasNext()) {
            if (it.next().cN().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void b(dc dcVar) {
        if (this.oA == null) {
            this.oA = new ArrayList<>();
        }
        this.oA.add(dcVar);
    }

    public ArrayList<dc> cP() {
        return this.oA;
    }
}
