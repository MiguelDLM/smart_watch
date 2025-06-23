package com.baidu.ar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes7.dex */
public class qc implements pp {
    boolean Kx = false;
    final Map<String, qb> Ky = new HashMap();
    final LinkedBlockingQueue<pw> Kz = new LinkedBlockingQueue<>();

    @Override // com.baidu.ar.pp
    public synchronized pq cO(String str) {
        qb qbVar;
        qbVar = this.Ky.get(str);
        if (qbVar == null) {
            qbVar = new qb(str, this.Kz, this.Kx);
            this.Ky.put(str, qbVar);
        }
        return qbVar;
    }

    public void clear() {
        this.Ky.clear();
        this.Kz.clear();
    }

    public List<qb> kh() {
        return new ArrayList(this.Ky.values());
    }

    public LinkedBlockingQueue<pw> ki() {
        return this.Kz;
    }

    public void kj() {
        this.Kx = true;
    }
}
