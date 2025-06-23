package com.baidu.ar;

/* loaded from: classes7.dex */
final class cg {
    private cf mm;
    private cf mn;

    public synchronized cf cq() {
        cf cfVar;
        cfVar = this.mm;
        if (cfVar != null) {
            cf cfVar2 = cfVar.ml;
            this.mm = cfVar2;
            if (cfVar2 == null) {
                this.mn = null;
            }
        }
        return cfVar;
    }
}
