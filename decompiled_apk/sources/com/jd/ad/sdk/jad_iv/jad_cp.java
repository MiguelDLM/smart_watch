package com.jd.ad.sdk.jad_iv;

import android.view.View;

/* loaded from: classes10.dex */
public class jad_cp implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View jad_an;
    public final /* synthetic */ jad_dq jad_bo;

    public jad_cp(jad_dq jad_dqVar, View view) {
        this.jad_bo = jad_dqVar;
        this.jad_an = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        jad_er jad_erVar = this.jad_bo.jad_bo;
        if (jad_erVar != null) {
            jad_erVar.sendEmptyMessage(1);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        View view2 = this.jad_an;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
        }
    }
}
