package com.baidu.navisdk.comapi.base;

import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class c {
    private static final String TAG = "Common";
    protected b mObserver;
    protected final ArrayList<b> mObservers = new ArrayList<>();

    public void addObserver(b bVar) {
        if (bVar == null) {
            g gVar = g.F_BASE;
            if (gVar.d()) {
                gVar.e("BNSubject", "The BNObserver is null when addObserver");
                return;
            }
            return;
        }
        synchronized (this.mObservers) {
            try {
                if (this.mObservers.contains(bVar)) {
                    g gVar2 = g.F_BASE;
                    if (gVar2.d()) {
                        gVar2.e("BNSubject", bVar + " is already added.");
                    }
                    return;
                }
                this.mObservers.add(bVar);
                g gVar3 = g.F_BASE;
                if (gVar3.d()) {
                    gVar3.e("BNSubject", "add " + this.mObservers.size() + " " + bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void deleteAllObserver() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e("BNSubject", "delete all");
        }
        synchronized (this.mObservers) {
            this.mObservers.clear();
        }
    }

    public void deleteObserver(b bVar) {
        if (bVar == null) {
            g gVar = g.F_BASE;
            if (gVar.d()) {
                gVar.e("The BNObserver is null.");
                return;
            }
            return;
        }
        synchronized (this.mObservers) {
            try {
                int indexOf = this.mObservers.indexOf(bVar);
                if (indexOf == -1) {
                    g gVar2 = g.F_BASE;
                    if (gVar2.d()) {
                        gVar2.e("BNSubject", bVar + " was not added.");
                    }
                    return;
                }
                g gVar3 = g.F_BASE;
                if (gVar3.d()) {
                    gVar3.e("BNSubject", "delete " + this.mObservers.size() + " " + bVar);
                }
                try {
                    this.mObservers.remove(indexOf);
                } catch (Exception e) {
                    g gVar4 = g.F_BASE;
                    if (gVar4.c()) {
                        gVar4.c("BNSubject", "notifyObservers e: " + e.getMessage());
                    }
                }
                b bVar2 = this.mObserver;
                if (bVar2 != null && bVar2.equals(bVar)) {
                    g gVar5 = g.F_BASE;
                    if (gVar5.d()) {
                        gVar5.e("BNSubject", "remove " + bVar);
                    }
                    this.mObserver = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyObservers(int i, int i2, Object obj) {
        synchronized (this.mObservers) {
            try {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    if (this.mObservers.get(size) == null) {
                        break;
                    }
                    this.mObservers.get(size).update(this, i, i2, obj);
                }
            } catch (Exception e) {
                g gVar = g.F_BASE;
                if (gVar.c()) {
                    gVar.c("BNSubject", "notifyObservers e: " + e.getMessage());
                }
            }
            b bVar = this.mObserver;
            if (bVar != null) {
                bVar.update(this, i, i2, obj);
            }
        }
    }

    public void setObserver(b bVar) {
        this.mObserver = bVar;
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e("BNSubject", "set " + bVar);
        }
    }
}
