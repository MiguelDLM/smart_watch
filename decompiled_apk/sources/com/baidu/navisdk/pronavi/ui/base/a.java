package com.baidu.navisdk.pronavi.ui.base;

import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.widget.d;

/* loaded from: classes7.dex */
public class a extends d {
    protected b i;

    public a(b bVar, ViewGroup viewGroup) {
        super(bVar.a(), viewGroup);
        this.i = bVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.i = null;
    }
}
