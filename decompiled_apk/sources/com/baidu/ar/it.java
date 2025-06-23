package com.baidu.ar;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class it {
    private im zh;
    private ArrayList<ij> zi;
    private int zj;
    private int zk;
    private boolean zl;
    private List<String> zm;
    private a zn;

    /* loaded from: classes7.dex */
    public interface a {
        void M(int i);
    }

    public it(im imVar, int i, int i2) {
        this.zh = imVar;
        i = i <= 0 ? 20 : i;
        this.zj = i;
        this.zk = i2 < i ? i : i2;
        this.zi = new ArrayList<>(this.zj);
        this.zl = false;
        this.zm = null;
        this.zn = null;
    }

    private boolean m(ij ijVar) {
        return bK(ijVar.fS());
    }

    public void a(a aVar) {
        this.zn = aVar;
    }

    public boolean bJ(String str) {
        return !this.zl || bK(str);
    }

    public boolean bK(String str) {
        List<String> list = this.zm;
        return list != null && list.contains(str);
    }

    public int gb() {
        int size = this.zi.size();
        if (size > 0) {
            synchronized (this.zh) {
                this.zh.addAll(this.zi);
            }
            this.zi.clear();
            a aVar = this.zn;
            if (aVar != null) {
                aVar.M(size);
            }
        }
        return size;
    }

    public void j(List<String> list) {
        ArrayList<ij> arrayList;
        this.zm = list;
        this.zl = true;
        if (this.zi.isEmpty()) {
            return;
        }
        List<String> list2 = this.zm;
        if (list2 == null || list2.isEmpty()) {
            this.zi.clear();
            return;
        }
        int size = this.zi.size() - 1;
        while (true) {
            arrayList = this.zi;
            if (size < 0) {
                break;
            }
            if (!this.zm.contains(arrayList.get(size).fS())) {
                this.zm.remove(size);
            }
            size--;
        }
        if (arrayList.size() >= this.zj) {
            gb();
        }
    }

    public boolean n(ij ijVar) {
        if (!this.zl) {
            if (this.zi.size() >= this.zk) {
                return false;
            }
            this.zi.add(ijVar);
            return true;
        }
        if (!m(ijVar)) {
            return false;
        }
        this.zi.add(ijVar);
        if (this.zi.size() >= this.zj) {
            gb();
        }
        return true;
    }
}
