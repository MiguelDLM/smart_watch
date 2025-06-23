package com.goodix.ble.libcomx.ptmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class PtSuit {
    private ArrayList<PtCase> testCaseList = new ArrayList<>(32);

    public void abort() {
        Iterator<PtCase> it = this.testCaseList.iterator();
        while (it.hasNext()) {
            it.next().abort();
        }
    }

    public void addCase(PtCase ptCase) {
        this.testCaseList.add(ptCase);
    }

    public PtCase getCase(int i) {
        if (i < this.testCaseList.size()) {
            return this.testCaseList.get(i);
        }
        return null;
    }

    public int getCaseCount() {
        return this.testCaseList.size();
    }

    public List<PtJudge> getResults(List<PtJudge> list) {
        if (list == null) {
            list = new ArrayList<>(this.testCaseList.size() * 8);
        }
        Iterator<PtCase> it = this.testCaseList.iterator();
        while (it.hasNext()) {
            it.next().getResults(list);
        }
        return list;
    }

    public boolean isPass() {
        Iterator<PtCase> it = this.testCaseList.iterator();
        while (it.hasNext()) {
            if (!it.next().isPass()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTested(boolean z) {
        if (z) {
            Iterator<PtCase> it = this.testCaseList.iterator();
            while (it.hasNext()) {
                if (!it.next().isTested(false)) {
                    return false;
                }
            }
            return true;
        }
        Iterator<PtCase> it2 = this.testCaseList.iterator();
        while (it2.hasNext()) {
            if (it2.next().isTested(false)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTesting() {
        Iterator<PtCase> it = this.testCaseList.iterator();
        while (it.hasNext()) {
            if (it.next().isStarted()) {
                return true;
            }
        }
        return false;
    }

    public <T extends PtCase> T getCase(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        Iterator<PtCase> it = this.testCaseList.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (cls.equals(t.getClass())) {
                return t;
            }
        }
        return null;
    }

    public <T extends PtCase> T getCase(String str) {
        if (str == null) {
            return null;
        }
        Iterator<PtCase> it = this.testCaseList.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (str.equals(t.getName())) {
                return t;
            }
        }
        return null;
    }
}
