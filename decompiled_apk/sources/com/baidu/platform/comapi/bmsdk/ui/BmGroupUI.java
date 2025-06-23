package com.baidu.platform.comapi.bmsdk.ui;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class BmGroupUI extends BmBaseUI {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<BmBaseUI> f9590a;

    private BmGroupUI() {
        super(32, 0L);
        this.f9590a = new ArrayList<>();
    }

    private static native boolean nativeAddView(long j, long j2, int i);

    private static native boolean nativeRemoveAllViews(long j);

    @Override // com.baidu.platform.comapi.bmsdk.ui.BmBaseUI
    public BmBaseUI a(long j) {
        if (this.g == j) {
            return this;
        }
        Iterator<BmBaseUI> it = this.f9590a.iterator();
        while (it.hasNext()) {
            BmBaseUI a2 = it.next().a(j);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public BmGroupUI(int i, long j) {
        super(i, j);
        this.f9590a = new ArrayList<>();
    }
}
