package com.baidu.ar;

/* loaded from: classes7.dex */
public abstract class nt implements nv {
    private ox HT;

    @Override // com.baidu.ar.nv
    public ox a(ns nsVar) {
        if (this.HT == null) {
            this.HT = new ox();
        }
        return this.HT;
    }

    @Override // com.baidu.ar.nv
    public void b(ns nsVar, ov ovVar) {
    }

    @Override // com.baidu.ar.nv
    public pi a(ns nsVar, ny nyVar, pa paVar) {
        return new pe();
    }

    @Override // com.baidu.ar.nv
    public void a(ns nsVar, ov ovVar) {
        nsVar.a(new oy((ox) ovVar));
    }

    @Override // com.baidu.ar.nv
    public void a(ns nsVar, pa paVar) {
    }

    @Override // com.baidu.ar.nv
    public void a(ns nsVar, pa paVar, ph phVar) {
    }
}
