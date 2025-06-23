package com.baidu.ar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class gu implements gt {
    private List<gr<?, ?>> vp = new ArrayList();

    public gu(gr grVar) {
        d(grVar);
    }

    public static <InT, OutT> gt b(gr<InT, OutT> grVar, InT r1) {
        grVar.d(r1);
        return new gu(grVar);
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        Iterator<gr<?, ?>> it = this.vp.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @Override // com.baidu.ar.gt
    public gt d(gr<?, ?> grVar) {
        if (!this.vp.isEmpty()) {
            this.vp.get(r0.size() - 1).a(grVar);
        }
        this.vp.add(grVar);
        return this;
    }
}
