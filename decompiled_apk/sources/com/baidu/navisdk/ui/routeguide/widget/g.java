package com.baidu.navisdk.ui.routeguide.widget;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

/* loaded from: classes8.dex */
public abstract class g extends c {
    private int m;

    public g(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        super(context, viewGroup, aVar);
        this.m = i;
    }

    public abstract void A(boolean z);

    public abstract void A0();

    public abstract void a(int i, int i2, Intent intent);

    public abstract boolean y0();

    public int z0() {
        return this.m;
    }
}
