package com.baidu.ar;

/* loaded from: classes7.dex */
public class lh extends dc {
    private li Ee;

    public lh(long j) {
        this.Ee = null;
        setTimestamp(j);
    }

    public li hN() {
        return this.Ee;
    }

    public lh(li liVar) {
        this.Ee = liVar;
        if (liVar != null) {
            setTimestamp(liVar.getTimestamp());
        }
    }
}
