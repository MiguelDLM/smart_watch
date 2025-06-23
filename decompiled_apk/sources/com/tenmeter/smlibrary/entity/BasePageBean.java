package com.tenmeter.smlibrary.entity;

import java.util.List;

/* loaded from: classes13.dex */
public class BasePageBean<T> {
    private List<T> lists;
    private int totals;

    public List<T> getLists() {
        return this.lists;
    }

    public int getTotals() {
        return this.totals;
    }

    public void setLists(List<T> list) {
        this.lists = list;
    }

    public void setTotals(int i) {
        this.totals = i;
    }
}
