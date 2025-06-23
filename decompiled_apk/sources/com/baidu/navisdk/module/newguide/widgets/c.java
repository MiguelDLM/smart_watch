package com.baidu.navisdk.module.newguide.widgets;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.navisdk.ui.routeguide.widget.d;

/* loaded from: classes7.dex */
public abstract class c extends d {
    protected LifecycleOwner i;

    public c(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        super(context, viewGroup, aVar);
        a(lifecycleOwner, viewModelStore);
    }

    private void a(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.i = lifecycleOwner;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.i = null;
    }
}
