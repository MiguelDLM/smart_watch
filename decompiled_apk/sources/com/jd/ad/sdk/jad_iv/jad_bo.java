package com.jd.ad.sdk.jad_iv;

import android.view.View;

/* loaded from: classes10.dex */
public class jad_bo implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View jad_an;

    public jad_bo(jad_dq jad_dqVar, View view) {
        this.jad_an = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        View view2 = this.jad_an;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
        }
    }
}
