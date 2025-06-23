package com.baidu.ar;

import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public abstract class db implements dj {
    private CopyOnWriteArrayList<df> ot = new CopyOnWriteArrayList<>();
    protected df ou;
    private df ov;
    private dk ow;

    public void c(df dfVar) {
        CopyOnWriteArrayList<df> copyOnWriteArrayList = this.ot;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(dfVar);
        }
    }

    public boolean cM() {
        CopyOnWriteArrayList<df> copyOnWriteArrayList = this.ot;
        return copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0;
    }

    public void d(df dfVar) {
        this.ov = dfVar;
    }

    @Override // com.baidu.ar.dj
    public void release() {
        CopyOnWriteArrayList<df> copyOnWriteArrayList = this.ot;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.ot = null;
        }
    }

    public void b(df dfVar) {
        CopyOnWriteArrayList<df> copyOnWriteArrayList = this.ot;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(dfVar);
            dk dkVar = this.ow;
            if (dkVar != null) {
                dfVar.a(dkVar);
            }
        }
    }

    @Override // com.baidu.ar.dj
    public void a(df dfVar) {
        this.ov = dfVar;
        this.ou = new df() { // from class: com.baidu.ar.db.1
            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (db.this.ot != null && db.this.ot.size() > 0) {
                    Iterator it = db.this.ot.iterator();
                    while (it.hasNext()) {
                        df dfVar2 = (df) it.next();
                        if (dcVar.cO() > 0) {
                            AlgoHandleAdapter.increaseHandleReference(dcVar.cO());
                        }
                        dfVar2.a(dcVar);
                    }
                }
                if (db.this.ov != null) {
                    db.this.ov.a(dcVar);
                }
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
                if (db.this.ov != null) {
                    db.this.ov.b(dkVar);
                }
                if (db.this.ot == null || db.this.ot.size() <= 0) {
                    return;
                }
                Iterator it = db.this.ot.iterator();
                while (it.hasNext()) {
                    ((df) it.next()).b(dkVar);
                }
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                db.this.ow = dkVar;
                if (db.this.ov != null) {
                    db.this.ov.a(dkVar);
                }
                if (db.this.ot == null || db.this.ot.size() <= 0) {
                    return;
                }
                Iterator it = db.this.ot.iterator();
                while (it.hasNext()) {
                    ((df) it.next()).a(dkVar);
                }
            }
        };
    }
}
