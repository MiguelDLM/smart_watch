package com.baidu.ar;

import com.baidu.ar.libloader.ILibLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class fq {
    private final Map<String, List<ILibLoader.c>> tF = new HashMap();

    private void g(List<ILibLoader.c> list) {
        if (list != null) {
            int size = list.size();
            ILibLoader.c[] cVarArr = new ILibLoader.c[size];
            list.toArray(cVarArr);
            for (int i = 0; i < size; i++) {
                cVarArr[i].onReady();
            }
        }
    }

    public void a(String str, ILibLoader.c cVar) {
        List<ILibLoader.c> list = this.tF.get(str);
        if (list != null) {
            list.add(cVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        this.tF.put(str, arrayList);
    }

    public void aI(String str) {
        if (this.tF.containsKey(str)) {
            this.tF.remove(str);
        }
    }

    public void aJ(String str) {
        g(this.tF.get(str));
    }

    public void clearAll() {
        this.tF.clear();
    }

    public void eh() {
        Iterator<Map.Entry<String, List<ILibLoader.c>>> it = this.tF.entrySet().iterator();
        while (it.hasNext()) {
            g(it.next().getValue());
        }
    }
}
