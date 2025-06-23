package com.baidu.ar;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class ir {
    protected im yO;
    protected int ze;
    protected boolean zf;
    protected in zg;

    public ir(im imVar, int i, in inVar, boolean z) {
        if (imVar == null || inVar == null) {
            throw null;
        }
        this.yO = imVar;
        this.zg = inVar;
        this.ze = i <= 0 ? 10 : i;
        this.zf = z;
    }

    private boolean l(ij ijVar) {
        Object bC = ijVar.bC("_db_period");
        if (bC != null && (bC instanceof Number)) {
            if (System.currentTimeMillis() - ijVar.getTimestamp() < ((Number) bC).longValue()) {
                return true;
            }
        }
        return false;
    }

    public void a(Context context, List<ij> list) {
        if (list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            this.zg.a(context, list.get(0));
        } else {
            this.zg.a(context, list);
        }
    }

    public List<List<ij>> fZ() {
        synchronized (this.yO) {
            try {
                ArrayList arrayList = new ArrayList();
                if (this.yO.isEmpty()) {
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                int size = this.yO.size();
                ArrayList arrayList3 = new ArrayList();
                for (int i = 0; i < size; i++) {
                    ij ijVar = this.yO.get(i);
                    String fT = ijVar.fT();
                    if (!hashMap.containsKey(fT)) {
                        if (l(ijVar)) {
                            arrayList3.add(Integer.valueOf(i));
                        } else {
                            hashMap.put(fT, 1);
                            arrayList2.add(ijVar);
                            if (arrayList2.size() == this.ze) {
                                arrayList.add(arrayList2);
                                arrayList2 = new ArrayList();
                            }
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    arrayList.add(arrayList2);
                }
                if (!arrayList3.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList(arrayList3.size());
                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                        arrayList4.add(this.yO.remove(((Integer) arrayList3.get(size2)).intValue()));
                    }
                    for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
                        this.yO.k((ij) arrayList4.get(size3));
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean ga() {
        return !this.yO.isEmpty();
    }

    public void save() {
        if (this.zf) {
            synchronized (this.yO) {
                this.yO.flush();
            }
        }
    }

    public void update(int i) {
        synchronized (this.yO) {
            this.yO.N(i);
        }
    }
}
