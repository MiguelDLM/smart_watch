package com.jd.ad.sdk.banner.jad_b_an;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* loaded from: classes10.dex */
public class jad_b_dq implements View.OnTouchListener {
    public final /* synthetic */ View jad_b_an;
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_an jad_b_bo;

    public jad_b_dq(com.jd.ad.sdk.banner.jad_b_an jad_b_anVar, View view) {
        this.jad_b_bo = jad_b_anVar;
        this.jad_b_an = view;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        JADMediator.getInstance().getTouchService().onViewTouch(this.jad_b_an, motionEvent, this.jad_b_bo.jad_b_dq);
        return false;
    }
}
